package therfc;
import java.util.*;

/**
 * 
 */
public class Warehouse {

    //attribútumok
    private int boxNumber;
    private int workerNumber;
    private List<Field> fields;
    private List<Worker> players;
    private Logger logger = new Logger();
    //konstruktor
    public Warehouse() {
    }



    //függvények
    public int GetBoxNumber() {
       return boxNumber;
    }


    public int GetWorkerNumber() {
        return workerNumber;
    }


    public Worker GetMaxPointPlayer() {
        // TODO implement here
        return null;
    }


    public void CheckStuckedWorkers() {
        // TODO implement here

    }


    public void CheckStuckedBoxes() {
        logger.Enter(this,"CheckStuckedBoxes","");
        //Todo: implement checkstuckedboxes
        logger.Exit(this,"CheckStuckedBoxes","checked stucked boxes");

    }


    public void CheckTargetFields() {
        // TODO implement here

    }


    public void IncreaseBoxNumber() {
       boxNumber++;

    }


    public void DecreaseBoxNumber() {
        boxNumber--;

    }


    public void IncreaseWorkerNumber() {
        workerNumber++;

    }


    public void DecreaseWorkerNumber() {
        workerNumber--;

    }

}