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
        if(players.isEmpty()){
            Worker nullWorker=new Worker(0);
            logger.Exit(this, "GetMaxPointPlayer", "All player is dead");
            return nullWorker;

        }
        else {
            Worker max = players.get(0);

            for (int i = 1; i < players.size(); i++) {
                if (players.get(i).GetPoints() > max.GetPoints())
                    max = players.get(i);
            }
            logger.Exit(this, "GetMaxPointPlayer", String.valueOf(max));
            return max;
        }
    }


    public void CheckStuckedWorkers() {
        logger.Enter(this, "CheckStuckedWorkers", "");
        boolean allStucked = true;
        if(!players.isEmpty()) {
            for (Worker player : players) {
                if (!player.IsStuck()) {
                    allStucked = false;
                }
            }
            if (allStucked) {
                Game game = Game.getInstance();
                game.EndGame();
            }
        }
        logger.Exit(this, "CheckStuckedWorkers", "Checked workers");

    }


    public void CheckStuckedBoxes() {
        logger.Enter(this, "CheckStuckedBoxes", "");
        boolean allStucked = true;
        if(!boxes.isEmpty()) {
            for (Box box : boxes) {
                if (!box.IsStuck()) {
                    allStucked = false;
                }
            }
            if (allStucked) {
                Game game = Game.getInstance();
                game.EndGame();
            }

        }
        logger.Exit(this, "CheckStuckedBoxes", "Checked boxes");
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


        logger.Exit(this, "CheckTargetFields", "Checked TargetFields");

    }





    public void AddWorker(Worker w) {
        logger.Enter(this,"AddWorker",logger.GetObjectName(w));
        players.add(w);
        workerNumber++;
        w.SetWarehouse(this);
        logger.Exit(this,"AddWorker",logger.GetObjectName(w)+" added to warehouse");
    }

    public void AddField(Field f) {
        logger.Enter(this,"AddField",logger.GetObjectName(f));
        fields.add(f);
        logger.Exit(this,"AddField",logger.GetObjectName(f)+" added to warehouse");
    }

    public void AddBox(Box b) {
        logger.Enter(this,"AddBox",logger.GetObjectName(b));
        boxes.add(b);
        boxNumber++;
        b.SetWarehouse(this);
        logger.Exit(this,"AddBox",logger.GetObjectName(b)+" added to Warehouse");
    }
    public void RemoveBox(Box b){
        logger.Enter(this,"RemoveBox",logger.GetObjectName(b));
        boxes.remove(b);
        boxNumber--;
        if (boxNumber==0){
            Game game = Game.getInstance();
            game.EndGame();
        }
        logger.Exit(this,"RemoveBox",logger.GetObjectName(b)+" removed from Warehouse");
    }
    public void RemoveWorker(Worker w){
        logger.Enter(this,"RemoveWorker",logger.GetObjectName(w));
        players.remove(w);
        workerNumber--;
        if (workerNumber==0){
            Game game = Game.getInstance();
            game.EndGame();
        }
        logger.Exit(this,"RemoveWorker",logger.GetObjectName(w)+" removed from Warehouse");
    }


}