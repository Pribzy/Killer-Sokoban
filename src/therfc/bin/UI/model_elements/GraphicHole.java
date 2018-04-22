package therfc.bin.UI.model_elements;

import therfc.bin.data.Hole;
import therfc.res.Resources;

import java.awt.*;

public class GraphicHole extends GraphicObject {

    private Hole hole;

    public GraphicHole(Hole h){
        this.hole=h;
        z_index=1;
        if(h.GetOpen()) {
            img = Resources.OpenHoleImage;
        }
        else if(!h.GetOpen()){
            img = Resources.CloseHoleImage;
        }

    }


    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }
}
