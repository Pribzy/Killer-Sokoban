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
        for (Worker player : players) {
            if (!player.IsStuck()) {
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
        for (Box boxe : boxes) {
            if (!boxe.IsStuck()) {
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
        boolean allInActive = true;
        List<TargetField> targetfields = new ArrayList<>();
        for (Field field : fields) {
            if (logger.GetObjectName(field).compareTo("TargetField")==0) {
                targetfields.add((TargetField) field);
            }
        }
        for (TargetField targetfield : targetfields) {
            if (targetfield.GetActive()) {
                allInActive = false;
            }
        }
        if(allInActive){
            Game game = Game.getInstance();
            game.EndGame();
        }


        logger.Exit(this, "CheckTargetFields", "Check if all TargetFields are inactive. If yes, calling EndGame()");

    }


    private void IncreaseBoxNumber() {
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


    private void IncreaseWorkerNumber() {
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
        IncreaseWorkerNumber();
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
        IncreaseBoxNumber();
        b.SetWarehouse(this);
        logger.Exit(this,"AddBox","b added to warehouse");
    }


}