package therfc;
import java.util.*;

/**
 * 
 */
public abstract class Moveable {

    //attribútumok
    private Field field;
    private Warehouse wareHouse;
    private Logger logger= new Logger();

    //konstruktor
    public Moveable() {
    }

   //függvények
    public abstract void Push(Worker w, Direction d); //eltolódás függvénye


    public abstract Boolean IsStuck(); //beragadást ellenőrző függvény


    public abstract Boolean CanPushToWall(); //a rajta lévő mozgatható dolog fel tudja-e tolni a munkást a falra,vagy sem


    public abstract void Die();


    public void SetWarehouse(Warehouse wh) { //beállítja a hozzá tartozó Warehouse-t
        logger.Enter(this,"SetWarehouse",logger.GetObjectName(wh));
        this.wareHouse=wh;
        logger.Exit(this,"SetWarehouse","warehouse setted to :"+logger.GetObjectName(wh));
    }


    public void SetField(Field f) { //beállítja a hozzá tartozó Field-et
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