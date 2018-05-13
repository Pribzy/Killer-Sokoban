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

    /**
     * PointsComponent konstruktora
     */
    public PointsComponent() {
        //init labels



        for (int i = 0; i <game.GetWarehouse().GetWorkers().size() ; i++) {

            labels.add(new JLabel("Point: "+game.GetWarehouse().GetWorkers().get(i).GetPoints()));
            JPanel playerStaticsPanel = new JPanel();
            GPanel gPanel = new GPanel();
            gPanel.AddGObject(new GWorker(game.GetWarehouse().GetWorkers().get(i)));
            gPanel.Refresh();

            JPanel playerIconAndPoint = new JPanel();

            playerIconAndPoint.add(gPanel,BorderLayout.LINE_START);
            playerIconAndPoint.add(labels.get(i),BorderLayout.LINE_END);
            JPanel playerNumber = new JPanel();
            playerNumber.add(new JLabel((i+1)+". PLAYER: "),BorderLayout.CENTER);


            playerStaticsPanel.add(playerNumber,BorderLayout.SOUTH);
            playerStaticsPanel.add(playerIconAndPoint,BorderLayout.NORTH);

            playerStaticsPanel.setVisible(true);
            this.add(playerStaticsPanel,BorderLayout.CENTER);



        }

        this.setPreferredSize(new Dimension(480,80));
        this.setLayout(new GridLayout(1,game.GetWarehouse().GetWorkers().size(),0,0));
        this.setVisible(true);
    }

    /**
     * Frissíti a pontszámokat, ezáltal mindig az aktuális pontszámok lesznek kiírva.
     */
    public void RefreshPoints() {
        repaint();
        for (int i = 0; i <labels.size() ; i++) {
            labels.get(i).setText("Point: "+game.GetWarehouse().GetWorkers().get(i).GetPoints());
        }
        repaint();

    }

}
