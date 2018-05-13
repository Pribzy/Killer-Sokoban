package therfc.bin.UI.components;

import therfc.bin.UI.model_elements.*;
import therfc.bin.data.*;
import therfc.bin.data.Box;
import therfc.bin.main.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import java.util.List;

public class GridComponent extends JPanel {

    private List<GPanel> panels;
    private Game game = Game.GetInstance();

    /**
     * GridComponent konstruktora
     */
    public GridComponent() {
        panels = new ArrayList<GPanel>();
        //Beállítja a pálya kezdeti állapotát
        Logger logger = new Logger();
        GPanel newPanel;

        for (int i = 0; i < game.GetWarehouse().GetFields().size(); i++) {

            if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)) == "Wall") {
                Wall w = (Wall) game.GetWarehouse().GetFields().get(i);
                GWall g = new GWall(w);
                newPanel = new GPanel();
                newPanel.AddGObject(g);
                AddPanel(newPanel);
            } else if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)) == "TargetField") {
                newPanel = new GPanel();
                if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() != null) {

                    if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        TargetField s = (TargetField) game.GetWarehouse().GetFields().get(i);
                        GTargetField gs = new GTargetField(s);

                        newPanel.AddGObject(gs);

                        Box w = (Box) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                        GBox g = new GBox(w);

                        newPanel.AddGObject(g);
                        AddPanel(newPanel);


                    } else if (!game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        TargetField s = (TargetField) game.GetWarehouse().GetFieldFromIndex(i);
                        GTargetField gs = new GTargetField(s);

                        newPanel.AddGObject(gs);

                        Worker w = (Worker) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        newPanel.AddGObject(g);
                        AddPanel(newPanel);

                    }
                } else if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() == null) {

                    TargetField s = (TargetField) game.GetWarehouse().GetFieldFromIndex(i);
                    GTargetField gs = new GTargetField(s);

                    newPanel.AddGObject(gs);
                    AddPanel(newPanel);
                }

            }

            if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)) == "SteppableField") {
                newPanel = new GPanel();
                if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() != null) {
                    if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        SteppableField s = (SteppableField) game.GetWarehouse().GetFieldFromIndex(i);
                        GSteppableField gs = new GSteppableField(s);
                        // newPanel = new GPanel();
                        newPanel.AddGObject(gs);
                        Box w = (Box) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                        GBox g = new GBox(w);
                        //newPanel = new GPanel();
                        newPanel.AddGObject(g);
                        AddPanel(newPanel);

                    } else if (!game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        SteppableField s = (SteppableField) game.GetWarehouse().GetFieldFromIndex(i);
                        GSteppableField gs = new GSteppableField(s);
                        //newPanel = new GPanel();
                        newPanel.AddGObject(gs);
                        Worker w = (Worker) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        newPanel.AddGObject(g);
                        AddPanel(newPanel);
                    }
                } else if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() == null) {

                    SteppableField w = (SteppableField) game.GetWarehouse().GetFieldFromIndex(i);
                    GSteppableField g = new GSteppableField(w);
                    //newPanel = new GPanel();
                    newPanel.AddGObject(g);
                    AddPanel(newPanel);


                }
            } else if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)) == "Hole") {
                newPanel = new GPanel();
                if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() != null) {
                    if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Hole s = new Hole();
                        GHole gs = new GHole(s);
                        //newPanel = new GPanel();
                        newPanel.AddGObject(gs);

                        Box w = (Box) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                        GBox g = new GBox(w);
                        //newPanel = new GPanel();
                        newPanel.AddGObject(g);
                        AddPanel(newPanel);

                    } else if (!game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        Hole s = (Hole) game.GetWarehouse().GetFieldFromIndex(i);
                        GHole gs = new GHole(s);
                        //newPanel = new GPanel();
                        newPanel.AddGObject(gs);

                        Worker w = (Worker) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        newPanel.AddGObject(g);
                        AddPanel(newPanel);
                    }
                } else if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() == null) {

                    Hole s = (Hole) game.GetWarehouse().GetFieldFromIndex(i);

                    GHole gs = new GHole(s);
                    //newPanel = new GPanel();
                    newPanel.AddGObject(gs);
                    AddPanel(newPanel);


                }
            } else if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)) == "Switch") {
                newPanel = new GPanel();
                if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() != null) {
                    if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Switch s = new Switch();
                        GSwitch gs = new GSwitch(s);
                        //newPanel = new GPanel();
                        newPanel.AddGObject(gs);

                        Box w = (Box) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                        GBox g = new GBox(w);
                        //newPanel = new GPanel();
                        newPanel.AddGObject(g);
                        AddPanel(newPanel);
                    } else if (!game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Switch s = (Switch) game.GetWarehouse().GetFieldFromIndex(i);

                        GSwitch gs = new GSwitch(s);
                        //newPanel = new GPanel();
                        newPanel.AddGObject(gs);

                        Worker w = (Worker) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        newPanel.AddGObject(g);
                        AddPanel(newPanel);
                    }
                } else if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() == null) {

                    Switch s = (Switch) game.GetWarehouse().GetFieldFromIndex(i);
                    GSwitch gs = new GSwitch(s);
                    newPanel.AddGObject(gs);
                    AddPanel(newPanel);

                }
            }

            this.repaint();
        }


        this.setLayout(new GridLayout(20, 20, 0, 0));
        this.setPreferredSize(new Dimension(640, 640));
        this.setVisible(true);

    }

    /**
     *  Frissíti a mezők tartalmát.
     */
    public void RefreshAllPanels() {
        Logger logger = new Logger();
        for (int i = 0; i < panels.size(); i++) {
            if (game.GetWarehouse().GetFieldFromIndex(i).GetTrap() == null) {
                panels.get(i).GetGObjects().set(1, null);
            }
            if (game.GetWarehouse().GetFieldFromIndex(i).GetTrap() != null) {
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i).GetTrap()).equals("Honey")) {
                    GHoney t = new GHoney(new Honey());
                    panels.get(i).AddGObject(t);
                }
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i).GetTrap()).equals("Oil")) {
                    GOil t = new GOil(new Oil());
                    panels.get(i).AddGObject(t);
                }
            }
        }
        for (int i = 0; i < panels.size(); i++) {
            if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() != null) {
                if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                    Box w = (Box) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                    GBox gb = new GBox(w);
                    panels.get(i).AddGObject(gb);

                } else if (!game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {


                    Worker w = (Worker) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                    GWorker gw = new GWorker(w);

                    panels.get(i).AddGObject(gw);
                }
            }

        }
        for (int i = 0; i < panels.size(); i++) {


            if (game.GetWarehouse().GetFieldFromIndex(i).GetTrap() == null) {
                panels.get(i).GetGObjects().set(1, null);
            }


            if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() == null) {

                panels.get(i).GetGObjects().set(2, null);
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)).equals("SteppableField")) {
                    SteppableField s = (SteppableField) game.GetWarehouse().GetFieldFromIndex(i);
                    GSteppableField gs = new GSteppableField(s);
                    panels.get(i).AddGObject(gs);

                }
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)).equals("Wall")) {
                    Wall s = (Wall) game.GetWarehouse().GetFieldFromIndex(i);
                    GWall gs = new GWall(s);
                    panels.get(i).AddGObject(gs);
                }
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)).equals("TargetField")) {
                    TargetField s = (TargetField) game.GetWarehouse().GetFieldFromIndex(i);
                    GTargetField gs = new GTargetField(s);
                    panels.get(i).AddGObject(gs);
                }
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)).equals("Switch")) {
                    Switch s = (Switch) game.GetWarehouse().GetFieldFromIndex(i);
                    GSwitch gs = new GSwitch(s);
                    panels.get(i).AddGObject(gs);
                }
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)).equals("Hole")) {
                    Hole s = (Hole) game.GetWarehouse().GetFieldFromIndex(i);
                    GHole gs = new GHole(s);
                    panels.get(i).AddGObject(gs);
                }


            }
        }
        for (int i = 0; i < panels.size(); i++) {
            panels.get(i).Refresh();
        }
    }


    /**
     *
     * @param panel - A listához hozzáadja a paraméterként átvett panelt.
     */
    public void AddPanel(GPanel panel) {
        this.panels.add(panel);
        this.add(panel);
    }
}
