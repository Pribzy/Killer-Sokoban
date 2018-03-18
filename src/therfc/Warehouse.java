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
    private List<Box> boxes= new ArrayList<>();
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
        logger.Enter(this, "GetMaxPointPlayer", "");

        Worker max = players.get(0);

        for (int i = 1; i < players.size(); i++){
            if (players.get(i).GetPoints() > max.GetPoints())
                max = players.get(i);
            }
        logger.Exit(this, "GetMaxPointPlayer", "returning the player with the highest points");
        return max;
    }


    public void CheckStuckedWorkers() {
        logger.Enter(this, "CheckStuckedWorkers", "");
        boolean allstucked = true;
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).IsStuck()) {
                allstucked = false;
            }
        }
        if (allstucked) {
            Game game = Game.getInstance();
            game.EndGame();
        }
        logger.Exit(this, "CheckStuckedWorkers", "Check if all workers are stucked. If yes, calling EndGame()");

    }


    public void CheckStuckedBoxes() {
        logger.Enter(this, "CheckStuckedBoxes", "");
        boolean allstucked = true;
        for (int i = 0; i < boxes.size(); i++) {
            if (!boxes.get(i).IsStuck()) {
                allstucked = false;
            }
        }
        if (allstucked) {
            Game game = Game.getInstance();
            game.EndGame();
        }
        logger.Exit(this, "CheckStuckedBoxes", "Check if all boxes are stucked. If yes, calling EndGame()");

    }


    public void CheckTargetFields() {
        logger.Enter(this, "CheckTargetFields", "");
        boolean allinactive = true;
        List<TargetField> targetfields = new ArrayList<>();
        for (int i = 0; i < fields.size(); i++) {
            if (logger.GetObjectName(fields.get(i)) == "TargetField") {


            }
        }

        logger.Exit(this, "CheckTargetFields", "Check if all TargetFields are inactive. If yes, calling EndGame()");

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

    public void AddBox(Box b) {
        logger.Enter(this,"AddBox","b");
        boxes.add(b);
        b.SetWarehouse(this);
        logger.Exit(this,"AddBox","b added to warehouse");
    }


}