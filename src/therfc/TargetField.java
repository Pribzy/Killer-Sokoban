package therfc;
import java.util.*;

/**
 * 
 */
public class TargetField extends Field {


    //attribútumok
    private Boolean active;
    private Logger logger = new Logger();

    //konstruktor
    public TargetField() {
    }

    //függvények
    public void StepOn(Worker w, Direction d) {
        logger.Enter(this,"StepOn","w,d");
        Moveable moveable = this.GetMoveable();
        Field previousField = this.GetPreviousField(d);
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


    public void StepOn(Box b, Direction d) {
        logger.Enter(this,"StepOn","b,d");
        Worker worker = b.GetWorker();
        Moveable moveable = this.GetMoveable();
        Field previousField = this.GetPreviousField(d);
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
                    worker.AddPoint();
                    b.Die();
                    this.SetActive(false);
                }
            } else {
                worker.AddPoint();
                b.Die();
                this.SetActive(false);
            }
        }
        logger.Exit(this,"StepOn","Box stepped on targetField");
    }


    public void SetActive(Boolean a) {
        this.active=a;

    }



}