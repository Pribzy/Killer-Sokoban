package therfc.bin.UI.components;

import therfc.bin.UI.model_elements.*;
import therfc.bin.data.*;
import therfc.bin.data.Box;
import therfc.bin.main.Logger;

import java.awt.*;
import java.util.ArrayList;

import java.util.List;

public class GridComponent extends GraphicComponent {

    private List<GraphicPanel> graphicPanels= new ArrayList<GraphicPanel>();


    public GridComponent(Game g, Warehouse wh) {

        Refresh(wh);
        System.out.println(graphicPanels.size());
        this.setLayout(new GridLayout(20, 20));
        this.setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GraphicPanel dr : graphicPanels)
            dr.Draw(g);


    }

    @Override
    public void Refresh(Warehouse wh) {

        graphicPanels.clear();

        Logger logger = new Logger();
        GraphicPanel newPanel;

        for (int i = 0; i < wh.GetFields().size(); i++) {

            if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "Wall") {
                Wall w = (Wall) wh.GetFields().get(i);
                GraphicWall g = new GraphicWall(w);
                newPanel = new GraphicPanel();
                newPanel.AddGraphicObject(g);
                graphicPanels.add(newPanel);
            } else if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "TargetField") {
                if (wh.GetFieldFromIndex(i).GetMoveable() != null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        TargetField s = (TargetField) wh.GetFields().get(i);
                        GraphicTargetField gs = new GraphicTargetField(s);
                        newPanel = new GraphicPanel();
                        newPanel.AddGraphicObject(gs);

                        Box w = (Box) wh.GetFieldFromIndex(i).GetMoveable();
                        GraphicBox g = new GraphicBox(w);
                        newPanel = new GraphicPanel();
                        newPanel.AddGraphicObject(g);
                        graphicPanels.add(newPanel);

                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        TargetField s = (TargetField) wh.GetFieldFromIndex(i);
                        GraphicTargetField gs = new GraphicTargetField(s);
                        newPanel = new GraphicPanel();
                        newPanel.AddGraphicObject(gs);

                        Worker w = (Worker) wh.GetFieldFromIndex(i).GetMoveable();
                        GraphicWorker g = new GraphicWorker(w);
                        newPanel.AddGraphicObject(g);
                        graphicPanels.add(newPanel);

                    }
                } else if (wh.GetFieldFromIndex(i).GetMoveable() == null) {

                    TargetField s = (TargetField) wh.GetFieldFromIndex(i);
                    GraphicTargetField gs = new GraphicTargetField(s);
                    newPanel = new GraphicPanel();
                    newPanel.AddGraphicObject(gs);
                    graphicPanels.add(newPanel);
                }

            }

            if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "SteppableField") {
                if (wh.GetFieldFromIndex(i).GetMoveable() != null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        SteppableField s = (SteppableField) wh.GetFieldFromIndex(i);
                        GraphicSteppableField gs = new GraphicSteppableField(s);
                        newPanel = new GraphicPanel();
                        newPanel.AddGraphicObject(gs);
                        Box w = (Box) wh.GetFieldFromIndex(i).GetMoveable();
                        GraphicBox g = new GraphicBox(w);
                        newPanel = new GraphicPanel();
                        newPanel.AddGraphicObject(g);
                        graphicPanels.add(newPanel);

                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        SteppableField s = (SteppableField) wh.GetFieldFromIndex(i);
                        GraphicSteppableField gs = new GraphicSteppableField(s);
                        newPanel = new GraphicPanel();
                        newPanel.AddGraphicObject(gs);
                        Worker w = (Worker) wh.GetFieldFromIndex(i).GetMoveable();
                        GraphicWorker g = new GraphicWorker(w);
                        newPanel.AddGraphicObject(g);
                        graphicPanels.add(newPanel);
                    }
                } else if (wh.GetFieldFromIndex(i).GetMoveable() == null) {

                    SteppableField w = (SteppableField) wh.GetFieldFromIndex(i);
                    GraphicSteppableField g = new GraphicSteppableField(w);
                    newPanel = new GraphicPanel();
                    newPanel.AddGraphicObject(g);
                    graphicPanels.add(newPanel);


                }
            } else if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "Hole") {
                if (wh.GetFieldFromIndex(i).GetMoveable() != null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Hole s = new Hole();
                        GraphicHole gs = new GraphicHole(s);
                        newPanel = new GraphicPanel();
                        newPanel.AddGraphicObject(gs);

                        Box w = (Box) wh.GetFieldFromIndex(i).GetMoveable();
                        GraphicBox g = new GraphicBox(w);
                        newPanel = new GraphicPanel();
                        newPanel.AddGraphicObject(g);
                        graphicPanels.add(newPanel);

                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        Hole s = (Hole) wh.GetFieldFromIndex(i);
                        GraphicHole gs = new GraphicHole(s);
                        newPanel = new GraphicPanel();
                        newPanel.AddGraphicObject(gs);

                        Worker w = (Worker) wh.GetFieldFromIndex(i).GetMoveable();
                        GraphicWorker g = new GraphicWorker(w);
                        newPanel.AddGraphicObject(g);
                        graphicPanels.add(newPanel);
                    }
                } else if (wh.GetFieldFromIndex(i).GetMoveable() == null) {

                    Hole s = (Hole) wh.GetFieldFromIndex(i);

                    GraphicHole gs = new GraphicHole(s);
                    newPanel = new GraphicPanel();
                    newPanel.AddGraphicObject(gs);
                    graphicPanels.add(newPanel);


                }
            } else if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "Switch") {
                if (wh.GetFieldFromIndex(i).GetMoveable() != null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Switch s = new Switch();
                        GraphicSwitch gs = new GraphicSwitch(s);
                        newPanel = new GraphicPanel();
                        newPanel.AddGraphicObject(gs);

                        Box w = (Box) wh.GetFieldFromIndex(i).GetMoveable();
                        GraphicBox g = new GraphicBox(w);
                        newPanel = new GraphicPanel();
                        newPanel.AddGraphicObject(g);
                        graphicPanels.add(newPanel);
                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Switch s = (Switch) wh.GetFieldFromIndex(i);

                        GraphicSwitch gs = new GraphicSwitch(s);
                        newPanel = new GraphicPanel();
                        newPanel.AddGraphicObject(gs);

                        Worker w = (Worker) wh.GetFieldFromIndex(i).GetMoveable();
                        GraphicWorker g = new GraphicWorker(w);
                        newPanel.AddGraphicObject(g);
                        graphicPanels.add(newPanel);
                    }
                } else if (wh.GetFieldFromIndex(i).GetMoveable() == null) {

                    Switch s = (Switch) wh.GetFieldFromIndex(i);
                    GraphicSwitch gs = new GraphicSwitch(s);
                    newPanel = new GraphicPanel();
                    newPanel.AddGraphicObject(gs);
                    graphicPanels.add(newPanel);

                }
            }

        this.repaint();
        }
        for (int i = 0; i < 400; i++) {
            this.add(graphicPanels.get(i));
            graphicPanels.get(i).repaint();
        }




    }



    public void FillPanels(Warehouse wh) {
        Refresh(wh);
    }

    public List<GraphicPanel> GetGraphicPanels() {
        return graphicPanels;
    }
}
