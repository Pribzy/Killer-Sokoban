package therfc.bin.UI.components;

import therfc.bin.UI.model_elements.GraphicObject;
import therfc.res.Resources;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicPanel extends JPanel {

    private List<GraphicObject> graphicObjectList = new ArrayList<GraphicObject>() ;

    public GraphicPanel(){

        this.setPreferredSize(new Dimension(24,24));

        this.setVisible(true);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       Draw(g);

    }


    public void AddGraphicObject(GraphicObject go){
        graphicObjectList.add(go);
    }

    public void Draw(Graphics g){

        for (GraphicObject aGraphicObjectList : graphicObjectList) {
            aGraphicObjectList.DrawGraphic(g);
        }
    }


}
