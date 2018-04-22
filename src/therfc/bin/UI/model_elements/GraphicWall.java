package therfc.bin.UI.model_elements;

import therfc.bin.data.Box;
import therfc.bin.data.Wall;
import therfc.res.Resources;

import java.awt.*;

public class GraphicWall extends GraphicObject {
    private Wall wall;

    public GraphicWall(Wall w){
        this.wall=w;
        z_index=1;
        img= Resources.WallImage;

    }

    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }

}
