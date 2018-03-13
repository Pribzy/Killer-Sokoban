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
        // TODO implement here

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