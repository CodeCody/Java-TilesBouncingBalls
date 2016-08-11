import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by codyhammond on 8/11/16.
 */
public class TileDesigner extends JFrame
{
    //Buttons for the JTtoolbar
    private JButton image1,image2,image3,image4,image5,image6,image7,image8;
    //names of the image files
    private  final String[] names={"pat1.gif","pat2.gif","pat3.gif","pat4.gif","pat5.gif","pat6.gif","pat7.gif","pat8.gif"};
    //array to hold images
    public static Image[] images=new Image[8];
    //variable to indicate selected button
    public static int selected=-1;
    private JToolBar toolbar;//tool bar
    private Image image;//image variable

    //Class contructor
    public TileDesigner()
    {
        //set dimension and size
        Dimension d=new Dimension(400,400);
        setSize(800,500);
        setLayout(new BorderLayout());
        //Initialize buttons and set the action listners

        setResizable(false);
        image1=new JButton();
        image1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selected=1;
            }
        });

        image2=new JButton();
        image2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selected=2;
            }
        });

        image3=new JButton();
        image3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selected=3;
            }
        });

        image4=new JButton();
        image4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selected=4;
            }
        });

        image5=new JButton();
        image5.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selected=5;
            }
        });

        image6=new JButton();
        image6.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selected=6;
            }
        });

        image7=new JButton();
        image7.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selected=7;
            }
        });

        image8=new JButton();
        image8.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selected=8;
            }
        });

        //Get the images using Toolkit and assign them to image array
        images[0]=(Image)Toolkit.getDefaultToolkit().getImage(names[0]);
        image1.setSize(d);
        image1.setIcon(new ImageIcon(images[0]));

        images[1]=(Image)Toolkit.getDefaultToolkit().getImage(names[1]);
        image2.setSize(d);
        image2.setIcon(new ImageIcon(images[1]));

        images[2]=(Image)Toolkit.getDefaultToolkit().getImage(names[2]);
        image3.setSize(d);
        image3.setIcon(new ImageIcon(images[2]));

        images[3]=(Image)Toolkit.getDefaultToolkit().getImage(names[3]);
        image4.setSize(d);
        image4.setIcon(new ImageIcon(images[3]));

        images[4]=(Image)Toolkit.getDefaultToolkit().getImage(names[4]);
        image5.setSize(d);
        image5.setIcon(new ImageIcon(images[4]));

        images[5]=(Image)Toolkit.getDefaultToolkit().getImage(names[5]);
        image6.setSize(d);
        image6.setIcon(new ImageIcon(images[5]));

        images[6]=(Image)Toolkit.getDefaultToolkit().getImage(names[6]);
        image7.setSize(d);
        image7.setIcon(new ImageIcon(images[6]));

        images[7]=(Image)Toolkit.getDefaultToolkit().getImage(names[7]);
        image8.setSize(d);
        image8.setIcon(new ImageIcon(images[7]));
        JFrame frame=new JFrame();



        //Initialize JToolBar
        toolbar=new JToolBar();
        //set size
        //  toolbar.setSize(new Dimension(getHeight(),getWidth()/2));
        //set layout
        toolbar.setLayout(new FlowLayout());
        //add the image buttons to JToolBar
        toolbar.add(image1);
        toolbar.add(image2);
        toolbar.add(image3);
        toolbar.add(image4);
        toolbar.add(image5);
        toolbar.add(image6);
        toolbar.add(image7);
        toolbar.add(image8);
        //add tool bar to frame
        JPanel panel1=new JPanel();
        panel1.setSize(getHeight(), getWidth());
        panel1.setBackground(Color.BLUE);

        //panel1.setSize(getWidth()/2,getHeight());
        JPanel panel2=new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(toolbar,BorderLayout.NORTH);
        TestPane pane=new TestPane();

        panel1.add(pane);

        panel2.setBackground(Color.BLACK);
        // panel2.setSize(getHeight(),getWidth()/2);
        //     getContentPane().add(toolbar,BorderLayout.NORTH);
        //add pane with grid to frame
        //   getContentPane().add(new TestPane());
        getContentPane().add(panel1,BorderLayout.WEST);
        getContentPane().add(new BallPane());
    }
    public static void main(String args[])
    {
        //Allocate frame and configure settings
        TileDesigner frame=new TileDesigner();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        //    frame.pack();
        frame.setVisible(true);
    }

}
