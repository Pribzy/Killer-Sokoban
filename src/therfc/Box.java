package therfc;

/**
 * 
 */
public class Box extends Moveable {

    //attribútumok
    private Worker pushWorker;
    private Logger logger = new Logger();



   //konstruktor
    public Box() {

    }

    //függvények
    public void Push(Worker w, Direction d) {
        logger.Enter(this,"Push","w,d");
        SetWorker(w);
        Field nextField=this.GetField().GetNextField(d);
        nextField.StepOn(this,d);
        this.GetWarehouse().CheckStuckedBoxes();
        logger.Exit(this,"Push","box pushed to next field");

    }


    public Worker GetWorker() {
        logger.Enter(this,"GetWorker","");
        logger.Exit(this,"GetWorker","w");
        return pushWorker;
    }


    public Boolean IsStuck() {
        logger.Enter(this,"IsStuck","");
        logger.Exit(this,"IsStuck","stucked");
        return false;
    }


    public void SetWorker(Worker w) {
        logger.Enter(this,"SetWorker","w");
        this.pushWorker=w;
        logger.Exit(this,"SetWorker","pushWorker setted to 'w' ");
    }


    public Boolean CanPushToWall() {
        logger.Enter(this,"CanPushToWall","");
        logger.Exit(this,"CanPushToWall","true");
       return true;

    }
    public void Die() {
        logger.Enter(this,"Die","");
        this.GetField().RemoveMoveable(this);
        this.GetWarehouse().DecreaseBoxNumber();
        logger.Exit(this,"Die","this moveable died");

    }



}