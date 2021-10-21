package packageRunner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class demoRun extends Application {

    private static final Image HEROSHEET = new Image(".//img//heros.png");
	private static final Image SCENERY = new Image(".//img//desert.png",1200,600,true,true);

    private static final int COUNT    =  6;
    private static final int OFFSET_X =  8;
    private static final int OFFSET_Y =  0;
    private static final int WIDTH    = 75;
    private static final int HEIGHT   = 100;
       
	final private ImageView imageViewHero = new ImageView(HEROSHEET);
    final private ImageView imageViewSceneryLeft = new ImageView(SCENERY);
    final private ImageView imageViewSceneryRight = new ImageView(SCENERY);

    private long lastTime=0;

    private AnimatedSprite hero = new AnimatedSprite(
		imageViewHero,
        COUNT,
        OFFSET_X, OFFSET_Y,
        WIDTH, HEIGHT
        );

    private Camera camera =new Camera(300,0, hero);
   // private packageRunner.Spring spring =new packageRunner.Spring(hero,camera,0.2);

    public static void main(String[] args) {
        launch(args);
    }

    AnimationTimer timer = new AnimationTimer()
		{public void handle(long time){
			hero.update(time);
		    camera.update(time);
            //imageViewScenery.setX(camera.getX()%(camera.getImageView()).getImage().getWidth()-300);
            double startInScene = camera.getX()%imageViewSceneryLeft.getImage().getWidth();
            double width = imageViewSceneryLeft.getImage().getWidth()-startInScene;

            imageViewSceneryLeft.setViewport(new Rectangle2D (startInScene,200,width,400));
            imageViewSceneryRight.setViewport(new Rectangle2D (0,200,600,400));
            imageViewSceneryRight.setX(width);
            // attention confusion setLayout
            imageViewHero.setX(hero.getX()-camera.getX());
		    lastTime=time;
		}
		};

	public void start(Stage primaryStage) {
        primaryStage.setTitle("Demo of the Runner");

		imageViewHero.setY(250);

    	Group root = new Group();
		Scene scene = new Scene(root,600,400);
        Pane running = new Pane(imageViewSceneryLeft,imageViewSceneryRight,imageViewHero);
        running.setMinSize(600,400);
        running.setMaxSize(600,400);
        root.getChildren().add(running);
        //root.getChildren().add(imageViewSceneryRight);

        //root.getChildren().add(imageViewHero);
		primaryStage.setScene(scene);
        primaryStage.show();
        scene.setOnMouseClicked( (event)->{	System.out.println("Jump");
											hero.jump();
											});
											
		timer.start();
    }
    

}
