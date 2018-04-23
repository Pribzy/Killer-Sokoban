package therfc.bin.UI.components;

import jdk.nashorn.api.tree.GotoTree;
import therfc.bin.UI.model_elements.GObject;
import therfc.res.Resources;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GPanel extends JPanel {

    private List<GObject> gObjects;

    public GPanel(){

        this.setPreferredSize(new Dimension(24,24));
        this.gObjects = new ArrayList<GObject>();
        this.setVisible(true);

    }

    public void Refresh(List<GObject> refreshedObject){
        this.gObjects=refreshedObject;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <gObjects.size() ; i++) {
            gObjects.get(i).DrawGraphic(g);
        }
    }

    public void AddGObject(GObject o){
        gObjects.add(o);

    }







}
