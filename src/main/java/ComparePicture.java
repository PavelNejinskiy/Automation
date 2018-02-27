import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ComparePicture {

    public void compare()
    {
        BufferedImage screen = null;
        try {
            screen = ImageIO.read(new File("C:\\123.png"));
        } catch (IOException e) {
        }

        int w = screen.getWidth();
        int h = screen.getHeight();

        int[][] screenArray = new int[w][h];

        for( int i = 0; i < w; i++ )
            for( int j = 0; j < h; j++ )
                screenArray[i][j] = screen.getRGB( i, j );

        BufferedImage screen2 = null;
        try {
            screen2 = ImageIO.read(new File("C:\\123.png"));
        } catch (IOException e) {
        }

        int w2 = screen2.getWidth();
        int h2 = screen2.getHeight();

        int[][] screenArray2 = new int[w2][h2];

        for( int i = 0; i < w2; i++ )
            for( int j = 0; j < h2; j++ )
                screenArray2[i][j] = screen2.getRGB( i, j );


        if(Arrays.deepEquals(screenArray, screenArray2)){
            System.out.print("Hi");
        }
    }
}
