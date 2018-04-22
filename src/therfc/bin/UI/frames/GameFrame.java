package therfc.bin.UI.frames;

import therfc.bin.IO.Controller;
import therfc.bin.UI.components.GridComponent;
import therfc.bin.UI.components.PointsComponent;
import therfc.bin.data.Game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private GridComponent grid;
    private PointsComponent points;

    public GameFrame(Game g){
        this.setBounds(0,0,480, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Controller c = new Controller(2);
        this.addKeyListener(c);

        grid = new GridComponent(g,g.GetWarehouse());


        this.setLayout(new BorderLayout());
        this.add(grid);
        this.setResizable(false);
        grid.setPreferredSize(new Dimension(600,600));




        this.setVisible(true);
    }

    public GridComponent GetGrid() {
        return grid;
    }

    public void SetGrid(GridComponent grid) {
        this.grid = grid;
    }
}
