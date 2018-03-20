package therfc;

import java.util.*;

/**
 *
 */
public class Worker extends Moveable {


    //attribútumok
    private int point;
    private Boolean pushed; //annak eldöntésére,hogy önszántából lépett-e,vagy tolták(ha ==true, akkor tolták,ha false, akkor lépett)
    private int power;
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

    public void Move(Direction d) { //a játékos önszántából lép
        logger.Enter(this,"Move","d");
        SetPushed(false);
        Field nextField=this.GetField().GetNextField(d);
        nextField.StepOn(this,d);
        this.GetWarehouse().CheckStuckedWorkers();
        logger.Exit(this,"Move","worker moved to next field to d direction");
    }

    public void Push(Worker w, Direction d) { //a játékost toljákd irányba
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
        this.GetWarehouse().CheckTargetFields(); //ha kap egy pontot a játékos,akkor leelenőrizzük az összes TargetField-et
        logger.Exit(this,"AddPoint","1 point added");

    }



    public Boolean IsStuck() {
        logger.Enter(this,"IsStuck","");
        Boolean stuck=false;
        logger.Exit(this,"IsStuck",String.valueOf(stuck));
        return stuck;
    }

    public Boolean CanPushToWall() { //ez adja vissza, hogy fel tud-e munkást tolni a falra (false)
        logger.Enter(this,"CanPushToWall","");
        Boolean canPush=false;
        logger.Exit(this,"CanPushToWall",String.valueOf(canPush));
        return canPush;
    }
    public void Die() {//ez hívódik meg,hogyha meghal a munkás
        logger.Enter(this,"Die","");
        this.GetField().RemoveMoveable(this);
        this.GetWarehouse().RemoveWorker(this);
        logger.Exit(this,"Die","this moveable died");

    }
    public void SetPower(int p){
        logger.Enter(this,"SetPower",String.valueOf(p));
        this.power=p;
        logger.Exit(this,"SetPower",String.valueOf(p));

    }
    public int GetPower(){
        logger.Enter(this,"GetPower","");
        int getPower=power;
        logger.Exit(this,"GetPower",String.valueOf(getPower));
        return power;
    }
    public int GetTraction(Direction d){
        logger.Enter(this,"GetTraction","d");
        int traction=0;
        Field nextField = this.GetField().GetNextField(d);
        Moveable nextMoveable = nextField.GetMoveable();
        if(nextMoveable!=null){
            int nextTraction = nextMoveable.GetTraction(d);
            traction+=nextTraction;
        }
        logger.Exit(this,"GetTraction",String.valueOf(traction));
        return traction;
    }
    
}