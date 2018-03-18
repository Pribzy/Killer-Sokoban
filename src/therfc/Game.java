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
    public static Game getInstance( ) {
        return game;
    }



    public  void StartGame( ) {
        System.out.println("demoMethod for singleton");
    }


    public  void EndGame( ) {
        logger.Enter(this,"EndGame","");
        level.GetMaxPointPlayer();
        logger.Exit(this,"EndGame","max point player");
    }







}