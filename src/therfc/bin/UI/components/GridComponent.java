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

    public GridComponent() {
        panels=new ArrayList<GPanel>();
        FillPanels();

        this.setLayout(new GridLayout(20, 20,0,0));
        this.setPreferredSize(new Dimension(480,480));
        this.setVisible(true);

    }


    public void RefreshTrap(){
        Logger logger = new Logger();

        for (int i = 0; i <panels.size() ; i++) {
            if (game.GetWarehouse().GetFieldFromIndex(i).GetTrap() != null) {
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i).GetTrap()) == "Honey") {
                    GHoney t = new GHoney(new Honey());
                    panels.get(i).AddGObject(t);
                }
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i).GetTrap()) == "Oil") {
                    GOil t = new GOil(new Oil());
                    panels.get(i).AddGObject(t);
                }
            }



        }
    }
    public void MoveObjects() {
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
    }
    public void RefreshFields(){
        Logger logger = new Logger();
        for (int i = 0; i < panels.size(); i++) {
            if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() == null) {

                if (game.GetWarehouse().GetFieldFromIndex(i).GetTrap() == null) { //csapdák leellenőrzése
                    panels.get(i).GetGObjects().set(1,null); }

                panels.get(i).GetGObjects().set(2,null);
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)) == "SteppableField") {
                    SteppableField s = (SteppableField) game.GetWarehouse().GetFieldFromIndex(i);
                    GSteppableField gs = new GSteppableField(s);
                    panels.get(i).AddGObject(gs);

                }
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)) == "Wall") {
                    Wall s = (Wall) game.GetWarehouse().GetFieldFromIndex(i);
                    GWall gs = new GWall(s);
                    panels.get(i).AddGObject(gs);
                }
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)) == "TargetField") {
                    TargetField s = (TargetField) game.GetWarehouse().GetFieldFromIndex(i);
                    GTargetField gs = new GTargetField(s);
                    panels.get(i).AddGObject(gs);
                }
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)) == "Switch") {
                    Switch s = (Switch) game.GetWarehouse().GetFieldFromIndex(i);
                    GSwitch gs = new GSwitch(s);
                    panels.get(i).AddGObject(gs);
                }
                if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)) == "Hole") {
                    Hole s = (Hole) game.GetWarehouse().GetFieldFromIndex(i);
                    GHole gs = new GHole(s);
                    panels.get(i).AddGObject(gs);
                }



            }
        }
    }





    public void FillPanels() {
        Logger logger = new Logger();
        GPanel newPanel;

        for (int i = 0; i < game.GetWarehouse().GetFields().size(); i++) {

            if (logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i)) == "Wall") {
                Wall w = (Wall) game.GetWarehouse().GetFields().get(i);
                GWall g = new GWall(w);
                newPanel = new GPanel();
                newPanel.AddGObject(g);
                panels.add(newPanel);
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
                        panels.add(newPanel);

                    } else if (!game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        TargetField s = (TargetField) game.GetWarehouse().GetFieldFromIndex(i);
                        GTargetField gs = new GTargetField(s);

                        newPanel.AddGObject(gs);

                        Worker w = (Worker) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        newPanel.AddGObject(g);
                        panels.add(newPanel);

                    }
                } else if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() == null) {

                    TargetField s = (TargetField) game.GetWarehouse().GetFieldFromIndex(i);
                    GTargetField gs = new GTargetField(s);

                    newPanel.AddGObject(gs);
                    panels.add(newPanel);
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
                        panels.add(newPanel);

                    } else if (!game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        SteppableField s = (SteppableField) game.GetWarehouse().GetFieldFromIndex(i);
                        GSteppableField gs = new GSteppableField(s);
                        //newPanel = new GPanel();
                        newPanel.AddGObject(gs);
                        Worker w = (Worker) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        newPanel.AddGObject(g);
                        panels.add(newPanel);
                    }
                } else if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() == null) {

                    SteppableField w = (SteppableField) game.GetWarehouse().GetFieldFromIndex(i);
                    GSteppableField g = new GSteppableField(w);
                    //newPanel = new GPanel();
                    newPanel.AddGObject(g);
                    panels.add(newPanel);


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
                        panels.add(newPanel);

                    } else if (!game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        Hole s = (Hole) game.GetWarehouse().GetFieldFromIndex(i);
                        GHole gs = new GHole(s);
                        //newPanel = new GPanel();
                        newPanel.AddGObject(gs);

                        Worker w = (Worker) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        newPanel.AddGObject(g);
                        panels.add(newPanel);
                    }
                } else if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() == null) {

                    Hole s = (Hole) game.GetWarehouse().GetFieldFromIndex(i);

                    GHole gs = new GHole(s);
                    //newPanel = new GPanel();
                    newPanel.AddGObject(gs);
                    panels.add(newPanel);


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
                        panels.add(newPanel);
                    } else if (!game.GetWarehouse().GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Switch s = (Switch) game.GetWarehouse().GetFieldFromIndex(i);

                        GSwitch gs = new GSwitch(s);
                        //newPanel = new GPanel();
                        newPanel.AddGObject(gs);

                        Worker w = (Worker) game.GetWarehouse().GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        newPanel.AddGObject(g);
                        panels.add(newPanel);
                    }
                } else if (game.GetWarehouse().GetFieldFromIndex(i).GetMoveable() == null) {

                    Switch s = (Switch) game.GetWarehouse().GetFieldFromIndex(i);
                    GSwitch gs = new GSwitch(s);
                    //newPanel = new GPanel();
                    newPanel.AddGObject(gs);
                    panels.add(newPanel);

                }
            }

            this.repaint();
        }
        for (int i = 0; i < 400; i++) {
            this.add(panels.get(i));
            panels.get(i).repaint();
        }
    }

    public void SetPanels(List<GPanel> panels) {
        this.panels = panels;
    }

    public List<GPanel> GetPanels() {
        return panels;
    }
}
