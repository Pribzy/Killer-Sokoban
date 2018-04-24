package therfc.bin.UI.model_elements;

import java.awt.*;

public abstract class GObject {
    protected Image img;
    protected int z_index;

    public int GetZIndex(){
        return z_index;
    }

    public abstract void DrawGraphic(Graphics g);



}
