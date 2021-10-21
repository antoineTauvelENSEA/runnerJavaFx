package packageRunner;

public class Spring {
    final private double k;
    final private AnimatedSprite hero;
    final private Camera camera;
    public Spring(AnimatedSprite h, Camera c, double k){
        hero=h;
        camera=c;
        this.k=k;
    }

    public double getForceX(){
        return k*(hero.getX()-camera.getX());
    }

    public double getForceY(){
        return k*(hero.getY()-camera.getY());
    }
}
