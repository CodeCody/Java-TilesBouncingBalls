import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

/**
 * Created by codyhammond on 8/11/16.
 */
public class TestPane extends JPanel
{

    //two dimensional array to represent grid
    private final int row=8,col=8;
    private int[][] virtualTiles=new int [row][col];
    //variables to keep track of the grid dimensions
    private int startX,startY,endX,endY;
    //final variable to hold length and height of square
    private final int squareside=25;
    //reset button
    private JButton reset;



    //Pane contructor
    public TestPane()
    {
        //set layout
        setLayout(new BorderLayout());

        //initialize button
        reset=new JButton();
        //set text
        reset.setText("Reset");
        //add action listener
        reset.addActionListener(new ActionListener()
        {
            //Function sets all elements in 2D array to zero
            @Override
            public void actionPerformed(ActionEvent e)
            {
                for(int i=0;i<row;i++)
                    Arrays.fill(virtualTiles[i],0);

                repaint();
            }
        });
        //add button to pane
        JPanel panel= new JPanel();
        add(panel,BorderLayout.SOUTH);
        panel.add(reset);
        //mouse Handler interface
        MouseAdapter mouseHandler;
        mouseHandler = new MouseAdapter() {

            //Function determining which cell to draw image in.
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Point point = e.getPoint();

                //get x and y coordinates of mouse click
                int areaX=e.getX();
                int areaY=e.getY();

                //if the mouse click lies somewhere on the grid
                if((areaX>=startX && areaX <= endX) && (areaY >= startY && areaY <= endY))
                {
                    //search through columns
                    for(int i=0;i<col;i++)
                    {
                        //find where x coordinate lies on grid
                        if((startX+(i*squareside)) <= areaX && (startX+((i+1)*squareside)) >= areaX)
                        {
                            areaX=i;//assign areaX the value of i
                            break;
                        }

                    }
                    //search through rows
                    for(int j=0;j<row; j++)
                    {
                        //find where y coordinate lies on grid
                        if((startY+(j*squareside)) <= areaY && (startY+((j+1)*squareside)) >= areaY)
                        {
                            areaY=j;//assign areaY the value of i
                            break;
                        }

                    }
                    //set 2D array with the value of the selected button
                    virtualTiles[areaY][areaX]=TileDesigner.selected;
                }

                //call repaint to update grid
                repaint();
            }

        };
        addMouseListener(mouseHandler);//add mouse handler
    }

    //Overrided function to customize size
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }


    //Paint component functino is called every time panel is repainted
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //get grid width and grid height
        int gridWidth=row*squareside;
        int gridHeight=col*squareside;
        //get starting point of grid
        startX=(getWidth()-gridWidth)/2;
        startY=(getHeight()-gridHeight)/2;
        //get ending point of grid
        endX=startX+(row*squareside);
        endY=startY+(col*squareside);


        //nested loop for drawing grid
        for(int i=0; i < row;i++)
        {
            for(int j=0; j< col;j++)
            {
                int image=virtualTiles[i][j];//get value from 2D array
                //switch statement for value of image
                switch(image)
                {
                    //paint empty tile
                    case -1:
                        g.drawRect(startX+(squareside*j),startY+(squareside*i),squareside,squareside);
                        break;
                    //paint empty tile
                    case 0:
                        g.drawRect(startX+(squareside*j),startY+(squareside*i),squareside,squareside);
                        break;
                    //paint image 1
                    case 1:
                        g.drawImage(TileDesigner.images[image-1],startX+(squareside*j),startY+(squareside*i), squareside,squareside, this);
                        break;
                    //paint image 2
                    case 2:
                        g.drawImage(TileDesigner.images[image-1],startX+(squareside*j),startY+(squareside*i), squareside,squareside, this);
                        break;
                    //paint image 3
                    case 3:
                        g.drawImage(TileDesigner.images[image-1],startX+(squareside*j),startY+(squareside*i), squareside,squareside, this);
                        break;
                    //paint image 4
                    case 4:
                        g.drawImage(TileDesigner.images[image-1],startX+(squareside*j),startY+(squareside*i), squareside, squareside, this);
                        break;
                    //paint image 5
                    case 5:
                        g.drawImage(TileDesigner.images[image-1],startX+(squareside*j),startY+(squareside*i), squareside,squareside, this);
                        break;
                    case 6:
                        g.drawImage(TileDesigner.images[image-1],startX+(squareside*j),startY+(squareside*i), squareside,squareside, this);
                        break;
                    case 7:
                        g.drawImage(TileDesigner.images[image-1],startX+(squareside*j),startY+(squareside*i), squareside,squareside, this);
                        break;
                    case 8:
                        g.drawImage(TileDesigner.images[image-1],startX+(squareside*j),startY+(squareside*i), squareside, squareside, this);
                        break;

                }

            }
        }
    }
}
