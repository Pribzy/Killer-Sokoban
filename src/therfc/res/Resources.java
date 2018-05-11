package therfc.res;

import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Resources {
    //képek
    public static Image BoxImage;
    public static Image WorkerImage_Player1;
    public static Image WorkerImage_Player2;
    public static Image WorkerImage_Player3;
    public static Image WorkerImage_Player4;
    public static Image HoneyImage;
    public static Image OilImage;
    public static Image SteppableFieldImage;
    public static Image ActiveTargetFieldImage;
    public static Image InActiveTargetFieldImage;
    public static Image OpenHoleImage;
    public static Image CloseHoleImage;
    public static Image SwitchImage;
    public static Image WallImage;

    public static Image ZeroImage_Blue;
    public static Image OneImage_Blue;
    public static Image TwoImage_Blue;
    public static Image ThreeImage_Blue;
    public static Image FourImage_Blue;
    public static Image FiveImage_Blue;

    public static Image OneImage_Red;
    public static Image TwoImage_Red;
    public static Image ThreeImage_Red;
    public static Image FourImage_Red;

    public static BufferedImage Level1;
    public static BufferedImage Level2;
    public static BufferedImage Level3;



    //pályák
    public static File Level_1_map;
    public static File Level_2_map;
    public static File Level_3_map;
    public static File test;

    public static  void load() throws IOException, UnsupportedAudioFileException {
        //képek
       BoxImage= ImageIO.read(new File("src\\therfc\\res\\images\\box.png"));
        WorkerImage_Player1= ImageIO.read(new File("src\\therfc\\res\\images\\worker_1.png"));
        WorkerImage_Player2= ImageIO.read(new File("src\\therfc\\res\\images\\worker_2.png"));
        WorkerImage_Player3= ImageIO.read(new File("src\\therfc\\res\\images\\worker_3.png"));
        WorkerImage_Player4= ImageIO.read(new File("src\\therfc\\res\\images\\worker_4.png"));

        WallImage= ImageIO.read(new File("src\\therfc\\res\\images\\wall.png"));
        SteppableFieldImage= ImageIO.read(new File("src\\therfc\\res\\images\\steppablefield.png"));
        HoneyImage= ImageIO.read(new File("src\\therfc\\res\\images\\honey.png"));
        OilImage= ImageIO.read(new File("src\\therfc\\res\\images\\oil.png"));
        ActiveTargetFieldImage= ImageIO.read(new File("src\\therfc\\res\\images\\activetargetfield.png"));
        InActiveTargetFieldImage= ImageIO.read(new File("src\\therfc\\res\\images\\inactivetargetfield.png"));
        OpenHoleImage= ImageIO.read(new File("src\\therfc\\res\\images\\openhole.png"));
        CloseHoleImage= ImageIO.read(new File("src\\therfc\\res\\images\\closehole.png"));
        SwitchImage= ImageIO.read(new File("src\\therfc\\res\\images\\switch.png"));

        OneImage_Blue = ImageIO.read(new File("src\\therfc\\res\\images\\one_blue.png"));
        TwoImage_Blue = ImageIO.read(new File("src\\therfc\\res\\images\\two_blue.png"));
        ThreeImage_Blue = ImageIO.read(new File("src\\therfc\\res\\images\\three_blue.png"));
        FourImage_Blue = ImageIO.read(new File("src\\therfc\\res\\images\\four_blue.png"));
        ZeroImage_Blue = ImageIO.read(new File("src\\therfc\\res\\images\\zero_blue.png"));
        FiveImage_Blue = ImageIO.read(new File("src\\therfc\\res\\images\\five_blue.png"));

        OneImage_Red = ImageIO.read(new File("src\\therfc\\res\\images\\one_red.png"));
        TwoImage_Red = ImageIO.read(new File("src\\therfc\\res\\images\\two_red.png"));
        ThreeImage_Red = ImageIO.read(new File("src\\therfc\\res\\images\\three_red.png"));
        FourImage_Red = ImageIO.read(new File("src\\therfc\\res\\images\\four_red.png"));

        Level1 = ImageIO.read(new File("src\\therfc\\res\\images\\level1.png"));
        Level2 = ImageIO.read(new File("src\\therfc\\res\\images\\level2.png"));
        Level3 = ImageIO.read(new File("src\\therfc\\res\\images\\level3.png"));


        //pályák
        Level_1_map = new File("src\\therfc\\res\\levels\\level1.txt");
        Level_2_map = new File("src\\therfc\\res\\levels\\level2.txt");
        Level_3_map = new File("src\\therfc\\res\\levels\\level3.txt");
        test = new File("src\\therfc\\res\\levels\\level_test.txt");
    }



}
