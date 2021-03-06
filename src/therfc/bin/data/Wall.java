package therfc.bin.data;
import therfc.bin.main.Logger;
import therfc.res.Sound;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;

/**
 * 
 */
public class Wall extends Field {

    private Logger logger = new Logger();

    //konstruktor
    public Wall() {
    }

    //függvények

    /**
     *
     * @param w Megkapja paraméterként a munkást, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a munkást fogja tenni
     */
    public void StepOn(Worker w, Direction d) { // Ez történik Ha egy munkés Wall-re lép
        //logger.Enter(this, "StepOn", "w,d");
        Boolean pushed = w.GetPushed();
        if (pushed) {

            Field previousField =  neighbors.get(d.OppositeDirection()).GetPreviousField(d);
            Boolean canPushToWall =previousField.GetMoveablePushedToWall();
            if (canPushToWall) {
                try {
                    Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\WorkerDiedAtWall.wav")));
                    sound.Play();
                } catch (UnsupportedAudioFileException | IOException e) {
                    e.printStackTrace();
                }
                w.Die();
            }
        }
        try {
            Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\WorkerStepOnWall.wav")));
            sound.Play();
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        //logger.Exit(this, "StepOn", "w tried to step on wall");
    }

    /**
     *
     * @param b Megkapja paraméterként a dobozt, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a dobozt foja tenni
     */
    public void StepOn(Box b, Direction d) { // Ez történik Ha egy doboz Wall-re lép
       // logger.Enter(this, "StepOn", "b,d");
        try {
            Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\DobozFalraTolodik.wav")));
            sound.Play();
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
       // logger.Exit(this, "StepOn", "b stepped on wall");
    }

    /**
     *
     * @return Visszatér, hogy rá léphetnek-e
     */
    @Override
    public Boolean CheckStepOn() {
       // logger.Enter(this, "CheckStepOn", "");
        Boolean check= false;
        //logger.Exit(this,"CheckStepOn",String.valueOf(check));
        return check;
    }


}