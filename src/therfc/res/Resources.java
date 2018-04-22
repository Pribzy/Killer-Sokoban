package therfc.res;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Resources {
    //képek
    public static Image BoxImage;
    public static Image WorkerImage;
    public static Image HoneyImage;
    public static Image OilImage;
    public static Image SteppableFieldImage;
    public static Image ActiveTargetFieldImage;
    public static Image InActiveTargetFieldImage;
    public static Image OpenHoleImage;
    public static Image CloseHoleImage;
    public static Image SwitchImage;
    public static Image WallImage;
    //hangok
    public static AudioInputStream WorkerDiedInHoleSound;

    //pályák
    public static File Player_2;
    public static File Player_3;
    public static File Player_4;
    public static File test;

    public static  void load() throws IOException, UnsupportedAudioFileException {
        //képek
       BoxImage= ImageIO.read(new File("src\\therfc\\res\\images\\box.png"));
        WorkerImage= ImageIO.read(new File("src\\therfc\\res\\images\\worker.png"));
        WallImage= ImageIO.read(new File("src\\therfc\\res\\images\\wall.png"));
        SteppableFieldImage= ImageIO.read(new File("src\\therfc\\res\\images\\steppablefield.png"));
        HoneyImage= ImageIO.read(new File("src\\therfc\\res\\images\\honey.png"));
        OilImage= ImageIO.read(new File("src\\therfc\\res\\images\\oil.png"));
        ActiveTargetFieldImage= ImageIO.read(new File("src\\therfc\\res\\images\\activetargetfield.png"));
        InActiveTargetFieldImage= ImageIO.read(new File("src\\therfc\\res\\images\\inactivetargetfield.png"));
        OpenHoleImage= ImageIO.read(new File("src\\therfc\\res\\images\\openhole.png"));
        CloseHoleImage= ImageIO.read(new File("src\\therfc\\res\\images\\closehole.png"));
        SwitchImage= ImageIO.read(new File("src\\therfc\\res\\images\\switch.png"));

        //hangok
//        WorkerDiedInHoleSound = AudioSystem.getAudioInputStream(Resources.class.getResource("res/sounds/puthoney.wav"));
        //pályák
        Player_2 = new File("src\\therfc\\res\\levels\\level_p2.txt");
        test = new File("src\\therfc\\res\\levels\\level_test.txt");
    }

}
