package therfc;
import java.util.*;

/**
 * 
 */
public class Game {


    //attribútumok
    private Warehouse level;
    private static Game game = new Game( );
    private Logger logger = new Logger();

    //konstruktor
    private Game() { }

    //függvények
    /* Static 'instance' method */
    public static Game GetInstance( ) {
        return game;
    }



    public  void StartGame( ) {
        System.out.println("demoMethod for singleton");
    }


    public  void EndGame( ) { //ha vége a játéknak,ez a függvény hívódik meg
        logger.Enter(this,"EndGame","");
        Worker yourWinner=level.GetMaxPointPlayer(); //visszaadja a legnagyobb pontú játékost ami eddig történt
        System.out.println("Your Winner! Your points: "+yourWinner.GetPoints());
        //a szekvenciadiagramokban nincs benne a GetPoints() függvény, mivel azt csak a kiiratáshoz használjuk
        logger.Exit(this,"EndGame","max point player");
    }

    public void SetWarehouse(Warehouse wh){
        this.level=wh;
    }







}