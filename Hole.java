
import java.util.*;

/**
 * 
 */
public class Hole extends Field {

    /**
     * Default constructor
     */
    public Hole() {
    }

    /**
     * 
     */
    private Boolean open;

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
    public void StepOn(Worker w, Direction d) {
        // TODO implement here
        return null;
    }

    /**
     * @param open 
     * @return
     */
    public void SetOpen(Boolean open) {
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