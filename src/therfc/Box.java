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
        return pushWorker;
    }


    public Boolean IsStuck() {
        // TODO implement here
        return null;
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



}