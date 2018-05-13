package therfc.bin.UI.model_elements;

import therfc.bin.data.Box;
import therfc.res.Resources;

import java.awt.*;


public class GBox extends GObject {

    private Box box;
    private Image tractionImage;

    /**
     * @param b Átadja paraméterként a dobozt, amit meg fog jeleníteni
     */
    public GBox(Box b) {
        this.box = b;
        img = Resources.BoxImage;
        if (b.GetTraction() == 1) {
            tractionImage = Resources.OneImage_Blue;
        } else if (b.GetTraction() == 2) {
            tractionImage = Resources.TwoImage_Blue;
        } else if (b.GetTraction() == 3) {
            tractionImage = Resources.ThreeImage_Blue;
        } else if (b.GetTraction() == 4) {
            tractionImage = Resources.FourImage_Blue;
        } else if (b.GetTraction() == 5) {
            tractionImage = Resources.FiveImage_Blue;
        } else if (b.GetTraction() == 0) {
            tractionImage = Resources.ZeroImage_Blue;
        }
        this.z_index = 3;
    }

    /**
     * @param g JPanel átfestéséhez szükséges paraméter
     */
    @Override
    public void DrawGraphic(Graphics g) {

        g.drawImage(img, 0, 0, null);
        g.drawImage(tractionImage, 16, 16, null);

    }

}
