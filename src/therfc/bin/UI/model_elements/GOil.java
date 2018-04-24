package therfc.bin.UI.model_elements;

import therfc.bin.data.Honey;
import therfc.bin.data.Oil;
import therfc.res.Resources;

import java.awt.*;

public class GOil extends GObject {


    private Oil oil;

    public GOil(Oil s){
        this.oil=s;
        img= Resources.OilImage;
        this.z_index=2;

    }

    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }
}
