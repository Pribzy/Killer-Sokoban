package therfc.bin.UI.components;

import therfc.bin.UI.model_elements.GObject;
import therfc.bin.UI.model_elements.GWorker;
import therfc.bin.data.Game;
import therfc.bin.data.Warehouse;
import therfc.bin.data.Worker;
import therfc.res.Resources;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PointsComponent extends JPanel {

    private List<Worker> workers = new ArrayList<Worker>();
    private List<JLabel> labels = new ArrayList<JLabel>();
    private List<Image> images = new ArrayList<Image>();

    public PointsComponent() {
        //init labels
        Game game = Game.GetInstance();
        for (int i = 0; i < game.GetWarehouse().GetWorkers().size() ; i++) {
            workers.add(game.GetWarehouse().GetWorkerFromIndex(i));
        }

        for (int i = 0; i <workers.size() ; i++) {

            labels.add(new JLabel("Point: "+workers.get(i).GetPoints()));
            JPanel playerStaticsPanel = new JPanel();
            GPanel gPanel = new GPanel();
            gPanel.AddGObject(new GWorker(workers.get(i)));
            gPanel.Refresh();
            playerStaticsPanel.add(gPanel,BorderLayout.LINE_START);
            playerStaticsPanel.add(labels.get(i),BorderLayout.LINE_END);
            playerStaticsPanel.setVisible(true);
            this.add(playerStaticsPanel,BorderLayout.CENTER);



        }

        this.setPreferredSize(new Dimension(480,40));
        this.setLayout(new GridLayout(1,workers.size(),0,0));
        this.setVisible(true);
    }

    public void RefreshPoints() {
        repaint();
        for (int i = 0; i <labels.size() ; i++) {
            labels.get(i).setText("Point: "+workers.get(i).GetPoints());
        }
        repaint();

    }




}
