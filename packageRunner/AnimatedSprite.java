package packageRunner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class AnimatedSprite extends movingThings {

    private final int count;
    private final int offsetX;
    private final int offsetY;
    private final int width;
    private final int height;

    protected final ImageView imageView;

	private double cycleDurationMs=100;

    private int lastIndex;
    private int attitude=0;
	private boolean jump=false;
    
    
    public AnimatedSprite(
            ImageView imageView, 
            int count,
            int offsetX, int offsetY,
            int width,   int height) {
		super(30,0);
		this.imageView = imageView;
        this.count     = count;
        this.offsetX   = offsetX;
        this.offsetY   = offsetY;
        this.width     = width;
        this.height    = height;
    }
    
    public void jump(){
		vx+=0.1;}

    public void update(long time) {
		ax=0;
		ay=(jump)?-10:1;
		vx+=ax;
		vy=(py>250)?0:vy+ay;
		px+=vx;
		py=(py>250)?250:py+vy;
		//jump=false;

		//if (vx>0) imageView.setViewport(new Rectangle2D(offsetX, , width, height));
        
		int index = (int)Math.floor(((time/1000000)/cycleDurationMs))%count;
		if (index != lastIndex) {
            final int x = (index ) * (width  + offsetX) + offsetX;
            final int y = attitude * (height + offsetY) + offsetY;
            imageView.setViewport(new Rectangle2D(x, y, width, height));
            lastIndex = index;
			}
    }
}
