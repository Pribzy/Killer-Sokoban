package therfc;
import java.util.*;

/**
 * 
 */
public class Switch extends Field {


    //attribútumok
    private Hole hole;
    private Logger logger = new Logger();

    //konstruktor
    public Switch() {
    }

   //függvények
    public void StepOn(Worker w, Direction d) {// Ez történik Ha egy munkás Switchre lép
        logger.Enter(this, "StepOn", "w,d");
        Field previousField =  neighbors.get(d.OppositeDirection());
        if (this.GetMoveable() != null) {
            this.GetMoveable().Push(w, d);
            if (this.GetMoveable() == null) {
                previousField.RemoveMoveable(w);
                this.AddMoveable(w);
            }
        } else {
            previousField.RemoveMoveable(w);
            this.AddMoveable(w);
        }
        logger.Exit(this, "StepOn", "w stepped on switch");
    }


    public void StepOn(Box b, Direction d) {// Ez történik Ha egy doboz Sitch-re lép
        logger.Enter(this, "StepOn", "b,d");
        Field previousField =  neighbors.get(d.OppositeDirection());
        if (this.GetMoveable() != null) {
            Worker pushWorker = b.GetWorker();
            this.GetMoveable().Push(pushWorker, d);
            if (this.GetMoveable() == null) {
                previousField.RemoveMoveable(b);
                this.AddMoveable(b);
                hole.SetOpen(true);
            }
        } else {
            previousField.RemoveMoveable(b);
            this.AddMoveable(b);
            hole.SetOpen(true);
        }
        logger.Exit(this, "StepOn", "b stepped on switch");
    }


    public void SetHole(Hole h) { //Beállítja a lyukát
       this.hole=h;

    }

    @Override
    public void RemoveMoveable(Moveable m){
        logger.Enter(this,"RemoveMoveable",logger.GetObjectName(m));
        this.moveable=null;
        hole.SetOpen(false);
        logger.Exit(this,"RemoveMoveable",logger.GetObjectName(m)+" removed from "+logger.GetObjectName(this));

    }




}