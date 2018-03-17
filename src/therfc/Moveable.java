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


    public void Die() {
        logger.Enter(this,"Die","");
        field.RemoveMoveable(this);
        logger.Enter(this,"Die","this moveable died");

    }


    public void SetWarehouse(Warehouse wh) {
        logger.Enter(this,"SetWarehouse","wh");
        this.wareHouse=wh;
        logger.Exit(this,"SetWarehouse","warehouse setted to wh");
    }


    public void SetField(Field f) {
        logger.Enter(this,"SetField","f");
        this.field=f;
        logger.Exit(this,"SetField","field setted to f");
    }

    public Field GetField(){
        return field;
    }

    public Warehouse GetWarehouse(){
        return wareHouse;
    }

}