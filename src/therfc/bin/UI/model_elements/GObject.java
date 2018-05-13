package therfc.bin.UI.model_elements;

import java.awt.*;

public abstract class GObject {
    protected Image img;
    protected int z_index;

    /**
     * @return Visszatér a z_index értékével. Minél nagyobb, annál előrébb van
     */
    public int GetZIndex() {
        return z_index;
    }

    /**
     * @param g JPanel átfestéséhez szükséges paraméter
     */
    public abstract void DrawGraphic(Graphics g);


}
