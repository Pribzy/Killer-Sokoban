package therfc.bin.IO;

import therfc.bin.UI.components.GridComponent;
import therfc.bin.UI.components.PointsComponent;
import therfc.bin.data.Direction;
import therfc.bin.data.Game;
import therfc.bin.data.Worker;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Controller extends KeyAdapter {


    private Game game = Game.GetInstance();

    private int playerNumber;

    public Controller() {



    }



    public void SetPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        GridComponent grid =  game.GetGameFrame().GetGrid();
        PointsComponent points =  game.GetGameFrame().GetPoints();
         Worker w0=  game.GetWarehouse().GetWorkerFromIndex(0);
        Worker w1= game.GetWarehouse().GetWorkerFromIndex(1);

         if(!w0.GetDeadState()) {
             if (evt.getKeyCode() == KeyEvent.VK_W) {
                 w0.Move(Direction.Up);
                grid.RefreshAllPanels();
                 points.RefreshPoints();
             }
             if (evt.getKeyCode() == KeyEvent.VK_S) {
                 w0.Move(Direction.Down);
                 grid.RefreshAllPanels();
                 points.RefreshPoints();
             }
             if (evt.getKeyCode() == KeyEvent.VK_D) {
                 w0.Move(Direction.Right);
                 grid.RefreshAllPanels();
                 points.RefreshPoints();
             }
             if (evt.getKeyCode() == KeyEvent.VK_A) {
                 w0.Move(Direction.Left);
                 grid.RefreshAllPanels();
                 points.RefreshPoints();
             }
             if (evt.getKeyCode() == KeyEvent.VK_E) {

                 if(game.GetWarehouse().GetFieldFromIndex(game.GetWarehouse().GetFields().indexOf(w0.GetField())).GetTrap()==null) {
                     w0.AddHoney();
                 } else {w0.RemoveTrap();}
                 grid.RefreshAllPanels();
                 points.RefreshPoints();
             }
             if (evt.getKeyCode() == KeyEvent.VK_Q) {
                ;
                 if(game.GetWarehouse().GetFieldFromIndex(game.GetWarehouse().GetFields().indexOf(w0.GetField())).GetTrap()==null) {
                     w0.AddOil();
                 } else {w0.RemoveTrap();}
                 grid.RefreshAllPanels();
                 points.RefreshPoints();
             }
         }
        if(!w1.GetDeadState()) {
            if (evt.getKeyCode() == KeyEvent.VK_UP) {
                w1.Move(Direction.Up);
                grid.RefreshAllPanels();
                points.RefreshPoints();
            }
            if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                w1.Move(Direction.Down);
                grid.RefreshAllPanels();
                points.RefreshPoints();
            }
            if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                w1.Move(Direction.Right);
                grid.RefreshAllPanels();
                points.RefreshPoints();
            }
            if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
                w1.Move(Direction.Left);
                grid.RefreshAllPanels();
                points.RefreshPoints();
            }
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {

                if(game.GetWarehouse().GetFieldFromIndex(game.GetWarehouse().GetFields().indexOf(w1.GetField())).GetTrap()==null) {
                    w1.AddOil();
                } else {w1.RemoveTrap();}
                grid.RefreshAllPanels();
                points.RefreshPoints();
            }
            if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {

                if(game.GetWarehouse().GetFieldFromIndex(game.GetWarehouse().GetFields().indexOf(w1.GetField())).GetTrap()==null) {
                    w1.AddHoney();
                } else {w1.RemoveTrap();}
                grid.RefreshAllPanels();
                points.RefreshPoints();
            }
        }
        if(playerNumber>2) {
            Worker w2= game.GetWarehouse().GetWorkerFromIndex(2);

            if(!w2.GetDeadState()) {
                if (evt.getKeyCode() == KeyEvent.VK_I) {
                    w2.Move(Direction.Up);
                    grid.RefreshAllPanels();
                    points.RefreshPoints();
                }
                if (evt.getKeyCode() == KeyEvent.VK_K) {
                    w2.Move(Direction.Down);
                    grid.RefreshAllPanels();
                    points.RefreshPoints();
                }
                if (evt.getKeyCode() == KeyEvent.VK_L) {
                    w2.Move(Direction.Right);
                    grid.RefreshAllPanels();
                    points.RefreshPoints();
                }
                if (evt.getKeyCode() == KeyEvent.VK_J) {
                    w2.Move(Direction.Left);
                    grid.RefreshAllPanels();
                    points.RefreshPoints();
                }
                if (evt.getKeyCode() == KeyEvent.VK_U) {

                    if(game.GetWarehouse().GetFieldFromIndex(game.GetWarehouse().GetFields().indexOf(w1.GetField())).GetTrap()==null) {
                        w2.AddOil();
                    } else {w2.RemoveTrap();}
                    grid.RefreshAllPanels();
                    points.RefreshPoints();
                }
                if (evt.getKeyCode() == KeyEvent.VK_O) {

                    if(game.GetWarehouse().GetFieldFromIndex(game.GetWarehouse().GetFields().indexOf(w1.GetField())).GetTrap()==null) {
                        w2.AddHoney();
                    } else {w2.RemoveTrap();}
                    grid.RefreshAllPanels();
                    points.RefreshPoints();
                }
            }
            if(playerNumber==4){
                Worker w3= game.GetWarehouse().GetWorkerFromIndex(3);
                if(!w3.GetDeadState()) {
                    if (evt.getKeyCode() == KeyEvent.VK_T) {
                        w3.Move(Direction.Up);
                        grid.RefreshAllPanels();
                        points.RefreshPoints();
                    }
                    if (evt.getKeyCode() == KeyEvent.VK_G) {
                        w3.Move(Direction.Down);
                        grid.RefreshAllPanels();
                        points.RefreshPoints();
                    }
                    if (evt.getKeyCode() == KeyEvent.VK_H) {
                        w3.Move(Direction.Right);
                        grid.RefreshAllPanels();
                        points.RefreshPoints();
                    }
                    if (evt.getKeyCode() == KeyEvent.VK_F) {
                        w3.Move(Direction.Left);
                        grid.RefreshAllPanels();
                        points.RefreshPoints();
                    }
                    if (evt.getKeyCode() == KeyEvent.VK_R) {

                        if(game.GetWarehouse().GetFieldFromIndex(game.GetWarehouse().GetFields().indexOf(w3.GetField())).GetTrap()==null) {
                            w3.AddOil();
                        } else {w3.RemoveTrap();}
                        grid.RefreshAllPanels();
                        points.RefreshPoints();
                    }
                    if (evt.getKeyCode() == KeyEvent.VK_Z) {

                        if(game.GetWarehouse().GetFieldFromIndex(game.GetWarehouse().GetFields().indexOf(w3.GetField())).GetTrap()==null) {
                            w3.AddHoney();
                        } else {w3.RemoveTrap();}
                        grid.RefreshAllPanels();
                        points.RefreshPoints();
                    }
                }
            }
        }



    }


}
