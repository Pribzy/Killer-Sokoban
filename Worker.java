
import java.util.*;

/**
 * 
 */
public class Worker extends Moveable {

    /**
     * Default constructor
     */
    public Worker() {
    }

    /**
     * 
     */
    private int point;

    /**
     * 
     */
    private Boolean pushed;

    /**
     * @param d 
     * @return
     */
    public void Move(Direction d) {
        // TODO implement here
        return null;
    }

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
    public Boolean GetPushed() {
        // TODO implement here
        return null;
    }

    /**
     * @param pushed 
     * @return
     */
    public void SetPushed(Boolean pushed) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void AddPoint() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void RemovePoint() {
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