package therfc.bin.UI.model_elements;

import therfc.bin.data.TargetField;
import therfc.res.Resources;

import java.awt.*;

public class GTargetField extends GObject {

    private TargetField targetfield;

    /**
     * @param t Átadja paraméterként azt a célmezőt, amit meg fog jeleníteni
     */
    public GTargetField(TargetField t) {
        this.targetfield = t;
        if (t.GetActive()) {
            img = Resources.ActiveTargetFieldImage;
        } else if (!t.GetActive()) {
            img = Resources.InActiveTargetFieldImage;
        }
        this.z_index = 1;

    }

    /**
     * @param g JPanel átfestéséhez szükséges paraméter
     */
    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
