import java.awt.*;

/**
 * Created by codyhammond on 8/11/16.
 */
class Ball {
    //private fields for the characteristics of each ball
    public Color color;
    public int radius;
    public int x;
    public int y;
    private int dx;
    private int dy;
    private int rangex;
    private int rangey;

    public static Dimension d;
    //Ball constructor takes 5 argumemens. Color of ball, center point of circle and radius of cirlce
    public Ball(Color color,int x,int y,int radius)
    {
        //initialize data members
        this.color=color;
        this.x=x;
        this.y=y;
        this.radius=radius;
        rangex=x+radius;//range variables assist border collision detection.
        rangey=y+radius;
    }


    //move method which moves the balls across the animation panel
    public void move()
    {
        //if the range of the width radius of a circle is greater than the border && is also greater than 20
        if((rangex+dx <= d.width) && (rangex+dx >= 20))
            x+=dx;//add the movement amound to the x coordinate
        else
        {
            dx*=-1;//if ball has hit border multiple the change by -1 to switch direction
            x+=dx;//add change to x coordinate
        }
        rangex=x+radius;//update the range of the x-axis of circle
        //if rangey+dy is less than the height border and rangey+dy is greater or equal to 0
        if((rangey+dy <= d.height) && (rangey+dy >= 20))
        {
            y+=dy;//update y coordinate
        }
        else
        {
            dy*=-1;//invert change value
            y+=dy;//update y coordinate
        }
        rangey=y+radius;//update range

    }

    //This function sets the movement patterns of the balls
    public void setMovement(int changex,int changey)
    {
        this.dx=changex;
        this.dy=changey;
    }

    //this function draws the balls
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillOval(d.height/2, d.width/2, radius*2, radius*2);
    }


}