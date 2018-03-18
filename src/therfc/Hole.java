package therfc;
import java.util.*;

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
    public void StepOn(Box b, Direction d) {
        logger.Enter(this,"StepOn","b,d");
        if (!open) {
            Moveable moveable = this.GetMoveable();
            Field previousField =  neighbors.get(d.OppositeDirection());
            if (moveable != null){
                Worker w = b.GetWorker();
                moveable.Push(w,d);
                if (this.GetMoveable() == null){
                    previousField.RemoveMoveable(b);
                    this.AddMoveable(b);
                }
            } else {
                previousField.RemoveMoveable(b);
                this.AddMoveable(b);
            }
        } else {
            b.Die();
        }
        logger.Exit(this,"StepOn","b stepped on wall");
    }


    public void StepOn(Worker w, Direction d) {
        logger.Enter(this,"StepOn","w,d");
        if (!open) {
            Moveable moveable = this.GetMoveable();
            Field previousField =  neighbors.get(d.OppositeDirection());
            if (moveable != null){
                moveable.Push(w,d);
                if (this.GetMoveable() == null){
                    previousField.RemoveMoveable(w);
                    this.AddMoveable(w);
                }
            } else {
                previousField.RemoveMoveable(w);
                this.AddMoveable(w);
            }
        } else {
            w.Die();
        }
        logger.Exit(this,"StepOn","w stepped on wall");
    }


    public void SetOpen(Boolean o) {
        logger.Enter(this,"SetOpen","o");
        this.open=o;
        logger.Exit(this,"SetOpen","hole set to "+String.valueOf(o));
    }



}