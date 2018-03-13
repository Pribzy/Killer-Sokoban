package therfc;

import java.util.*;

/**
 *
 */
public class Worker extends Moveable {


    //attribútumok
    private int point;
    private Boolean pushed;
    private Worker worker;

    //konstruktor
    public Worker() {
    }

    //függvények
    public void Move(Direction d) {
        SetPushed(false);
        Field nextField=this.GetField().GetNextField(d);
        nextField.StepOn(this,d);
        this.GetWarehouse().CheckStuckedWorkers();

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