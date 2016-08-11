import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by codyhammond on 8/11/16.
 */
class BallPane extends JPanel
{
    private Animation animation;//animation panel for balls

    //Ballpane constructor
    public BallPane()
    {
        //setlayout for panel
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JButton start=new JButton("Start");//initialize start button
        JButton stop=new JButton("Stop");//initialize the stop button
        stop.setEnabled(false);
        //add action listener to start button
        start.addActionListener( a -> {
            start.setEnabled(false);
            stop.setEnabled(true);

            animation.run();//call the run function

        });


        //add action listener to stop button
        stop.addActionListener(a -> {
            start.setEnabled(true);
            stop.setEnabled(false);
            animation.stop();//call the stop button
        });

        Ball.d=getSize();
        animation=new Animation();//allocate animation panel


        add(animation);//add panel to the ballpane
        JPanel Bpanel=new JPanel();//initialze button panel
        Bpanel.add(start);//add start and stop buttons
        Bpanel.add(stop);
        Bpanel.setBackground(Color.LIGHT_GRAY);
        add(Bpanel,BorderLayout.SOUTH);//put button panel to the soutch
    }
}


//Animation panel where the balls will be displayed
class Animation extends JPanel
{
    //name of audio file
    String wav="F_Zero_GX_Night_of_Big_Blue.wav";


    private ArrayList<Ball> balls=new ArrayList<>();//arraylist of balls
    private Clip clip;//clip object to assist audio playback
    private Thread thread=null;//Thread object assigned null value
    private Dimension d=new Dimension(423,417);//set dimension
    //Animatino contructor
    public Animation()
    {
        setLayout(new BorderLayout());//set the layout

        //try-catch block in case file not found
        try
        {
            //locate audio file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(wav).getAbsoluteFile());
            clip = AudioSystem.getClip();//get audio data
            clip.open(audioInputStream);//connet to audio data

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());//print message to console
        }

        //Add balls to array list and set movement pattern
        balls.add(new Ball(Color.RED,d.height/2,d.width/2,30));
        balls.add(new Ball(Color.GREEN,d.height/2,d.width/2,30));
        balls.add(new Ball(Color.MAGENTA,d.height/2,d.width/2,30));
        balls.add(new Ball(Color.ORANGE,d.height/2,d.width/2,30));
        balls.add(new Ball(Color.GRAY,d.height/2,d.width/2,30));
        balls.add(new Ball(Color.PINK,d.height/2,d.width/2,30));
        balls.add(new Ball(Color.LIGHT_GRAY,d.height/2,d.width/2,30));
        balls.add(new Ball(Color.BLACK,d.height/2,d.width/2,30));
        balls.get(0).setMovement(0, 5);
        balls.get(1).setMovement(0,-5);
        balls.get(2).setMovement(5,0);
        balls.get(3).setMovement(-5,0);
        balls.get(4).setMovement(5, 5);
        balls.get(5).setMovement(5,-5);
        balls.get(6).setMovement(-5,5);
        balls.get(7).setMovement(-5,-5);


    }


    //Overrided paintComponent
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Ball.d=getSize();//get dimension of animation panel;
        //for each loop to draw balls
        for(Ball ball : balls)
        {
            g.setColor(ball.color);
            g.fillOval(ball.x, ball.y, ball.radius, ball.radius);


        }
    }


    //Method that contains second thread logic
    public final void run()
    {

        if(thread==null)//if thread is null
        {
            clip.loop(Clip.LOOP_CONTINUOUSLY);//set clip to play audio in loop
            //initialize thread with runnable interface,override run method
            thread=new Thread(()->
            {
                clip.start();//start the clip
                while(Thread.currentThread()==thread)//if current thread is equal to thread
                {
                    for(Ball ball : balls)//move balls in arraylist
                    {
                        ball.move();
                    }
                    repaint();//repaint panel
                    try
                    {
                        Thread.sleep(100);//sleep for 100 milliseconds
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }



                }
            });
            thread.start();//start thread
        }

    }

    //stop method to end animation thread and stop music
    public void stop()
    {
        thread=null;//set thread to null
        clip.stop();//stop playback
    }

}