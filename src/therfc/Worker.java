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
        logger.Enter(this,"Push","w,d");
        SetPushed(true);
        Field nextField=this.GetField().GetNextField(d);
        nextField.StepOn(this,d);
        this.GetWarehouse().CheckStuckedWorkers();
        logger.Exit(this,"Push","w pushed to next field");

    }
    public Boolean GetPushed() {
       return pushed;
    } //ehhez nem kell logger,mert nincs benne a szekvenciákban

    private void SetPushed(Boolean p) {
        logger.Enter(this,"SetPushed","p");
       this.pushed=p;
       logger.Exit(this,"SetPushed","pushed setted to p");

    }

    public void AddPoint() {
        logger.Enter(this,"AddPoint","");
        point++;
        logger.Exit(this,"AddPoint","1 point added");

    }

    public void RemovePoint() { //?
        logger.Enter(this,"AddPoint","");
        point--;
        logger.Exit(this,"AddPoint","1 point removed");

    }

    public Boolean IsStuck() {
        logger.Enter(this,"IsStuck","");
        logger.Exit(this,"IsStuck","stucked");
        // TODO implement here
        return null;
    }

    public Boolean CanPushToWall() {
        logger.Enter(this,"CanPushToWall","");
        logger.Exit(this,"CanPushToWall","false");
        return false;
    }
    
}