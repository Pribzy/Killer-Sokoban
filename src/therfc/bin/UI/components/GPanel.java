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

    /**
     * GPanel konstruktora
     */

    public GPanel(){

        this.setPreferredSize(new Dimension(32,32));
        this.gObjects = new ArrayList<GObject>(4);
        this.gObjects.add(null);
        this.gObjects.add(null);
        this.gObjects.add(null);
        this.gObjects.add(null);
        this.setVisible(true);

    }

    /**
     * Frissíti a panelen lévő objektumokat és újra kirajzolja az aktuális objektumoka, amik rajta vannak.
     */

    public void Refresh(){

        repaint();
    }

    /**
     *
     * @param g JPanel átfestéséhez szükséges paraméter
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GObject gObject : gObjects) {
            if (gObject == null) {
            } else {
                gObject.DrawGraphic(g);
            }
        }
    }


    /**
     *
     * @param o - Hozzáad egy GObjektumot a listához.
     */
    public void AddGObject(GObject o){

        gObjects.set(o.GetZIndex()-1,o);



    }



    public List<GObject> GetGObjects(){
        return gObjects;
    }







}
