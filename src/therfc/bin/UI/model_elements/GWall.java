package therfc.bin.UI.model_elements;

import therfc.bin.data.Wall;
import therfc.res.Resources;

import java.awt.*;

public class GWall extends GObject {
    private Wall wall;

    public GWall(Wall w){
        this.wall=w;
        img= Resources.WallImage;
        this.z_index=1;
    }

    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }

}
