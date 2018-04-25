package therfc.bin.data;
import therfc.bin.IO.Controller;
import therfc.bin.IO.IO;
import therfc.bin.UI.frames.GameFrame;
import therfc.bin.main.Logger;
import therfc.res.Resources;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

/**
 * 
 */
public class Game {


    //attribútumok
    private Warehouse level;
    private static Game game = new Game( );
    private Logger logger = new Logger();
    private IO io =new IO();
    private GameFrame gameFrame;



    //teszteléshez használt változók, ezek nincsenek ledokumentálva, mert a program működésébe nem szólnak bele,szimplán segédváltozó.
    private static Boolean end=false;

    //konstruktor
    private Game() { }

    //függvények
    /* statikus példány metódus*/
    public static Game GetInstance( ) {
        return game;
    }


//szkeleton függvények

    /**
     *
     * @throws Exception
     */
    public  void StartGame( ) throws Exception {

        level = io.SetWarehouseFromFile(Resources.Player_2);
        io.SetNeighBors(level);
        DrawMap();
        gameFrame= new GameFrame(this);



    }
     public void RestartGame(){
        game=new Game();
     }

    /**
     *
     */
    public  void EndGame(String message ) { //ha vége a játéknak,ez a függvény hívódik meg
        //logger.Enter(this,"EndGame","");


        Worker yourWinner=level.GetMaxPointPlayer(); //visszaadja a legnagyobb pontú játékost ami eddig történt
        if(!end) {
            System.out.println("\nGAME OVER\n" +
                    "Max Point Player: w" + (level.GetWorkers().indexOf(yourWinner) + 1) + "\nPoints: " + yourWinner.GetPoints() + "\n");
            game.GetIO().WriteToFileByLine("\nGAME OVER\n");
            game.GetIO().WriteToFileByLine("Max Point Player: w" + (level.GetWorkers().indexOf(yourWinner) + 1));
            game.GetIO().WriteToFileByLine("\nPoints: " + yourWinner.GetPoints() + "\n");
           this.gameFrame.EndGameMessage(message,yourWinner );

            try {
                //StartGame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //a szekvenciadiagramokban nincs benne a GetPoints() függvény, mivel azt csak a kiiratáshoz használjuk
        //logger.Exit(this,"EndGame","max point player");
        end=true; //csak, hogy egyszer hívódjon meg a játék vége függvény.
    }


    public GameFrame GetGameFrame() {
        return gameFrame;
    }

    /**
     *
     * @param wh Beállítja magának a paraméterként átadott Raktárt
     */
    public void SetWarehouse(Warehouse wh){
        this.level=wh;
    }

    /**
     *
     * @return Visszatér az aktuális Raktárral
     */
    public Warehouse GetWarehouse() {
        return level;
    }
    //teszteléshez használt függvények, ezek nincsenek benne a dokumentumban
    public IO GetIO(){
        return io;
    }
    public void DrawMap(){
        logger.DrawWarehoouse(level,this);
    }
}