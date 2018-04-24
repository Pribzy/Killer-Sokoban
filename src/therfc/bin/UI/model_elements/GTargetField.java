package therfc.bin.UI.model_elements;

import therfc.bin.data.TargetField;
import therfc.res.Resources;

import java.awt.*;

public class GTargetField extends GObject {

    private TargetField targetfield;

    public GTargetField(TargetField t){
        this.targetfield=t;
        if(t.GetActive()) {
            img = Resources.ActiveTargetFieldImage;
        }
        else if(!t.GetActive()){
            img = Resources.InActiveTargetFieldImage;
        }
        this.z_index=1;

    }


    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }
}
