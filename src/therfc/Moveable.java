package therfc;
import java.util.*;

/**
 * 
 */
public abstract class Moveable {

    //attribútumok
    private Boolean pushedToWall;
    private Field field;
    private Warehouse wareHouse;
    private Logger logger= new Logger();

    //konstruktor
    public Moveable() {
    }

   //függvények
    public abstract void Push(Worker w, Direction d);


    public abstract Boolean IsStuck();


    public abstract Boolean CanPushToWall();


    public abstract void Die();


    public void SetWarehouse(Warehouse wh) {
        logger.Enter(this,"SetWarehouse",logger.GetObjectName(wh));
        this.wareHouse=wh;
        logger.Exit(this,"SetWarehouse","warehouse setted to :"+logger.GetObjectName(wh));
    }


    public void SetField(Field f) {
        logger.Enter(this,"SetField",logger.GetObjectName(f));
        this.field=f;
        logger.Exit(this,"SetField","field setted to :"+logger.GetObjectName(f));
    }

    public Field GetField(){

        return field;
    }

    public Warehouse GetWarehouse(){
        return wareHouse;
    }

}