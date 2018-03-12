
import java.util.*;

/**
 * 
 */
public abstract class Moveable {

    /**
     * Default constructor
     */
    public Moveable() {
    }

    /**
     * 
     */
    private Boolean pushedToWall;

    /**
     * 
     */
    private Field field;

    /**
     * 
     */
    private Warehouse wareHouse;

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

    /**
     * @return
     */
    public void Die() {
        // TODO implement here
        return null;
    }

    /**
     * @param wh 
     * @return
     */
    public void SetWarehouse(Warehouse wh) {
        // TODO implement here
        return null;
    }

    /**
     * @param f 
     * @return
     */
    public void SetField(Field f) {
        // TODO implement here
        return null;
    }

}