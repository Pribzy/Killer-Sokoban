package therfc;
import java.util.*;

/**
 * 
 */
public abstract class Field {

    //attribútumok
    private Map<Direction,Field> neighbors = new HashMap<Direction,Field>(); //szeirntetek ez így jó lehet?
    private Moveable moveable;

    //konstruktor
    public Field() {
    }



    //függvények
    public abstract void StepOn(Worker w, Direction d);


    public abstract void StepOn(Box b, Direction d);


    public void AddMoveable(Moveable m) {
        this.moveable=m;

    }


    public void RemoveMoveable(Moveable m) {
        this.moveable=null;

    }


    public Field GetNextField(Direction d) {
        return neighbors.get(d);
    }


    public void GetPreviousField(Direction d) {
        // TODO implement here

    }


    public void SetNeighbor(Field f, Direction d) {
        this.neighbors.put(d,f);
    }


    public Boolean GetMoveablePushedToWall() {
        return moveable.CanPushToWall();
    }

}