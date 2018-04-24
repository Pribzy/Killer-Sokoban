package therfc.bin.UI.model_elements;
import therfc.bin.data.Box;
import therfc.res.Resources;
import java.awt.*;


public class GBox extends GObject {

    private Box box;

   public GBox(Box b){
       this.box=b;
       img= Resources.BoxImage;
       this.z_index=3;
   }


    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }
}
