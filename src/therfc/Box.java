package therfc;

/**
 * 
 */
public class Box extends Moveable {

    //ez egy box pénisz a box vaginában énisz pénisz

    //attribútumok
    private Worker pushWorker;

    Logger logger = new Logger();

   //konstruktor
    public Box() {
        logger.Enter(this,"valami","valami");
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