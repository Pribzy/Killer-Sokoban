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
public class Switch extends Field {


    //attribútumok
    private Hole hole;
    private Logger logger = new Logger();

    //konstruktor
    public Switch() {
    }

    //függvények

    /**
     * @param w Megkapja paraméterként a munkást, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a munkást fogja tenni
     */
    public void StepOn(Worker w, Direction d) {// Ez történik Ha egy munkás Switchre lép
        // logger.Enter(this, "StepOn", "w,d");
        Field previousField = neighbors.get(d.OppositeDirection());
        if (this.GetMoveable() != null) {
            this.GetMoveable().Push(w, d);
            if (this.GetMoveable() == null) {
                try {
                    Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\WorkerMove.wav")));
                    sound.Play();
                } catch (UnsupportedAudioFileException | IOException e) {
                    e.printStackTrace();
                }
                previousField.RemoveMoveable(w);
                this.AddMoveable(w);
            }
        } else {
            try {
                Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\WorkerMove.wav")));
                sound.Play();
            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
            previousField.RemoveMoveable(w);
            this.AddMoveable(w);
        }
        // logger.Exit(this, "StepOn", "w stepped on switch");
    }

    /**
     * @param b Megkapja paraméterként a dobozt, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a dobozt foja tenni
     */
    public void StepOn(Box b, Direction d) {// Ez történik Ha egy doboz Sitch-re lép
        //logger.Enter(this, "StepOn", "b,d");
        Field previousField = neighbors.get(d.OppositeDirection());
        if (this.GetMoveable() != null) {
            Worker pushWorker = b.GetWorker();
            this.GetMoveable().Push(pushWorker, d);
            if (this.GetMoveable() == null) {
                previousField.RemoveMoveable(b);
                this.AddMoveable(b);
                try {
                    Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\HoleClose.wav")));
                    sound.Play();
                } catch (UnsupportedAudioFileException | IOException e) {
                    e.printStackTrace();
                }
                hole.SetOpen(true);

            }
        } else {
            try {
                Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\HoleClose.wav")));
                sound.Play();
            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
            previousField.RemoveMoveable(b);
            this.AddMoveable(b);
            hole.SetOpen(true);

        }
        //logger.Exit(this, "StepOn", "b stepped on switch");
    }

    /**
     * @param h Beállítja a hozzátartozó lyukat
     */
    public void SetHole(Hole h) { //Beállítja a lyukát
        this.hole = h;

    }

    /**
     * @param m Leveszi magáról a Moveable objektumot a mező
     */
    @Override
    public void RemoveMoveable(Moveable m) {
        //logger.Enter(this,"RemoveMoveable",logger.GetObjectName(m));
        this.moveable = null;
        try {
            Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\HoleOpen.wav")));
            sound.Play();
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        hole.SetOpen(false);


        }
        // logger.Exit(this,"RemoveMoveable",logger.GetObjectName(m)+" removed from "+logger.GetObjectName(this));

    }


