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
    public void StepOn(Worker w, Direction d) {// Ez történik Ha egy munkás a SteppableFIeld-re lép
        logger.Enter(this, "StepOn", "w,d");

        if (this.GetMoveable() != null) {
            if (!w.GetPushed()) {
                int traction = this.GetMoveable().GetAllTraction(d);
                if (w.GetPower() >= traction) {
                    this.GetMoveable().Push(w, d);
                    if (this.GetMoveable() == null) {
                        neighbors.get(d.OppositeDirection()).RemoveMoveable(w);
                        this.AddMoveable(w);
                    }
                }
            } else {
                this.GetMoveable().Push(w, d);
                if (this.GetMoveable() == null) {
                    neighbors.get(d.OppositeDirection()).RemoveMoveable(w);
                    this.AddMoveable(w);
                }
            }
        } else {
            neighbors.get(d.OppositeDirection()).RemoveMoveable(w);
            this.AddMoveable(w);
        }
        logger.Exit(this, "StepOn", "w stepped on this field");
    }

    public void StepOn(Box b, Direction d) {// Ez történik Ha egy doboz a SteppableFIeld-re lép
        logger.Enter(this, "StepOn", "b,d");
        Field previousField = neighbors.get(d.OppositeDirection());
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