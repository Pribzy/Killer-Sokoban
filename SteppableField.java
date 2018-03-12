
import java.util.*;

/**
 * 
 */
public class SteppableField extends Field {

    /**
     * Default constructor
     */
    public SteppableField() {
    }

    /**
     * @param w 
     * @param d 
     * @return
     */
    public void StepOn(Worker w, Direction d) {
        // TODO implement here
        return null;
    }

    /**
     * @param b 
     * @param d 
     * @return
     */
    public void StepOn(Box b, Direction d) {
        // TODO implement here
        return null;
    }

    /**
     * @param w 
     * @param d 
     * @return
     */
    public abstract void StepOn(Worker w, Direction d);

    /**
     * @param b 
     * @param d 
     * @return
     */
    public abstract void StepOn(Box b, Direction d);

}