package therfc.bin.IO;

import therfc.bin.UI.components.GridComponent;
import therfc.bin.data.Direction;
import therfc.bin.data.Game;
import therfc.bin.data.Worker;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Controller extends KeyAdapter {


    private Game game = Game.GetInstance();
    private Worker w0,w1,w2,w3;
    private int playerNumber;

    public Controller(int n) {
        this.playerNumber = n;
        this.w0=game.GetWarehouse().GetWorkerFromIndex(0);
        this.w1=game.GetWarehouse().GetWorkerFromIndex(1);
        if(2<playerNumber) {
            this.w2 = game.GetWarehouse().GetWorkerFromIndex(2);
            if(playerNumber==4) {
                this.w3 = game.GetWarehouse().GetWorkerFromIndex(3);
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent evt) {
        GridComponent grid =  game.GetGameFrame().GetGrid();
       if (evt.getKeyCode() == KeyEvent.VK_W) {

           w0.Move(Direction.Up);
           grid.Refresh(game.GetWarehouse());


        }
        if (evt.getKeyCode() == KeyEvent.VK_S) { w0.Move(Direction.Down); grid.Refresh(game.GetWarehouse());

        }
        if (evt.getKeyCode() == KeyEvent.VK_D) { w0.Move(Direction.Right); grid.Refresh(game.GetWarehouse());

        }
        if (evt.getKeyCode() == KeyEvent.VK_A) { w0.Move(Direction.Left); grid.Refresh(game.GetWarehouse());

        }
        if (evt.getKeyCode() == KeyEvent.VK_E) { w0.AddHoney(); grid.Refresh(game.GetWarehouse());

        }
        if (evt.getKeyCode() == KeyEvent.VK_Q) { w0.AddOil(); grid.Refresh(game.GetWarehouse());

        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) { w1.Move(Direction.Up);grid.Refresh(game.GetWarehouse());

        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) { w1.Move(Direction.Down);grid.Refresh(game.GetWarehouse());

        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {w1.Move(Direction.Right);grid.Refresh(game.GetWarehouse());

        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) { w1.Move(Direction.Left);grid.Refresh(game.GetWarehouse()); }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) { w1.AddOil(); grid.Refresh(game.GetWarehouse()); }
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) { w1.AddHoney(); grid.Refresh(game.GetWarehouse()); }
        if(playerNumber>2) {

            if (evt.getKeyCode() == KeyEvent.VK_I) { w2.Move(Direction.Up);grid.Refresh(game.GetWarehouse());

            }
            if (evt.getKeyCode() == KeyEvent.VK_K) { w2.Move(Direction.Down);grid.Refresh(game.GetWarehouse());

            }
            if (evt.getKeyCode() == KeyEvent.VK_L) { w2.Move(Direction.Right);grid.Refresh(game.GetWarehouse());

            }
            if (evt.getKeyCode() == KeyEvent.VK_J) { w2.Move(Direction.Left);grid.Refresh(game.GetWarehouse());

            }
            if (evt.getKeyCode() == KeyEvent.VK_U) { w2.AddOil(); grid.Refresh(game.GetWarehouse()); }
            if (evt.getKeyCode() == KeyEvent.VK_O) { w2.AddHoney(); grid.Refresh(game.GetWarehouse()); }
            if(playerNumber==4){

                if (evt.getKeyCode() == KeyEvent.VK_T) { w3.Move(Direction.Up);grid.Refresh(game.GetWarehouse());

                }
                if (evt.getKeyCode() == KeyEvent.VK_G) {w3.Move(Direction.Down);grid.Refresh(game.GetWarehouse());

                }
                if (evt.getKeyCode() == KeyEvent.VK_H) { w3.Move(Direction.Right);grid.Refresh(game.GetWarehouse());

                }
                if (evt.getKeyCode() == KeyEvent.VK_B) { w3.Move(Direction.Left);grid.Refresh(game.GetWarehouse()); }
                if (evt.getKeyCode() == KeyEvent.VK_R) { w3.AddOil(); grid.Refresh(game.GetWarehouse()); }
                if (evt.getKeyCode() == KeyEvent.VK_Z) { w3.AddHoney(); grid.Refresh(game.GetWarehouse()); }
            }
        }



    }


}
