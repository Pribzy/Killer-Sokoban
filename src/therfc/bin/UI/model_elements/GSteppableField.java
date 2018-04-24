package therfc.bin.UI.model_elements;

import therfc.bin.data.SteppableField;
import therfc.res.Resources;

import java.awt.*;

public class GSteppableField extends GObject {

    private SteppableField steppableField;

    public GSteppableField(SteppableField s){
        this.steppableField=s;
        img= Resources.SteppableFieldImage;
        this. z_index=1;
    }


    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }
}
