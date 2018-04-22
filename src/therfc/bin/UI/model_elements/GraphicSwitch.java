package therfc.bin.UI.model_elements;

import therfc.bin.data.SteppableField;
import therfc.bin.data.Switch;
import therfc.res.Resources;

import java.awt.*;

public class GraphicSwitch extends GraphicObject {

    private Switch myswitch;

    public GraphicSwitch(Switch s){
        this.myswitch=s;
        z_index=1;
        img= Resources.SwitchImage;

    }

    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }
}
