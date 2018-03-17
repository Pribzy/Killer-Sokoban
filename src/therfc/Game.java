package therfc;
import java.util.*;

/**
 * 
 */
public class Game {


    //attribútumok
    private Warehouse level;
    private static Game game = new Game( );

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
        System.out.println("demoMethod for singleton");
    }







}