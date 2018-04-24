package therfc.bin.UI.components;

import jdk.nashorn.api.tree.GotoTree;
import therfc.bin.UI.model_elements.GHole;
import therfc.bin.UI.model_elements.GObject;
import therfc.bin.data.Hole;
import therfc.res.Resources;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GPanel extends JPanel {

    private List<GObject> gObjects;

    public GPanel(){

        this.setPreferredSize(new Dimension(24,24));
        this.gObjects = new ArrayList<GObject>(3);
        this.gObjects.add(null);
        this.gObjects.add(null);
        this.gObjects.add(null);
        this.setVisible(true);

    }

    public void Refresh(){
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <gObjects.size() ; i++) {
            if(gObjects.get(i)==null){}
            else {
                gObjects.get(i).DrawGraphic(g);
            }
        }
    }

    public void AddGObject(GObject o){
        gObjects.set(o.GetZIndex()-1,o);
        Refresh();

    }
    public void ReplaceGObject(GObject o){


        Refresh();

    }

    public void SetPanel(List<GObject> refreshedObject){

    }
    public void SortPanel(){

    }







}
