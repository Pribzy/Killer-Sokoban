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


    private List<JLabel> labels = new ArrayList<JLabel>();
    private Game game = Game.GetInstance();

    public PointsComponent() {
        //init labels



        for (int i = 0; i <game.GetWarehouse().GetWorkers().size() ; i++) {

            labels.add(new JLabel("Point: "+game.GetWarehouse().GetWorkers().get(i).GetPoints()));
            JPanel playerStaticsPanel = new JPanel();
            GPanel gPanel = new GPanel();
            gPanel.AddGObject(new GWorker(game.GetWarehouse().GetWorkers().get(i)));
            gPanel.Refresh();
            playerStaticsPanel.add(gPanel,BorderLayout.LINE_START);
            playerStaticsPanel.add(labels.get(i),BorderLayout.LINE_END);
            playerStaticsPanel.setVisible(true);
            this.add(playerStaticsPanel,BorderLayout.CENTER);



        }

        this.setPreferredSize(new Dimension(480,40));
        this.setLayout(new GridLayout(1,game.GetWarehouse().GetWorkers().size(),0,0));
        this.setVisible(true);
    }

    public void RefreshPoints() {
        repaint();
        for (int i = 0; i <labels.size() ; i++) {
            labels.get(i).setText("Point: "+game.GetWarehouse().GetWorkers().get(i).GetPoints());
        }
        repaint();

    }




}
