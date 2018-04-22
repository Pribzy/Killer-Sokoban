package therfc.bin.UI.model_elements;

import therfc.bin.data.SteppableField;
import therfc.bin.data.Worker;
import therfc.res.Resources;

import java.awt.*;

public class GraphicWorker extends GraphicObject {

    private Worker worker;

    public GraphicWorker(Worker w){
        this.worker=w;
        z_index=3;
        img= Resources.WorkerImage;

    }

    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }
}
