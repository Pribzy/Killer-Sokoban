package therfc.bin.UI.model_elements;

import therfc.bin.data.Switch;
import therfc.res.Resources;

import java.awt.*;

public class GSwitch extends GObject {

    private Switch myswitch;

    /**
     *
     * @param s Átadja paraméterként a váltót, amit meg fog jeleníteni
     */
    public GSwitch(Switch s) {
        this.myswitch = s;
        img = Resources.SwitchImage;
        this.z_index = 1;
    }

    /**
     *
     * @param g JPanel átfestéséhez szükséges paraméter
     */
    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
