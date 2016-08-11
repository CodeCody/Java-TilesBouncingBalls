import javax.swing.*;

/**
 * Created by codyhammond on 8/11/16.
 */
public class Main {

    public static void main(String [] args)
    {
        TileDesigner tileDesigner=new TileDesigner();
        tileDesigner.show();

        tileDesigner.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
