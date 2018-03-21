package therfc;
import java.util.*;

/**
 * 
 */
public class TargetField extends Field {


    //attribútumok
    private Boolean active; //ha ==true, akkor lehet rá tolni dobozt és kap pontot a játékos, ha ==false,akkor már nem kap érte pontot
    private Logger logger = new Logger();

    //konstruktor
    public TargetField() {
    }

    //függvények
    public void StepOn(Worker w, Direction d) { // Ez történik Ha egy munkás Targetfield-re lép
        logger.Enter(this,"StepOn","w,d");
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
        logger.Exit(this,"StepOn","Worker stepped on targetField");
    }


    public void StepOn(Box b, Direction d) {// Ez történik Ha egy doboz TargetField-re lép
        logger.Enter(this,"StepOn","b,d");
        Worker worker = b.GetWorker();
        Moveable moveable = this.GetMoveable();
        Field previousField = neighbors.get(d.OppositeDirection());
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
                    b.Die();

                }
            } else {
                this.SetActive(false);
                worker.AddPoint();
                b.Die();

            }
        }
        logger.Exit(this,"StepOn","Box stepped on targetField");
    }



    public Boolean GetActive() {
        logger.Enter(this,"GetActive","");
        Boolean getActive= active;
        logger.Exit(this,"GetActive",String.valueOf(getActive));
        return getActive;
    }

    public void SetActive(Boolean a) {
        logger.Enter(this,"SetActive","a");
        this.active=a;
        logger.Exit(this,"SetActive","set "+String.valueOf(a));

    }



}