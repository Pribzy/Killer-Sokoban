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

    //konstruktor
    public Moveable() {
    }

   //függvények
    public abstract void Push(Worker w, Direction d);


    public abstract Boolean IsStuck();


    public abstract Boolean CanPushToWall();


    public void Die() {
        // TODO implement here

    }


    public void SetWarehouse(Warehouse wh) {
       this.wareHouse=wh;
    }


    public void SetField(Field f) {
        this.field=f;
    }

    public Field GetField(){
        return field;
    }

    public Warehouse GetWarehouse(){
        return wareHouse;
    }

}