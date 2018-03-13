package therfc;

import java.util.*;

/**
 *
 */
public class Worker extends Moveable {


    //attribútumok
    private int point;
    private Boolean pushed;

    //konstruktor
    public Worker() {
    }

    //függvények
    public void Move(Direction d) {
        // TODO implement here

    }

    public void Push(Worker w, Direction d) {
        // TODO implement here

    }
    public Boolean GetPushed() {
        // TODO implement here
        return null;
    }

    public void SetPushed(Boolean pushed) {
        // TODO implement here

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
        // TODO implement here
        return null;
    }
    
}