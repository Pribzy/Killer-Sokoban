package therfc.bin.UI.model_elements;

import therfc.bin.data.Box;
import therfc.bin.data.SteppableField;
import therfc.res.Resources;

import java.awt.*;

public class GraphicSteppableField extends GraphicObject {

    private SteppableField steppableField;

    public GraphicSteppableField(SteppableField s){
        this.steppableField=s;
        z_index=1;
        img= Resources.SteppableFieldImage;

    }


    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }
}
