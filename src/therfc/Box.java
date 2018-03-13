package therfc;
import java.util.*;

/**
 * 
 */
public class Box extends Moveable {

    //ez egy box

    //attribútumok
    private Worker pushWorker;

   //konstruktor
    public Box() {
    }

    //függvények
    public void Push(Worker w, Direction d) {
        // TODO implement here

    }


    public Worker GetWorker() {
        return pushWorker;
    }


    public Boolean IsStuck() {
        // TODO implement here
        return null;
    }


    public void SetWorker(Worker w) {
        this.pushWorker=w;

    }


    public Boolean CanPushToWall() {
       return true;
    }



}