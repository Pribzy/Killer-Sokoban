package therfc;

import java.util.*;

/**
 *
 */
public class Worker extends Moveable {


    //attribútumok
    private int point;
    private Boolean pushed;

    private Logger logger = new Logger();

    //konstruktor
    public Worker() {
    }

    //függvények
    public void Move(Direction d) {
        logger.Enter(this,"Move","d");
        SetPushed(false);
        Field nextField=this.GetField().GetNextField(d);
        nextField.StepOn(this,d);
        this.GetWarehouse().CheckStuckedWorkers();
        logger.Exit(this,"Move","worker moved to next field to d direction");
    }

    public void Push(Worker w, Direction d) {
        // TODO implement here

    }
    public Boolean GetPushed() {
       return pushed;
    }

    public void SetPushed(Boolean p) {
       this.pushed=p;

    }

    public void AddPoint() {
        point++;

    }

    public void RemovePoint() {
        point--;

    }

    public Boolean IsStuck() {
        // TODO implement here
        return null;
    }

    public Boolean CanPushToWall() {
        return false;
    }
    
}