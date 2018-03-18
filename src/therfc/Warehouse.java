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
        logger.Enter(this, "GetBoxNumber", "");
        logger.Exit(this, "GetBoxNumber", "number of boxes in the Warehouse");
        return boxNumber;
    }


    public int GetWorkerNumber() {
        logger.Enter(this, "GetWorkerNumber", "");
        logger.Exit(this, "GetWorkerNumber", "number of living workers in the Warehouse");
        return workerNumber;
    }


    public Worker GetMaxPointPlayer() {

        for (Worker worker : players)
            if (worker.)
        return null;
    }


    public void CheckStuckedWorkers() {
        logger.Enter(this, "CheckStuckedWorkers", "");


        logger.Exit(this, "CheckStuckedWorkers", "checked stucked workers");

    }


    public void CheckStuckedBoxes() {
        logger.Enter(this, "CheckStuckedBoxes", "");

        logger.Exit(this, "CheckStuckedBoxes", "checked stucked boxes");

    }


    public void CheckTargetFields() {



    }


    public void IncreaseBoxNumber() {
        logger.Enter(this, "IncreaseBoxNumber", "");
        boxNumber++;
        logger.Exit(this, "IncreaseBoxNumber", "Box number increased");

    }


    public void DecreaseBoxNumber() {
        logger.Enter(this, "DecreaseBoxNumber", "");
        boxNumber--;
        if (boxNumber==0){
            Game game = Game.getInstance();
            game.EndGame();
        }
        logger.Exit(this, "DecreaseBoxNumber", "Box number decreased. If 0, calling EndGame()");

    }


    public void IncreaseWorkerNumber() {
        logger.Enter(this, "IncreaseWorkerNumber", "");
        workerNumber++;
        logger.Exit(this, "IncreaseWorkerNumber", "Worker number increased");

    }


    public void DecreaseWorkerNumber() {
        logger.Enter(this, "DecreaseWorkerNumber", "");
        workerNumber--;
        if (workerNumber==0){
            Game game = Game.getInstance();
            game.EndGame();
        }
        logger.Exit(this, "DecreaseWorkerNumber", "Worker number decreased. If 0, calling EndGame()");

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