package therfc.bin.UI.frames;

import therfc.bin.IO.Controller;
import therfc.bin.UI.components.GridComponent;
import therfc.bin.UI.components.PointsComponent;
import therfc.bin.data.Game;
import therfc.bin.data.Worker;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private GridComponent grid;
    private PointsComponent points;

    public GameFrame(Game g){
        Container pane = this.getContentPane();
        this.setBounds(0,0,650, 780);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Controller c = new Controller(g.GetWarehouse().GetWorkers().size());
        this.addKeyListener(c);

        this.setTitle("Killer Sokoban - Game");

        grid = new GridComponent();
        points = new PointsComponent();


        pane.add(grid,BorderLayout.SOUTH);
        pane.add(points,BorderLayout.NORTH);
        this.setResizable(false);
        this.setVisible(true);
    }

    public GridComponent GetGrid() {
        return grid;
    }
    public PointsComponent GetPoints() {
        return points;
    }

    public void EndGameMessage(String message,Worker worker){
        JOptionPane.showMessageDialog(this,
                "Hey "+((worker.GetWarehouse().GetWorkers().indexOf(worker))+1)+". worker!\n\nYOUR WINNER!\n\nYour Points: "+worker.GetPoints(),"Game Over - "+message,JOptionPane.PLAIN_MESSAGE );
    }


}
