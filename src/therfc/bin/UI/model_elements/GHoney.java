package therfc.bin.UI.model_elements;

import therfc.bin.data.Honey;
import therfc.bin.data.Switch;
import therfc.res.Resources;

import java.awt.*;

public class GHoney extends GObject {

    private Honey honey;

    /**
     * @param s Átadja paraméterként a mézet, amit meg fog jeleníteni
     */
    public GHoney(Honey s) {
        this.honey = s;
        img = Resources.HoneyImage;
        this.z_index = 2;

    }

    /**
     * @param g JPanel átfestéséhez szükséges paraméter
     */
    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
