package therfc.bin.UI.model_elements;

import therfc.bin.data.Worker;
import therfc.res.Resources;

import java.awt.*;

public class GWorker extends GObject {

    private Worker worker;
    private Image powerImage;

    public GWorker(Worker w){
        this.worker=w;
        if(w.GetWarehouse().GetWorkers().indexOf(w)==0) {
            img = Resources.WorkerImage_Player1;
        }
        else if(w.GetWarehouse().GetWorkers().indexOf(w)==1) {
            img = Resources.WorkerImage_Player2;
        }
        else if(w.GetWarehouse().GetWorkers().indexOf(w)==2) {
            img = Resources.WorkerImage_Player3;
        }
        else if(w.GetWarehouse().GetWorkers().indexOf(w)==3) {
            img = Resources.WorkerImage_Player4;
        }
        if(w.GetPower()==1){
            powerImage=Resources.OneImage_Red;
        }
        else if(w.GetPower()==2){
            powerImage=Resources.TwoImage_Red;
        }
        else if(w.GetPower()==3){
            powerImage=Resources.ThreeImage_Red;
        }
        else if(w.GetPower()==4){
            powerImage=Resources.FourImage_Red;
        }
        this. z_index=3;
    }

    @Override
    public void DrawGraphic(Graphics g) {
        g.drawImage(img, 0,0,null);
        g.drawImage(powerImage, 8,8,null );
    }
}
