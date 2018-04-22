package therfc.bin.UI.model_elements;

import therfc.bin.data.TargetField;
import therfc.bin.data.Wall;
import therfc.res.Resources;

import java.awt.*;

public class GraphicTargetField extends GraphicObject {

    private TargetField targetfield;

    public GraphicTargetField(TargetField t){
        this.targetfield=t;
        z_index=1;
        if(t.GetActive()) {
            img = Resources.ActiveTargetFieldImage;
        }
        else if(!t.GetActive()){
            img = Resources.InActiveTargetFieldImage;
        }

    }


    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }
}
