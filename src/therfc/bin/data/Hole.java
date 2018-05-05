package therfc.bin.data;

import therfc.bin.main.Logger;

import therfc.res.Resources;
import therfc.res.Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import static javax.sound.sampled.AudioSystem.*;

/**
 *
 */
public class Hole extends Field {


    //attribútumok
    private Boolean open;
    private Logger logger = new Logger();

    //konstruktor
    public Hole() {
    }


    //függvények

    /**
     *
     * @param b Megkapja paraméterként a dobozt, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a dobozt foja tenni
     */
    public void StepOn(Box b, Direction d) { //hogyan kezeli le,hogyha doboz akar rálépni
        //logger.Enter(this, "StepOn", "b,d");
        if (!open) {
            Moveable moveable = this.GetMoveable();
            Field previousField = neighbors.get(d.OppositeDirection());
            if (moveable != null) {
                Worker w = b.GetWorker();
                moveable.Push(w, d);
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
        } else {
            b.Die();
            try {
                Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\DobozLyukbaEsik.wav")));
                sound.Play();
            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
        }
        //logger.Exit(this, "StepOn", "b stepped on wall");
    }


    /**
     *
     * @param w Megkapja paraméterként a munkást, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a munkást fogja tenni
     */
    public void StepOn(Worker w, Direction d) {  //hogyan kezeli le,hogyha worker akar rálépni
        //logger.Enter(this, "StepOn", "w,d");
        if (!open) {
            Moveable moveable = this.GetMoveable();
            Field previousField = neighbors.get(d.OppositeDirection());
            if (moveable != null) {
                moveable.Push(w, d);
                if (this.GetMoveable() == null) {
                    previousField.RemoveMoveable(w);
                    this.AddMoveable(w);
                }
            } else {
                previousField.RemoveMoveable(w);
                this.AddMoveable(w);
            }
        } else {
            w.Die();



            try {
                Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\WorkerDiedInHole.wav")));
                sound.Play();
            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }




        }
       // logger.Exit(this, "StepOn", "w stepped on wall");
    }

    /**
     *
     * @param o A paraméterként kapott állapotra állítja a lyuk állapotát
     */
    public void SetOpen(Boolean o) { //beállítja a lyukát nyitottra (true), vagy zártra (false)
        //logger.Enter(this, "SetOpen", String.valueOf(o));
        if(o) {
            if (this.GetMoveable() != null) {
                this.GetMoveable().Die();
            }
            this.RemoveTrap();
        }
        this.open = o;
        //logger.Exit(this, "SetOpen", "hole set to " + String.valueOf(o));
    }

    /**
     *
     * @return Visszatér a lyuk állapotával
     */
    public Boolean GetOpen(){
        return open;
    }


}