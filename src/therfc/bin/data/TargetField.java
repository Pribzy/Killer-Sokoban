package therfc.bin.data;
import therfc.bin.IO.IO;
import therfc.bin.main.Logger;

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
                previousField.RemoveMoveable(w);
                this.AddMoveable(w);
            }
        } else {
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

                }
            } else {
                previousField.RemoveMoveable(b);
                this.AddMoveable(b);

            }
        } else {
            if (moveable != null) {
                moveable.Push(worker,d);
                if (this.GetMoveable() == null){
                    this.SetActive(false);
                    worker.AddPoint();

                    System.out.println("TargetField deactivated");

                    io.WriteToFileByLine("TargetField activated");
                    b.Die();

                }
            } else {
                this.SetActive(false);
                worker.AddPoint();
                System.out.println("TargetField deactivated");
                io.WriteToFileByLine("TargetField activated");
                b.Die();

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