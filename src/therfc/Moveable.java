package therfc;
import java.util.*;

/**
 * 
 */
public abstract class Moveable {

    //attribútumok
    private Boolean pushedToWall;
    private Field field;
    private Warehouse wareHouse;

    //konstruktor
    public Moveable() {
    }

   //függvények
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

    }

    /**
     * @param wh 
     * @return
     */
    public void SetWarehouse(Warehouse wh) {
        // TODO implement here

    }

    /**
     * @param f 
     * @return
     */
    public void SetField(Field f) {
        // TODO implement here

    }

}