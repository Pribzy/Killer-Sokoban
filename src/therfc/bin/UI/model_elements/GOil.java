package therfc.bin.UI.model_elements;

import therfc.bin.data.Honey;
import therfc.bin.data.Oil;
import therfc.res.Resources;

import java.awt.*;

public class GOil extends GObject {


    private Oil oil;

    /**
     * @param s Átadja paraméterként az olajat, amit meg fog jeleníteni
     */
    public GOil(Oil s) {
        this.oil = s;
        img = Resources.OilImage;
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
