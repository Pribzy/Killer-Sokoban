package therfc;
import java.util.*;

/**
 * 
 */
public abstract class Field {

    /**
     * Default constructor
     */
    public Field() {
    }


    /**
     * 
     */
    private Field neighbors;

    /**
     * 
     */
    private Moveable moveable;

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

    /**
     * @param m 
     * @return
     */
    public void AddMoveable(Moveable m) {
        // TODO implement here

    }

    /**
     * @param m 
     * @return
     */
    public void RemoveMoveable(Moveable m) {
        // TODO implement here

    }

    /**
     * @param d 
     * @return
     */
    public Field GetNextField(Direction d) {
        // TODO implement here
        return null;
    }

    /**
     * @param d 
     * @return
     */
    public void GetPreviousField(Direction d) {
        // TODO implement here

    }

    /**
     * @param f 
     * @param d 
     * @return
     */
    public void SetNeighbor(Field f, Direction d) {
        // TODO implement here

    }

    /**
     * @return
     */
    public Boolean GetMoveablePushedToWall() {
        // TODO implement here
        return null;
    }

}