
import java.util.*;

/**
 * 
 */
public class Box extends Moveable {

    /**
     * Default constructor
     */
    public Box() {
    }

    /**
     * 
     */
    private Worker pushWorker;

    /**
     * @param w 
     * @param d 
     * @return
     */
    public void Push(Worker w, Direction d) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Worker GetWorker() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Boolean IsStuck() {
        // TODO implement here
        return null;
    }

    /**
     * @param w 
     * @return
     */
    public void SetWorker(Worker w) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Boolean CanPushToWall() {
        // TODO implement here
        return null;
    }

    /**
     * @param w 
     * @param d 
     * @return
     */
    public abstract void Push(Worker w, Direction d);

    /**
     * @return
     */
    public abstract Boolean IsStuck();

    /**
     * @return
     */
    public abstract Boolean CanPushToWall();

}