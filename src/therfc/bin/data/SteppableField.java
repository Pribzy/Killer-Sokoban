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
public class SteppableField extends Field {

    //attribútumok
    private Logger logger = new Logger();

    //konstruktor
    public SteppableField() {
    }

    //függvények

    /**
     *
     * @param w Megkapja paraméterként a munkást, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a munkást fogja tenni
     */
    public void StepOn(Worker w, Direction d) {// Ez történik Ha egy munkás a SteppableFIeld-re lép
       // logger.Enter(this, "StepOn", "w,d");

        if (this.GetMoveable() != null) {

                    this.GetMoveable().Push(w, d);
                    if (this.GetMoveable() == null) {
                        try {
                            Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\WorkerMove.wav")));
                            sound.Play();
                        } catch (UnsupportedAudioFileException | IOException e) {
                            e.printStackTrace();
                        }
                        neighbors.get(d.OppositeDirection()).RemoveMoveable(w);
                        this.AddMoveable(w);
                    }

        } else {
            try {
                Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\WorkerMove.wav")));
                sound.Play();
            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
            neighbors.get(d.OppositeDirection()).RemoveMoveable(w);
            this.AddMoveable(w);
        }
        //logger.Exit(this, "StepOn", "w stepped on this field");
    }

    /**
     *
     * @param b Megkapja paraméterként a dobozt, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a dobozt foja tenni
     */
    public void StepOn(Box b, Direction d) {// Ez történik Ha egy doboz a SteppableFIeld-re lép
       // logger.Enter(this, "StepOn", "b,d");
        Field previousField = neighbors.get(d.OppositeDirection());
        if (this.GetMoveable() != null) {
            Worker pushWorker = b.GetWorker();
            this.GetMoveable().Push(pushWorker, d);
            if (this.GetMoveable() == null) {
                previousField.RemoveMoveable(b);
                this.AddMoveable(b);

                try {
                    Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\DobozSteppableFieldreTolodik.wav")));
                    sound.Play();
                } catch (UnsupportedAudioFileException | IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            previousField.RemoveMoveable(b);
            this.AddMoveable(b);
            try {
                Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\DobozSteppableFieldreTolodik.wav")));
                sound.Play();
            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
        }
      //  logger.Exit(this, "StepOn", "b stepped on this field");
    }




}