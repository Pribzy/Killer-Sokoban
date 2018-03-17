package therfc;
import java.util.*;

/**
 * 
 */
public abstract class Field {

    //attribútumok
    private Map<Direction,Field> neighbors = new HashMap<>(); //szeirntetek ez így jó lehet?
    private Moveable moveable;
    private Logger logger = new Logger();

    //konstruktor
    public Field() {
    }
    //függvények
    public abstract void StepOn(Worker w, Direction d);


    public abstract void StepOn(Box b, Direction d);


    public void AddMoveable(Moveable m) {

        logger.Enter(this,"AddMoveable","m");
        this.moveable=m;
        m.SetField(this);
        logger.Exit(this,"AddMoveable","m added from this field");
    }


    public void RemoveMoveable(Moveable m) {
        logger.Enter(this,"RemoveMoveable","m");
        this.moveable=null;
        logger.Exit(this,"RemoveMoveable","m removed from this field");
    }


    public Field GetNextField(Direction d) {
        logger.Enter(this,"GetNextField","d");
        logger.Exit(this,"GetNextField","next field from d direction");
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
        logger.Enter(this,"SetNeighbor","w,d");
        this.neighbors.put(d,f);
        logger.Exit(this,"SetNeighbor","neighbor setted");
    }


    public Boolean GetMoveablePushedToWall() {
        logger.Enter(this,"GetMoveablePushedToWall","");
        logger.Exit(this,"GetMoveablePushedToWall","can push to wall");
        return moveable.CanPushToWall();

    }

    public Moveable GetMoveable(){ //nem kell logger függvény neki
        return moveable;
    }

}