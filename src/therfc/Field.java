package therfc;
import java.util.*;

/**
 * 
 */
public abstract class Field {

    //attribútumok
    protected Map<Direction,Field> neighbors = new HashMap<>();
    protected Moveable moveable;
    private Trap trap;
    private Logger logger = new Logger();

    //konstruktor
    public Field() {
    }
    //függvények

    /**
     *
     * @param w Megkapja paraméterként a munkást, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a munkást fogja tenni
     */
    public abstract void StepOn(Worker w, Direction d);// Ez történik Ha egy munkás  egy mezőre lép

    /**
     *
     * @param b Megkapja paraméterként a dobozt, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a dobozt foja tenni
     */
    public abstract void StepOn(Box b, Direction d);// Ez történik Ha egy doboz  egy mezőre lép

    /**
     *
     * @param m Magára teszi a Moveable objektumot a mező
     */
    public void AddMoveable(Moveable m) {

        //logger.Enter(this,"AddMoveable",logger.GetObjectName(m));
        this.moveable=m;
        m.SetField(this);
        if(trap!=null) {
          trap.ChangeTractionWhenStepOn(m);
        }
       // logger.Exit(this,"AddMoveable",logger.GetObjectName(m)+" added to "+logger.GetObjectName(this));
    }

    /**
     *
     * @param m Leveszi magáról a Moveable objektumot a mező
     */
    public void RemoveMoveable(Moveable m) {
       // logger.Enter(this,"RemoveMoveable",logger.GetObjectName(m));
        if(trap!=null) {
            trap.ChangeTractionWhenStepOff(m);
        }
        this.moveable=null;

       // logger.Exit(this,"RemoveMoveable",logger.GetObjectName(m)+" removed from "+logger.GetObjectName(this));
    }

    /**
     *
     * @param d Megnézi, hogy milyen a d irányban lévő mező
     * @return Visszatér a d irányban lévő mezővel
     */
    public Field GetNextField(Direction d) {
       // logger.Enter(this,"GetNextField",String.valueOf(d));
        Field nextField=neighbors.get(d);
       // logger.Exit(this,"GetNextField",logger.GetObjectName(nextField));
        return nextField;
    }

    /**
     *
     * @param d Megnézi a d iránnyal ellentétes mező értékét
     * @return Visszatér az ellentétes mezővel
     */
    public Field GetPreviousField(Direction d) {
        //logger.Enter(this,"GetPreviousField","d");
        //logger.Exit(this,"GetPreviousField","previous field from the opposite of d direction");
        return neighbors.get(d.OppositeDirection());
    }

    /**
     *
     * @param f Megkapja paraméterként azt a mezőt amit be kell állítania szomszédnak
     * @param d Megkapja paraméterként az irányt, hogy melyikbe nézze meg a mezőt
     */
    public void SetNeighbor(Field f, Direction d) {
        //logger.Enter(this,"SetNeighbor","w,"+String.valueOf(d));
        this.neighbors.put(d,f);
        //logger.Exit(this,"SetNeighbor",String.valueOf(logger.GetObjectName(f)));
    }

    /**
     *
     * @return Visszaadja, hogy a rajta lévő mozgatható objektum fel tudja-e tolni a munkást a falra
     */
    public Boolean GetMoveablePushedToWall() { //a rajta lévő mozgatható dolog fel tudja-e tolni a munkást a falra,vagy sem
       // logger.Enter(this,"GetMoveablePushedToWall","");
        Boolean canPushedTowall= moveable.CanPushToWall();
        //logger.Exit(this,"GetMoveablePushedToWall",String.valueOf(canPushedTowall));
        return canPushedTowall;

    }

    /**
     *
     * @return Visszatér a mezőn lévő mozgatható objektummal
     */
    public Moveable GetMoveable(){ //nem kell logger függvény neki

        return moveable;
    }

    /**
     *
     * @param t Hozzáadja a paraméterként megkapott csapdát a mezőhöz
     */
    public void AddTrap(Trap t){
        this.trap=t;
        t.SetField(this);

    }

    /**
     *
     * @return Visszatér chekkel
     */
    public Boolean CheckStepOn(){
        //logger.Enter(this, "CheckStepOn", "");
        Boolean check= true;
        //logger.Exit(this,"CheckStepOn",String.valueOf(check));
        return check;
    }

    /**
     *
     * @return Visszatér a mezőn lévő csapdával
     */
    public Trap GetTrap(){
        return trap;
    }


}