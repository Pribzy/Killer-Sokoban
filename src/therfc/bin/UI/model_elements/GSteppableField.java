package therfc.bin.UI.model_elements;

import therfc.bin.data.SteppableField;
import therfc.res.Resources;

import java.awt.*;

public class GSteppableField extends GObject {

    private SteppableField steppableField;

    /**
     * @param s Átadja paraméterként az alap mezőt, amit meg fog jeleníteni
     */
    public GSteppableField(SteppableField s) {
        this.steppableField = s;
        img = Resources.SteppableFieldImage;
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
