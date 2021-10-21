package packageRunner;

import java.io.FileOutputStream;

public class Camera extends movingThings{

	private AnimatedSprite hero;
	final private double k=2;		//k/m
	final private double f=0.2;		//f/m

	private FileOutputStream fos;
	long lastTime=0;

	public Camera(double x, double y, AnimatedSprite h){
		super(x,y);
		this.hero=h;
	/*	try {fos= new FileOutputStream(new File("packageRunner.Spring.csv"));} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
	}



	public void update(long time){
		double deltaTime=(time-lastTime)/1000000000.0; //deltaTime in seconds.
		if (deltaTime<1){						// to avoid first execution
			px=px+vx*deltaTime;
			py=py+vy*deltaTime;
			vx=vx+ax*deltaTime;
			vy=vy+ay*deltaTime;
			ax=k*(hero.getX()-this.getX())-f*vx;
			ay=k*(hero.getY()-this.getY())-f*vx;
		/*	System.out.println("deltaTime : "+deltaTime*1000 +"\tx="+px+"\tvx="+vx);
			try{fos.write((deltaTime+","+px+","+vx+","+ax+"\n").getBytes(StandardCharsets.UTF_8));} catch (IOException e) {
				e.printStackTrace();
			}*/
		}
		lastTime=time;
	}
}
