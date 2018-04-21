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

    /**
     *
     * @param w Átadja paraméterként, hogy melyik munkás tol
     * @param d Átadja paraméterként, hogy melyik irányba lesz tolva
     */
    public abstract void Push(Worker w, Direction d); //eltolódás függvénye

    /**
     *
     * @return Visszatér, hogy beragadt-e
     */
    public abstract Boolean IsStuck(); //beragadást ellenőrző függvény a mezőn lévő mozgatható dologra

    /**
     *
     * @return Visszaadja, hogy fel tudje-e tolni a munkást
     */
    public abstract Boolean CanPushToWall(); //a rajta lévő mozgatható dolog fel tudja-e tolni a munkást a falra,vagy sem

    /**
     *
     */
    public abstract void Die();

    /**
     *
     * @param d Átadja paraméterben az irányt, ahonnan az erőket számoljuk össze
     * @return Visszatér a d irányban lévő erők összegével
     */
    public abstract int GetAllTraction(Direction d); //rekurzívan lekérdezni az elötte álló dolgok tapadását

    /**
     *
     * @param t Hozzáadja az aktuális tapadáshoz a kapott tapadást
     */
    public abstract void ChangeTraction(int t); //hozzáadja az aktuális tapadásához a paraméterként kapott tapadást


    /**
     *
     * @param wh Beállítja a paraméterként átvett Raktárt
     */
    public void SetWarehouse(Warehouse wh) { //beállítja a hozzá tartozó Warehouse-t
        //logger.Enter(this,"SetWarehouse",logger.GetObjectName(wh));
        this.wareHouse=wh;
       // logger.Exit(this,"SetWarehouse","warehouse setted to :"+logger.GetObjectName(wh));
    }

    /**
     *
     * @param f Beállítja a paraméterként átvett mezőt
     */
    public void SetField(Field f) { //beállítja a hozzá tartozó Field-et
        //logger.Enter(this,"SetField",logger.GetObjectName(f));
        this.field=f;
       // logger.Exit(this,"SetField","field setted to :"+logger.GetObjectName(f));
    }

    /**
     *
     * @return Visszaadja a mezőt, amin jelenleg van
     */
    public Field GetField(){

        return field;
    }

    /**
     *
     * @return Visszaadja a Raktárt, amiben van
     */
    public Warehouse GetWarehouse(){
        return wareHouse;
    }

    //stuck függvény:

    /**
     *
     * @param d Rekurzívan leellenőrzi d irányba, hogy beragadt-e
     * @return Visszatér, hogy beragadt-e az adott irányba
     */
    public Boolean CheckStuckInDirection(Direction d){ //rekurzívan leellenőrzi, hogy d irányba beragadt-e a Moveable
       // logger.Enter(this,"CheckStuckInDirection",String.valueOf(d));
        Boolean stuckInDirection=false;
        Field NextField = this.GetField().GetNextField(d);
        if(NextField.GetMoveable()!=null){

            stuckInDirection= NextField.GetMoveable().CheckStuckInDirection(d);

        }
        else {
            stuckInDirection=!NextField.CheckStepOn();
        }
       // logger.Exit(this,"CheckStuckInDirection",String.valueOf(stuckInDirection));
        return stuckInDirection;
    }


}