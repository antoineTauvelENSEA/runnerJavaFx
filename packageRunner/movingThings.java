package packageRunner;

import javafx.scene.image.ImageView;

public abstract class movingThings {
    protected double px;
    protected double py;
    protected double vx;
    protected double vy;
    protected double ax;
    protected double ay;


    public movingThings(double x, double y)
    {px=x;
    py=y;}

    public double getX(){
        return px;
    }

    public double getY(){
        return py;
    }

    public abstract void update(long time);
}
