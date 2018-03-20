package therfc;
import java.util.*;

/**
 * 
 */
public abstract class Field {

    //attribútumok
    protected Map<Direction,Field> neighbors = new HashMap<>(); //szeirntetek ez így jó lehet?
    protected Moveable moveable;
    private Trap trap;
    private Logger logger = new Logger();

    //konstruktor
    public Field() {
    }
    //függvények
    public abstract void StepOn(Worker w, Direction d);// Ez történik Ha egy munkás  egy mezőre lép


    public abstract void StepOn(Box b, Direction d);// Ez történik Ha egy doboz  egy mezőre lép


    public void AddMoveable(Moveable m) {

        logger.Enter(this,"AddMoveable",logger.GetObjectName(m));
        this.moveable=m;
        m.SetField(this);
        logger.Exit(this,"AddMoveable",logger.GetObjectName(m)+" added to "+logger.GetObjectName(this));
    }


    public void RemoveMoveable(Moveable m) {
        logger.Enter(this,"RemoveMoveable",logger.GetObjectName(m));
        this.moveable=null;
        logger.Exit(this,"RemoveMoveable",logger.GetObjectName(m)+" removed from "+logger.GetObjectName(this));
    }


    public Field GetNextField(Direction d) {
        logger.Enter(this,"GetNextField","d");
        logger.Exit(this,"GetNextField","next field from d direction");
        return neighbors.get(d);
    }


    public Field GetPreviousField(Direction d) {
        logger.Enter(this,"GetPreviousField","d");
        logger.Exit(this,"GetPreviousField","previous field from the opposite of d direction");
        return neighbors.get(d.OppositeDirection());
    }


    public void SetNeighbor(Field f, Direction d) {
        logger.Enter(this,"SetNeighbor","w,d");
        this.neighbors.put(d,f);
        logger.Exit(this,"SetNeighbor","neighbor setted");
    }


    public Boolean GetMoveablePushedToWall() { //a rajta lévő mozgatható dolog fel tudja-e tolni a munkást a falra,vagy sem
        logger.Enter(this,"GetMoveablePushedToWall","");

        Boolean canPushedTowall= moveable.CanPushToWall();
        logger.Exit(this,"GetMoveablePushedToWall",String.valueOf(canPushedTowall));
        return canPushedTowall;

    }

    public Moveable GetMoveable(){ //nem kell logger függvény neki

        return moveable;
    }
    public void AddTrap(Trap t){
        this.trap=t;
    }



}