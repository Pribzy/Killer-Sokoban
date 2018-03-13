package therfc;
import java.util.*;

/**
 * 
 */
public abstract class Field {

    //attribútumok
    private Map<Direction,Field> neighbors; //szeirntetek ez így jó lehet?
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


    public Field GetPreviousField(Direction d) {
        switch (d){
            case Up: return neighbors.get(Direction.Down);
            case Down: return neighbors.get(Direction.Up);
            case Right: return neighbors.get(Direction.Left);
            case Left: return neighbors.get(Direction.Right);
            default: return null;
        }
    }


    public void SetNeighbor(Field f, Direction d) {
        this.neighbors.put(d,f);
    }


    public Boolean GetMoveablePushedToWall() {
        return moveable.CanPushToWall();
    }

}