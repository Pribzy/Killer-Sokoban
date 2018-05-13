package therfc.bin.data;
import therfc.bin.IO.IO;
import therfc.bin.main.Logger;
import therfc.res.Sound;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;

/**
 * 
 */
public class TargetField extends Field {


    //attribútumok
    private Boolean active; //ha ==true, akkor lehet rá tolni dobozt és kap pontot a játékos, ha ==false,akkor már nem kap érte pontot
    private Logger logger = new Logger();

    //konstruktor
    public TargetField() {
        this.active = true;
    }

    //függvények

    /**
     *
     * @param w Megkapja paraméterként a munkást, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a munkást fogja tenni
     */
    public void StepOn(Worker w, Direction d) { // Ez történik Ha egy munkás Targetfield-re lép
        //logger.Enter(this,"StepOn","w,d");
        Moveable moveable = this.GetMoveable();
        Field previousField = neighbors.get(d.OppositeDirection());
        if (moveable != null) {
            moveable.Push(w,d);
            if (this.GetMoveable() == null){
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
        //logger.Exit(this,"StepOn","Worker stepped on targetField");
    }

    /**
     *
     * @param b Megkapja paraméterként a dobozt, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a dobozt foja tenni
     */
    public void StepOn(Box b, Direction d) {// Ez történik Ha egy doboz TargetField-re lép
       // logger.Enter(this,"StepOn","b,d");
        Worker worker = b.GetWorker();
        Moveable moveable = this.GetMoveable();
        Field previousField = neighbors.get(d.OppositeDirection());
        IO io = new IO();
        if (!active){
            if (moveable != null) {
                moveable.Push(worker,d);
                if (this.GetMoveable() == null){
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
            if (moveable != null) {
                moveable.Push(worker,d);
                if (this.GetMoveable() == null){
                    this.SetActive(false);
                    worker.AddPoint();
                    b.Die();
                    try {
                        Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\DobozTargetFieldreTolodik.wav")));
                        sound.Play();
                    } catch (UnsupportedAudioFileException | IOException e) {
                        e.printStackTrace();
                    }

                }
            } else {
                this.SetActive(false);
                worker.AddPoint();
                b.Die();
                try {
                    Sound sound = new Sound(getAudioInputStream(new File("src\\therfc\\res\\sounds\\DobozTargetFieldreTolodik.wav")));
                    sound.Play();
                } catch (UnsupportedAudioFileException | IOException e) {
                    e.printStackTrace();
                }

            }
        }
        //logger.Exit(this,"StepOn","Box stepped on targetField");
    }


    /**
     *
     * @return Visszatér a TargetField állapotával
     */
    public Boolean GetActive() {
        //logger.Enter(this,"GetActive","");
        Boolean getActive= active;
       // logger.Exit(this,"GetActive",String.valueOf(getActive));
        return getActive;
    }

    /**
     *
     * @param a Beállítja a TargetField állapotát a paraméterként megkapott értékre
     */
    public void SetActive(Boolean a) {
       // logger.Enter(this,"SetActive","a");
        this.active=a;
       // logger.Exit(this,"SetActive","set "+String.valueOf(a));

    }



}