import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor{
private final double FLAP = 1.8;
    private boolean oldSpace = false;
    private double yVel = 0;
    private double y = 300;
    private boolean oldTouchingPipe = false;
    private static boolean dead;
    public Player(double yVel){
        GreenfootImage image = getImage();
        image.scale(46, 34);
        dead = false;
        this.yVel = yVel;
    }
    public Player(){
        this(0);
    }
    public void act() 
    {
        yVel += 0.02;
        if(spacePressed()){
            yVel = -FLAP;
        }
        y += yVel;
        setLocation(getX(), y);
        setRotation((int)(yVel * 16));
        if(isAtEdge()){
            dead = true;
        }
    }
    public boolean spacePressed(){
        boolean pressed = false;
        if(Greenfoot.isKeyDown("space")){
            if(!oldSpace){
                pressed = true;
            }
            oldSpace = true;
        }
        else{
            oldSpace = false;
        }
        return pressed;
    }
    public static boolean isAlive(){
        return !dead;
    }
    public void setLocation(double x, double y){
        super.setLocation((int)x, (int)y);
    }
}
