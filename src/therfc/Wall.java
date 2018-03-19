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
    public void StepOn(Worker w, Direction d) { // Ez történik Ha egy munkés Wall-re lép
        logger.Enter(this, "StepOn", "w,d");
        Boolean pushed = w.GetPushed();
        if (pushed) {
            Field previousField =  neighbors.get(d.OppositeDirection()).GetPreviousField(d);
            Boolean canPushToWall =previousField.GetMoveablePushedToWall();
            if (canPushToWall) {
                w.Die();
            }
        }
        logger.Exit(this, "StepOn", "w tried to step on wall");
    }

    public void StepOn(Box b, Direction d) { // Ez történik Ha egy doboz Wall-re lép
        logger.Enter(this, "StepOn", "b,d");
        //itt semmit nem csinál
        logger.Exit(this, "StepOn", "b stepped on wall");
    }


}