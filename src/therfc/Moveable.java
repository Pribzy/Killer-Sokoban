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


    public abstract Boolean IsStuck(); //beragadást ellenőrző függvény a mezőn lévő mozgatható dologra


    public abstract Boolean CanPushToWall(); //a rajta lévő mozgatható dolog fel tudja-e tolni a munkást a falra,vagy sem


    public abstract void Die();

    public abstract int GetAllTraction(Direction d); //rekurzívan lekérdezni az elötte álló dolgok tapadását

    public abstract void ChangeTraction(int t); //hozzáadja az aktuális tapadásához a paraméterként kapott tapadást



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

    //stuck függvény:
    public Boolean CheckStuckInDirection(Direction d){ //rekurzívan leellenőrzi, hogy d irányba beragadt-e a Moveable
        logger.Enter(this,"CheckStuckInDirection",String.valueOf(d));
        Boolean stuckInDirection=false;
        Field NextField = this.GetField().GetNextField(d);
        if(NextField.GetMoveable()!=null){

            stuckInDirection= NextField.GetMoveable().CheckStuckInDirection(d);

        }
        else {
            stuckInDirection=!NextField.CheckStepOn();
        }
        logger.Exit(this,"CheckStuckInDirection",String.valueOf(stuckInDirection));
        return stuckInDirection;
    }


}