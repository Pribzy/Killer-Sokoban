package therfc.bin.UI.model_elements;

import therfc.bin.data.Worker;
import therfc.res.Resources;

import java.awt.*;

public class GWorker extends GObject {

    private Worker worker;

    public GWorker(Worker w){
        this.worker=w;
        img= Resources.WorkerImage;
        this. z_index=3;
    }

    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
    }
}
