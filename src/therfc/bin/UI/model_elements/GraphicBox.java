package therfc.bin.UI.model_elements;
import therfc.bin.data.Box;
import therfc.res.Resources;
import java.awt.*;


public class GraphicBox extends GraphicObject {

    private Box box;

   public GraphicBox(Box b){
       this.box=b;
       z_index=3;
       img= Resources.BoxImage;

   }


    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }
}
