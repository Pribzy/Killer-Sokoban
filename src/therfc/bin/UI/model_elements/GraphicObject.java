package therfc.bin.UI.model_elements;

import java.awt.*;

public abstract class GraphicObject {
    protected Image img;
    protected Integer z_index;


    public Image GetImg() {
        return img;
    }

    public void SetImg(Image img) {
        this.img = img;
    }

    public Integer GetZ_index() {
        return z_index;
    }

    public void SetZ_index(Integer z_index) {
        this.z_index = z_index;
    }

    public abstract void DrawGraphic(Graphics g);



}
