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
        logger.Enter(this, "StepOn", "w,d");
        Field previousField = this.GetPreviousField(d);
        if (w.GetPushed()) {
            if (previousField.GetPreviousField(d).GetMoveablePushedToWall()) {
                w.Die();
            }
        }
        logger.Exit(this, "StepOn", "w tried to step on wall");
    }

    public void StepOn(Box b, Direction d) {
        logger.Enter(this, "StepOn", "b,d");
        //itt semmit nem csinál
        logger.Exit(this, "StepOn", "b stepped on wall");
    }


}