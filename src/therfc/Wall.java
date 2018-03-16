package therfc;
import java.util.*;

/**
 * 
 */
public class Wall extends Field {

    private Logger logger = new Logger();

    //konstruktor
    public Wall() {
    }

    //függvények
    public void StepOn(Worker w, Direction d) {
        // TODO implement here
        logger.Enter(this, "StepOn", "w,d");
        Field previousField = this.GetPreviousField(d);
        if (w.GetPushed() == true) {
            if (previousField.GetPreviousField(d).GetCanPushMoveable() == true) {
                w.Die();
            }
        }
        logger.Exit(this, "StepOn", "w tried to step on wall");
    }

    public void StepOn(Box b, Direction d) {
        // TODO implement here
        logger.Enter(this, "StepOn", "b,d");
        logger.Exit(this, "StepOn", "b stepped on wall");
    }


}