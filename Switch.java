
import java.util.*;

/**
 * 
 */
public class Switch extends Field {

    /**
     * Default constructor
     */
    public Switch() {
    }

    /**
     * 
     */
    private Hole hole;

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
     * @param h 
     * @return
     */
    public void SetHole(Hole h) {
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