package therfc;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 
 */
public class Game {


    //attribútumok
    private Warehouse level;
    private static Game game = new Game( );
    private Logger logger = new Logger();
    private IO io =new IO();

    //konstruktor
    private Game() { }

    //függvények
    /* statikus példány metódus*/
    public static Game GetInstance( ) {
        return game;
    }


//szkeleton függvények
    public  void StartGame( ) throws Exception {

        level = io.SetWarehouseFromFile(new File("trial.txt"));
        io.SetNeighBors(level);
        logger.DrawWarehoouse(level);
    }

    public void AddWorker(int x,int y,int power){
        Worker w = new Worker();
        w.SetPower(power);
        if(level.GetFieldFromIndex(x+(y*20)).GetMoveable()!=null){
            System.out.println("Failed to add worker to this field, because it's not empty!");
        } else if (!level.GetFieldFromIndex(x+(y*20)).CheckStepOn()){
            System.out.println("Failed to add worker to this field, because this field is a wall!");
        }
        else {
            level.AddWorker(w);
            level.GetFieldFromIndex(x + (y * 20)).AddMoveable(w);
            System.out.println("Succes added to X: "+x+", Y: "+y);
        }
    }
    public void AddBox(int x,int y,int traction){
        Box b = new Box();
        b.SetTraction(traction);
        if(level.GetFieldFromIndex(x+(y*20)).GetMoveable()!=null){
            System.out.println("Failed to add box to this field, because it's not empty!");
        } else if (!level.GetFieldFromIndex(x+(y*20)).CheckStepOn()){
            System.out.println("Failed to add box to this field, because this field is a wall!");
        }
        else {
            level.AddBox(b);
            level.GetFieldFromIndex(x + (y * 20)).AddMoveable(b);
            System.out.println("Succes added to X: "+x+", Y: "+y);
        }
    }
    public void DrawMap(){
        logger.DrawWarehoouse(level);
    }
    public void SelectWorker(){

    }
    
    public  void EndGame( ) { //ha vége a játéknak,ez a függvény hívódik meg
        //logger.Enter(this,"EndGame","");
        Worker yourWinner=level.GetMaxPointPlayer(); //visszaadja a legnagyobb pontú játékost ami eddig történt
        System.out.println("Your Winner! Your points: "+yourWinner.GetPoints());
        //a szekvenciadiagramokban nincs benne a GetPoints() függvény, mivel azt csak a kiiratáshoz használjuk
        //logger.Exit(this,"EndGame","max point player");
    }



    public void SetWarehouse(Warehouse wh){
        this.level=wh;
    }

    public Warehouse GetWarehouse() {
        return level;
    }
}