package therfc;

import java.util.*;

/**
 *
 */
public class Warehouse {

    //attribútumok
    private int boxNumber;
    private int workerNumber;
    private List<Field> fields = new ArrayList<>();
    private List<Worker> players= new ArrayList<>();
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
        logger.Enter(this, "CheckStuckedWorkers", "");
        Boolean stuck=false;
        for(Worker i:players){
            stuck= i.IsStuck();
        }

        logger.Exit(this, "CheckStuckedWorkers", "checked stucked workers");

    }


    public void CheckStuckedBoxes() {
        logger.Enter(this, "CheckStuckedBoxes", "");

        logger.Exit(this, "CheckStuckedBoxes", "checked stucked boxes");

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

    public void AddWorker(Worker w) {
        logger.Enter(this,"AddWorker","w");
        players.add(w);
        w.SetWarehouse(this);
        logger.Exit(this,"AddWorker","w added to warehouse");
    }

    public void AddField(Field f) {
        logger.Enter(this,"AddField","f");
        fields.add(f);
        logger.Exit(this,"AddField","f added to warehouse");
    }

}