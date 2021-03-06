package therfc.bin.data;

import therfc.bin.main.Logger;

import javax.swing.*;
import java.util.*;

/**
 *
 */
public class Warehouse {

    //attribútumok
    private int boxNumber;
    private int workerNumber;
    private List<Field> fields = new ArrayList<>();
    private List<Worker> players;
    private List<Box> boxes= new ArrayList<>();

    private Logger logger = new Logger();

    //konstruktor
    public Warehouse() {
        this.boxNumber=0;
        this.players = new ArrayList<Worker>();
        this.fields = new ArrayList<Field>();
        this.boxes = new ArrayList<Box>();
        this.workerNumber=0;
    }

    //függvények

    /**
     *
     * @return Visszaadja a legtöbb ponttal rendelkező játékost
     */
    public Worker GetMaxPointPlayer() { //visszaadja a legnagyobb ponttal rendelkező játékost
        //logger.Enter(this, "GetMaxPointPlayer", "");
        if(players.isEmpty()){
            //logger.Exit(this, "GetMaxPointPlayer", "All player is dead");
            return new Worker(0);

        }
        else {
            Worker max = players.get(0);

            for (int i = 1; i < players.size(); i++) {
                if (players.get(i).GetPoints() > max.GetPoints())
                    max = players.get(i);
            }
           // logger.Exit(this, "GetMaxPointPlayer", logger.GetObjectName(max));
            return max;
        }
    }

    /**
     *
     */
    public void CheckStuckedWorkers() { //leellenőrzi az összes munkást,hogy beragadt-e
       // logger.Enter(this, "CheckStuckedWorkers", "");
        boolean allStucked = true;
        if(!players.isEmpty()) {
            for (Worker player : players) {
                if (!player.IsStuck()) {
                    allStucked = false;
                }
            }
            if (allStucked) {
                Game game = Game.GetInstance();
                game.EndGame("All workers stucked!");
            }
        }
        //logger.Exit(this, "CheckStuckedWorkers", "Checked workers");

    }

    /**
     *
     */
    public void CheckStuckedBoxes() {//leelenőrzi az összes doboz,hogy beragadt-e
        //logger.Enter(this, "CheckStuckedBoxes", "");
        boolean allStucked = true;
        if(!boxes.isEmpty()) {
            for (Box box : boxes) {
                if (!box.IsStuck()) {
                    allStucked = false;
                }
            }
            if (allStucked) {
                Game game = Game.GetInstance();
                game.EndGame("All boxes stucked!");
            }

        }
       // logger.Exit(this, "CheckStuckedBoxes", "Checked boxes");
    }

    /**
     *
     */
    public void CheckTargetFields() {//leelenőrzi az összes TargetField-et, hogy active-e, ha za összes inaktív,akkor vége a játéknak
       // logger.Enter(this, "CheckTargetFields", "");
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
            Game game = Game.GetInstance();
            game.EndGame("All box pushed to TargetFields!");
        }


       // logger.Exit(this, "CheckTargetFields", "Checked TargetFields");

    }


    /**
     *
     * @param w Hozzáadja a játékhoz a paraméterként átadott játékost
     */
    public void AddWorker(Worker w) {
       // logger.Enter(this,"AddWorker",logger.GetObjectName(w));
        players.add(w);
        workerNumber++;
        w.SetWarehouse(this);
      //  logger.Exit(this,"AddWorker",logger.GetObjectName(w)+" added to warehouse");
    }

    /**
     *
     * @param f Hozzáadja a játékhoz a paraméterként átadott mezőt
     */
    public void AddField(Field f) {
      //  logger.Enter(this,"AddField",logger.GetObjectName(f));
        fields.add(f);
       // logger.Exit(this,"AddField",logger.GetObjectName(f)+" added to warehouse");
    }

    /**
     *
     * @param b Hozzáadja a játékhoz a paraméterként átadott dobozt
     */
    public void AddBox(Box b) {
       // logger.Enter(this,"AddBox",logger.GetObjectName(b));
        boxes.add(b);
        boxNumber++;
        b.SetWarehouse(this);
       // logger.Exit(this,"AddBox",logger.GetObjectName(b)+" added to Warehouse");
    }

    /**
     *
     * @param b Törli a játékból a paraméterként átadott dobozt
     */
    public void RemoveBox(Box b){
        //logger.Enter(this,"RemoveBox",logger.GetObjectName(b));
        boxes.remove(b);
        boxNumber--;
        if (boxNumber==0){
            Game game = Game.GetInstance();
            game.EndGame("All boxes destroyed!");

        }
       // logger.Exit(this,"RemoveBox",logger.GetObjectName(b)+" removed from Warehouse");
    }

    /**
     *
     * @param w Törli a játékból a paraméterként átadott játékost
     */
    public void RemoveWorker(Worker w){
        Game game=Game.GetInstance();
        //logger.Enter(this,"RemoveWorker",logger.GetObjectName(w));
        //players.remove(w);
        workerNumber--;
        if (workerNumber==0){
            game.EndGame("All workers dead!");
        }
       // logger.Exit(this,"RemoveWorker",logger.GetObjectName(w)+" removed from Warehouse");
    }

    /**
     *
     * @param i A paraméterben átadott számú mezőt szeretnénk visszakapni
     * @return Visszaadja a paraméterben átadott számú mezőt
     */
    public Field GetFieldFromIndex(int i){ //visszaadja az i-edik mezőt a raktárból
        return fields.get(i);
    }

    /**
     *
     * @return Visszaadja a mezők listáját
     */
    public List<Field> GetFields(){ //visszaadja a mezők listáját
        return fields;
    }

    /**
     *
     * @param i A paraméterben átadott számú játékost szeretnénk visszakapni
     * @return Visszaadja a paraméterben átadott számú játékost
     */
    public Worker GetWorkerFromIndex(int i){ //visszaadja az i-edik munkást a raktárból
        return players.get(i);
    }

    /**
     *
     * @return Visszaadja a játékosok listáját
     */
    public List<Worker> GetWorkers(){ //visszaadja a munkások listáját
        return players;
    }

    /**
     *
     * @return Visszaadja a dobozok listáját
     */
    public List<Box> GetBoxes(){ //visszaadja a dobozok listáját
        return boxes;
    }

    /**
     *
     * @param i A paraméterben átadott számú dobozt szeretnénk visszakapni
     * @return Visszaadja a paraméterben átadott számú dobozt
     */
    public Box GetBoxFromIndex(int i){ //visszaadja az i-edik munkást a raktárból
        return boxes.get(i);
    }


}