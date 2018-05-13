package therfc.bin.UI.model_elements;

import therfc.bin.data.Hole;
import therfc.res.Resources;

import java.awt.*;

public class GHole extends GObject {

    private Hole hole;

    /**
     * @param h Átadja paraméterként a lyukat, amit meg fog jeleníteni
     */
    public GHole(Hole h) {
        this.hole = h;
        if (h.GetOpen()) {
            img = Resources.OpenHoleImage;
        } else if (!h.GetOpen()) {
            img = Resources.CloseHoleImage;
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
