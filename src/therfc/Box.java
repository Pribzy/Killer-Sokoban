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
    public void Push(Worker w, Direction d) { //ha tolják,ez a függvény hívódik meg
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


    public Boolean IsStuck() { // ez a függvény nézi meg,hogy beszorult-e a doboz
        logger.Enter(this,"IsStuck","");
        Boolean stuck=false;
        logger.Exit(this,"IsStuck",String.valueOf(stuck));
        return stuck;
    }


    public void SetWorker(Worker w) { //beállítja azt a munkást,amelyik tolja
        logger.Enter(this,"SetWorker","w");
        this.pushWorker=w;
        logger.Exit(this,"SetWorker","pushWorker setted to 'w' ");
    }


    public Boolean CanPushToWall() { //azt adja vissza, hogy fel tudja-e tolni a munkást (igaz)
        logger.Enter(this,"CanPushToWall","");
        Boolean canPush=true;
        logger.Exit(this,"CanPushToWall",String.valueOf(canPush));
       return canPush;

    }
    public void Die() {
        logger.Enter(this,"Die","");
        this.GetField().RemoveMoveable(this);
        this.GetWarehouse().RemoveBox(this);
        logger.Exit(this,"Die","this moveable died");

    }



}