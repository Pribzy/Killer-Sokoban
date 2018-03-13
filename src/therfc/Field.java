package therfc;
import java.util.*;

/**
 * 
 */
public abstract class Field {

    //attribútumok
    private Field neighbors;
    private Moveable moveable;

    //konstruktor
    public Field() {
    }



    //függvények
    public abstract void StepOn(Worker w, Direction d);


    public abstract void StepOn(Box b, Direction d);


    public void AddMoveable(Moveable m) {
        // TODO implement here

    }


    public void RemoveMoveable(Moveable m) {
        // TODO implement here

    }


    public Field GetNextField(Direction d) {
        // TODO implement here
        return null;
    }


    public void GetPreviousField(Direction d) {
        // TODO implement here

    }


    public void SetNeighbor(Field f, Direction d) {
        // TODO implement here

    }


    public Boolean GetMoveablePushedToWall() {
        // TODO implement here
        return null;
    }

}