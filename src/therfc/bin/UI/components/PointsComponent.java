package therfc.bin.UI.components;

import therfc.bin.UI.model_elements.GObject;
import therfc.bin.data.Game;
import therfc.bin.data.Warehouse;
import therfc.bin.data.Worker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PointsComponent extends JPanel {

    private Game game = Game.GetInstance();
    private List<Worker> workers = new ArrayList<Worker>();
    private List<JLabel> labels = new ArrayList<JLabel>();

    public PointsComponent() {
        //init labels
        for (int i = 0; i <game.GetWarehouse().GetWorkers().size() ; i++) {
            workers.add(game.GetWarehouse().GetWorkerFromIndex(i));
        }
        for (int i = 0; i <workers.size() ; i++) {
            labels.add(new JLabel((i+1)+". Worker ,Point: "+workers.get(i).GetPoints()));
            this.add(labels.get(i));
        }

        this.setPreferredSize(new Dimension(220,480));
        this.setLayout(new GridLayout(workers.size(),1,0,0));
       // RefreshPoints();
        this.setVisible(true);
    }

    public void RefreshPoints() {
        repaint();
        for (int i = 0; i <labels.size() ; i++) {
            labels.get(i).setText((i+1)+". Worker ,Point: "+workers.get(i).GetPoints());
        }
        repaint();

    }




}
