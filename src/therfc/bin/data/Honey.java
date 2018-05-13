package therfc.bin.data;

import therfc.bin.main.Logger;
import therfc.res.Sound;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;

public class Honey extends Trap {
    private Logger logger = new Logger();

    /**
     *
     * @param m A paraméterként megkapott Moveable objektum tapadását megnöveli amikor rálép a mezőre
     */
    @Override
    public  void ChangeTractionWhenStepOn(Moveable m) {//ez történik a paraméterként kapott Moveable tapadásával ha rálép a csapdára
       // logger.Enter(this,"ChangeTractionWhenStepOn",logger.GetObjectName(m));
        try {
            Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\BoxOnOilOrHoney.wav")));
            sound.Play();
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        m.ChangeTraction(1);
       // logger.Exit(this,"ChangeTractionWhenStepOn","Traction changed");
    }

    /**
     *
     * @param m A paraméterként megkapott Moveable objektum tapadását csökkenti amikor lelép a mezőre
     */
    @Override
    public  void  ChangeTractionWhenStepOff(Moveable m) {//ez történik a paraméterként kapott Moveable tapadásával ha lelép a csapdáról
        //logger.Enter(this,"ChangeTractionWhenStepOff",logger.GetObjectName(m));
        m.ChangeTraction(-1);
        //logger.Exit(this,"ChangeTractionWhenStepOff","traction changed");
    }
}
