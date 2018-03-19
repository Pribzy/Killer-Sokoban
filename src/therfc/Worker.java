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
    public Worker(int p) {
        this.point=p;
    }

    //függvények

    public int GetPoints() {
        logger.Enter(this,"GetPoints","");
        int points=point;
        logger.Exit(this,"GetPoints",String.valueOf(points));
        return points;

    }

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
        logger.Enter(this,"GetPushed","p");
        Boolean push=pushed;
        logger.Exit(this,"GetPushed",String.valueOf(push));
        return push;
    }

    private void SetPushed(Boolean p) {
        logger.Enter(this,"SetPushed",String.valueOf(p));
        this.pushed=p;
        logger.Exit(this,"SetPushed","Worker pushed attribute set to: "+String.valueOf(p));

    }

    public void AddPoint() {
        logger.Enter(this,"AddPoint","");
        point++;
        this.GetWarehouse().CheckTargetFields();
        logger.Exit(this,"AddPoint","1 point added");

    }



    public Boolean IsStuck() {
        logger.Enter(this,"IsStuck","");
        Boolean stuck=false;
        logger.Exit(this,"IsStuck",String.valueOf(stuck));
        return stuck;
    }

    public Boolean CanPushToWall() {
        logger.Enter(this,"CanPushToWall","");
        logger.Exit(this,"CanPushToWall","false");
        return false;
    }
    public void Die() {
        logger.Enter(this,"Die","");
        this.GetField().RemoveMoveable(this);
        this.GetWarehouse().RemoveWorker(this);
        logger.Exit(this,"Die","this moveable died");

    }
    
}