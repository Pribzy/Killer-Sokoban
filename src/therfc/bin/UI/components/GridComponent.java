package therfc.bin.UI.components;

import therfc.bin.UI.model_elements.*;
import therfc.bin.data.*;
import therfc.bin.main.Logger;

import java.awt.*;
import java.util.ArrayList;

import java.util.List;

public class GridComponent extends GraphicComponent {

    private List<GPanel> panels;


    public GridComponent(Game g, Warehouse wh) {
        panels=new ArrayList<GPanel>();

        FillPanels(wh);

        this.setLayout(new GridLayout(20, 20,0,0));

        this.setVisible(true);

    }



    @Override
    public void Refresh(Warehouse wh) {
        List<GObject> list;
        Logger logger = new Logger();
        for (int i = 0; i <panels.size() ; i++) {
            if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "Wall") {
               list = new ArrayList<GObject>();
               list.add(new GWall(new Wall()));
               panels.get(i).Refresh(list);
            }
            if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "SteppableField") {
                if (wh.GetFieldFromIndex(i).GetMoveable() != null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        SteppableField s = (SteppableField) wh.GetFieldFromIndex(i);
                        GSteppableField gs = new GSteppableField(s);
                        Box w = (Box) wh.GetFieldFromIndex(i).GetMoveable();
                        GBox g = new GBox(w);
                        list = new ArrayList<GObject>();
                        list.add(gs);
                        if(wh.GetFieldFromIndex(i).GetTrap()!=null){
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Honey") {
                                GHoney t = new GHoney(new Honey());
                                list.add(t);
                            }
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Oil") {
                                GOil t = new GOil(new Oil());
                                list.add(t);
                            }
                        }


                        list.add(g);
                        panels.get(i).Refresh(list);

                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        SteppableField s = (SteppableField) wh.GetFieldFromIndex(i);
                        GSteppableField gs = new GSteppableField(s);

                        Worker w = (Worker) wh.GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);

                        list = new ArrayList<GObject>();
                        list.add(gs);
                        if(wh.GetFieldFromIndex(i).GetTrap()!=null){
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Honey") {
                                GHoney t = new GHoney(new Honey());
                                list.add(t);
                            }
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Oil") {
                                GOil t = new GOil(new Oil());
                                list.add(t);
                            }
                        }
                        list.add(g);
                        panels.get(i).Refresh(list);
                    }
                } else if (wh.GetFieldFromIndex(i).GetMoveable() == null) {

                    SteppableField w = (SteppableField) wh.GetFieldFromIndex(i);
                    GSteppableField g = new GSteppableField(w);
                    list = new ArrayList<GObject>();
                    list.add(g);
                    if(wh.GetFieldFromIndex(i).GetTrap()!=null){
                        if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Honey") {
                            GHoney t = new GHoney(new Honey());
                            list.add(t);
                        }
                        if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Oil") {
                            GOil t = new GOil(new Oil());
                            list.add(t);
                        }
                    }
                    panels.get(i).Refresh(list);


                }
            }
            if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "TargetField") {
                if (wh.GetFieldFromIndex(i).GetMoveable() != null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        TargetField s = (TargetField) wh.GetFields().get(i);
                        GTargetField gs = new GTargetField(s);


                        Box w = (Box) wh.GetFieldFromIndex(i).GetMoveable();
                        GBox g = new GBox(w);
                        list = new ArrayList<GObject>();
                        list.add(gs);
                        if(wh.GetFieldFromIndex(i).GetTrap()!=null){
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Honey") {
                                GHoney t = new GHoney(new Honey());
                                list.add(t);
                            }
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Oil") {
                                GOil t = new GOil(new Oil());
                                list.add(t);
                            }
                        }
                        list.add(g);
                        panels.get(i).Refresh(list);


                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        TargetField s = (TargetField) wh.GetFieldFromIndex(i);
                        GTargetField gs = new GTargetField(s);


                        Worker w = (Worker) wh.GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        list = new ArrayList<GObject>();
                        list.add(gs);
                        if(wh.GetFieldFromIndex(i).GetTrap()!=null){
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Honey") {
                                GHoney t = new GHoney(new Honey());
                                list.add(t);
                            }
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Oil") {
                                GOil t = new GOil(new Oil());
                                list.add(t);
                            }
                        }
                        list.add(g);
                        panels.get(i).Refresh(list);


                    }
                } else if (wh.GetFieldFromIndex(i).GetMoveable() == null) {

                    TargetField s = (TargetField) wh.GetFieldFromIndex(i);
                    GTargetField gs = new GTargetField(s);
                    list = new ArrayList<GObject>();
                    list.add(gs);
                    if(wh.GetFieldFromIndex(i).GetTrap()!=null){
                        if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Honey") {
                            GHoney t = new GHoney(new Honey());
                            list.add(t);
                        }
                        if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Oil") {
                            GOil t = new GOil(new Oil());
                            list.add(t);
                        }
                    }
                    panels.get(i).Refresh(list);
                }

            }
            if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "Hole") {
                if (wh.GetFieldFromIndex(i).GetMoveable() != null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Hole s = new Hole();
                        GHole gs = new GHole(s);


                        Box w = (Box) wh.GetFieldFromIndex(i).GetMoveable();
                        GBox g = new GBox(w);
                        list = new ArrayList<GObject>();
                        list.add(gs);
                        if(wh.GetFieldFromIndex(i).GetTrap()!=null){
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Honey") {
                                GHoney t = new GHoney(new Honey());
                                list.add(t);
                            }
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Oil") {
                                GOil t = new GOil(new Oil());
                                list.add(t);
                            }
                        }
                        list.add(g);
                        panels.get(i).Refresh(list);


                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        Hole s = (Hole) wh.GetFieldFromIndex(i);
                        GHole gs = new GHole(s);


                        Worker w = (Worker) wh.GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        list = new ArrayList<GObject>();
                        list.add(gs);
                        if(wh.GetFieldFromIndex(i).GetTrap()!=null){
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Honey") {
                                GHoney t = new GHoney(new Honey());
                                list.add(t);
                            }
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Oil") {
                                GOil t = new GOil(new Oil());
                                list.add(t);
                            }
                        }
                        list.add(g);
                        panels.get(i).Refresh(list);

                    }
                } else if (wh.GetFieldFromIndex(i).GetMoveable() == null) {

                    Hole s = (Hole) wh.GetFieldFromIndex(i);
                    GHole gs = new GHole(s);
                    list = new ArrayList<GObject>();
                    list.add(gs);
                    if(wh.GetFieldFromIndex(i).GetTrap()!=null){
                        if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Honey") {
                            GHoney t = new GHoney(new Honey());
                            list.add(t);
                        }
                        if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Oil") {
                            GOil t = new GOil(new Oil());
                            list.add(t);
                        }
                    }
                    panels.get(i).Refresh(list);



                }
            }
            if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "Switch") {
                if (wh.GetFieldFromIndex(i).GetMoveable() != null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Switch s = new Switch();
                        GSwitch gs = new GSwitch(s);
                        Box w = (Box) wh.GetFieldFromIndex(i).GetMoveable();
                        GBox g = new GBox(w);
                        list = new ArrayList<GObject>();
                        list.add(gs);
                        if(wh.GetFieldFromIndex(i).GetTrap()!=null){
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Honey") {
                                GHoney t = new GHoney(new Honey());
                                list.add(t);
                            }
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Oil") {
                                GOil t = new GOil(new Oil());
                                list.add(t);
                            }
                        }
                        list.add(g);
                        panels.get(i).Refresh(list);

                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Switch s = (Switch) wh.GetFieldFromIndex(i);

                        GSwitch gs = new GSwitch(s);


                        Worker w = (Worker) wh.GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        list = new ArrayList<GObject>();
                        list.add(gs);
                        if(wh.GetFieldFromIndex(i).GetTrap()!=null){
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Honey") {
                                GHoney t = new GHoney(new Honey());
                                list.add(t);
                            }
                            if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Oil") {
                                GOil t = new GOil(new Oil());
                                list.add(t);
                            }
                        }
                        list.add(g);
                        panels.get(i).Refresh(list);

                    }
                } else if (wh.GetFieldFromIndex(i).GetMoveable() == null) {

                    Switch s = (Switch) wh.GetFieldFromIndex(i);
                    GSwitch gs = new GSwitch(s);
                    list = new ArrayList<GObject>();
                    list.add(gs);
                    if(wh.GetFieldFromIndex(i).GetTrap()!=null){
                        if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Honey") {
                            GHoney t = new GHoney(new Honey());
                            list.add(t);
                        }
                        if(logger.GetObjectName(wh.GetFieldFromIndex(i).GetTrap())=="Oil") {
                            GOil t = new GOil(new Oil());
                            list.add(t);
                        }
                    }
                    panels.get(i).Refresh(list);


                }
            }
        }








    }



    public void FillPanels(Warehouse wh) {
        Logger logger = new Logger();
        GPanel newPanel;

        for (int i = 0; i < wh.GetFields().size(); i++) {

            if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "Wall") {
                Wall w = (Wall) wh.GetFields().get(i);
                GWall g = new GWall(w);
                newPanel = new GPanel();
                newPanel.AddGObject(g);
                panels.add(newPanel);
            } else if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "TargetField") {
                if (wh.GetFieldFromIndex(i).GetMoveable() != null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        TargetField s = (TargetField) wh.GetFields().get(i);
                        GTargetField gs = new GTargetField(s);
                        newPanel = new GPanel();
                        newPanel.AddGObject(gs);

                        Box w = (Box) wh.GetFieldFromIndex(i).GetMoveable();
                        GBox g = new GBox(w);
                        newPanel = new GPanel();
                        newPanel.AddGObject(g);
                        panels.add(newPanel);

                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        TargetField s = (TargetField) wh.GetFieldFromIndex(i);
                        GTargetField gs = new GTargetField(s);
                        newPanel = new GPanel();
                        newPanel.AddGObject(gs);

                        Worker w = (Worker) wh.GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        newPanel.AddGObject(g);
                        panels.add(newPanel);

                    }
                } else if (wh.GetFieldFromIndex(i).GetMoveable() == null) {

                    TargetField s = (TargetField) wh.GetFieldFromIndex(i);
                    GTargetField gs = new GTargetField(s);
                    newPanel = new GPanel();
                    newPanel.AddGObject(gs);
                    panels.add(newPanel);
                }

            }

            if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "SteppableField") {
                if (wh.GetFieldFromIndex(i).GetMoveable() != null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        SteppableField s = (SteppableField) wh.GetFieldFromIndex(i);
                        GSteppableField gs = new GSteppableField(s);
                        newPanel = new GPanel();
                        newPanel.AddGObject(gs);
                        Box w = (Box) wh.GetFieldFromIndex(i).GetMoveable();
                        GBox g = new GBox(w);
                        newPanel = new GPanel();
                        newPanel.AddGObject(g);
                        panels.add(newPanel);

                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        SteppableField s = (SteppableField) wh.GetFieldFromIndex(i);
                        GSteppableField gs = new GSteppableField(s);
                        newPanel = new GPanel();
                        newPanel.AddGObject(gs);
                        Worker w = (Worker) wh.GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        newPanel.AddGObject(g);
                        panels.add(newPanel);
                    }
                } else if (wh.GetFieldFromIndex(i).GetMoveable() == null) {

                    SteppableField w = (SteppableField) wh.GetFieldFromIndex(i);
                    GSteppableField g = new GSteppableField(w);
                    newPanel = new GPanel();
                    newPanel.AddGObject(g);
                    panels.add(newPanel);


                }
            } else if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "Hole") {
                if (wh.GetFieldFromIndex(i).GetMoveable() != null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Hole s = new Hole();
                        GHole gs = new GHole(s);
                        newPanel = new GPanel();
                        newPanel.AddGObject(gs);

                        Box w = (Box) wh.GetFieldFromIndex(i).GetMoveable();
                        GBox g = new GBox(w);
                        newPanel = new GPanel();
                        newPanel.AddGObject(g);
                        panels.add(newPanel);

                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {

                        Hole s = (Hole) wh.GetFieldFromIndex(i);
                        GHole gs = new GHole(s);
                        newPanel = new GPanel();
                        newPanel.AddGObject(gs);

                        Worker w = (Worker) wh.GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        newPanel.AddGObject(g);
                        panels.add(newPanel);
                    }
                } else if (wh.GetFieldFromIndex(i).GetMoveable() == null) {

                    Hole s = (Hole) wh.GetFieldFromIndex(i);

                    GHole gs = new GHole(s);
                    newPanel = new GPanel();
                    newPanel.AddGObject(gs);
                    panels.add(newPanel);


                }
            } else if (logger.GetObjectName(wh.GetFieldFromIndex(i)) == "Switch") {
                if (wh.GetFieldFromIndex(i).GetMoveable() != null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Switch s = new Switch();
                        GSwitch gs = new GSwitch(s);
                        newPanel = new GPanel();
                        newPanel.AddGObject(gs);

                        Box w = (Box) wh.GetFieldFromIndex(i).GetMoveable();
                        GBox g = new GBox(w);
                        newPanel = new GPanel();
                        newPanel.AddGObject(g);
                        panels.add(newPanel);
                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        Switch s = (Switch) wh.GetFieldFromIndex(i);

                        GSwitch gs = new GSwitch(s);
                        newPanel = new GPanel();
                        newPanel.AddGObject(gs);

                        Worker w = (Worker) wh.GetFieldFromIndex(i).GetMoveable();
                        GWorker g = new GWorker(w);
                        newPanel.AddGObject(g);
                        panels.add(newPanel);
                    }
                } else if (wh.GetFieldFromIndex(i).GetMoveable() == null) {

                    Switch s = (Switch) wh.GetFieldFromIndex(i);
                    GSwitch gs = new GSwitch(s);
                    newPanel = new GPanel();
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
