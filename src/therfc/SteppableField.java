package therfc;

import java.util.*;

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
    public void StepOn(Worker w, Direction d) {
        logger.Enter(this, "StepOn", "w,d");
        Field previousField = this.GetPreviousField(d);
        if (this.GetMoveable() != null) {
            this.GetMoveable().Push(w, d);
            if (this.GetMoveable() == null) {
                previousField.RemoveMoveable(w);
                this.AddMoveable(w);
            }
        } else {
            previousField.RemoveMoveable(w);
            this.AddMoveable(w);
        }
        logger.Exit(this, "StepOn", "w stepped on this field");
    }

    public void StepOn(Box b, Direction d) {
        logger.Enter(this, "StepOn", "b,d");
        Field previousField = this.GetPreviousField(d);
        if (this.GetMoveable() != null) {
            Worker pushWorker = b.GetWorker();
            this.GetMoveable().Push(pushWorker, d);
            if (this.GetMoveable() == null) {
                previousField.RemoveMoveable(b);
                this.AddMoveable(b);
            }
        } else {
            previousField.RemoveMoveable(b);
            this.AddMoveable(b);
        }
        logger.Exit(this, "StepOn", "b stepped on this field");
    }


}