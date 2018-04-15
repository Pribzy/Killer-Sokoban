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
       DrawMap();
    }




    
    public  void EndGame( ) { //ha vége a játéknak,ez a függvény hívódik meg
        //logger.Enter(this,"EndGame","");
        Worker yourWinner=level.GetMaxPointPlayer(); //visszaadja a legnagyobb pontú játékost ami eddig történt
        System.out.println("\nGAME OVER\n" +
                "Max Point Player: w" +(level.GetWorkers().indexOf(yourWinner)+1)+"\nPoints: "+yourWinner.GetPoints()+"\n");
        game.GetIO().WriteToFileByLine("\nGAME OVER\n");
        game.GetIO().WriteToFileByLine( "Max Point Player: w" +(level.GetWorkers().indexOf(yourWinner)+1));
        game.GetIO().WriteToFileByLine("\nPoints: "+yourWinner.GetPoints()+"\n");
        //a szekvenciadiagramokban nincs benne a GetPoints() függvény, mivel azt csak a kiiratáshoz használjuk
        //logger.Exit(this,"EndGame","max point player");
    }



    public void SetWarehouse(Warehouse wh){
        this.level=wh;
    }

    public Warehouse GetWarehouse() {
        return level;
    }
    //teszteléshez használt függvények
    public IO GetIO(){
        return io;
    }
    public void DrawMap(){
        logger.DrawWarehoouse(level,this);
    }
}