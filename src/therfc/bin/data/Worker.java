package therfc.bin.data;

import therfc.bin.main.Logger;

/**
 *
 */
public class Worker extends Moveable {


    //attribútumok
    private boolean dead;
    private int point;
    private Boolean pushed; //annak eldöntésére,hogy önszántából lépett-e,vagy tolták(ha ==true, akkor tolták,ha false, akkor lépett)
    private int power;
    private Logger logger = new Logger();

    //konstruktor
    public Worker() {
        this.dead=false;
    }

    public Worker(int p) {
        this.power = p;
        this.dead=false;
    }

    //függvények

    /**
     *
     * @return Visszaadja a játékos pontszámát
     */
    public int GetPoints() {
       // logger.Enter(this, "GetPoints", "");
        int points = point;
       // logger.Exit(this, "GetPoints", String.valueOf(points));
        return points;

    }

    /**
     *
     * @param d A paraméterben átadott irányba mozgatja a játékost
     */
    public void Move(Direction d) { //a játékos önszántából lép
       // logger.Enter(this, "Refresh", String.valueOf(d));

        SetPushed(false);
        Field nextField = this.GetField().GetNextField(d);
        {
            if (nextField.moveable != null) {
                int traction = nextField.GetMoveable().GetAllTraction(d);

                if (traction <= power) {
                    nextField.StepOn(this, d);
                }
            } else {
                nextField.StepOn(this, d);
            }
            this.GetWarehouse().CheckStuckedWorkers();
        }
        //logger.Exit(this, "Refresh", "worker moved to next field to d direction");
    }

    /**
     *
     * @param w Átadja paraméterként, hogy melyik munkás tol
     * @param d Átadja paraméterként, hogy melyik irányba lesz tolva
     */
    public void Push(Worker w, Direction d) { //a játékost tolják d irányba
        //logger.Enter(this, "Push", "w,d");
        SetPushed(true);
        Field nextField = this.GetField().GetNextField(d);
        nextField.StepOn(this, d);
        this.GetWarehouse().CheckStuckedWorkers();
       // logger.Exit(this, "Push", "w pushed to next field");

    }

    /**
     *
     * @return Visszaadja, hogy a játékost tolták-e
     */
    public Boolean GetPushed() {
       // logger.Enter(this, "GetPushed", "p");
        Boolean push = pushed;
       // logger.Exit(this, "GetPushed", String.valueOf(push));
        return push;
    }

    /**
     *
     * @param p Beállítja a paraméterben átadott értékre a játékos tolását
     */
    private void SetPushed(Boolean p) {
        //logger.Enter(this, "SetPushed", String.valueOf(p));
        this.pushed = p;
        //logger.Exit(this, "SetPushed", "Worker pushed attribute set to: " + String.valueOf(p));

    }

    /**
     *
     */
    public void AddPoint() {
       // logger.Enter(this, "AddPoint", "");
        point++;
        this.GetWarehouse().CheckTargetFields(); //ha kap egy pontot a játékos,akkor leelenőrizzük az összes TargetField-et
      //  logger.Exit(this, "AddPoint", "1 point added");

    }

    /**
     *
     * @return Visszatér, hogy a játékos beszorult-e
     */
    public Boolean IsStuck() { // ez a függvény nézi meg,hogy beszorult-e a doboz
       // logger.Enter(this,"IsStuck","");
        Boolean stuck;
        Boolean up,down,right,left;
        up= CheckStuckInDirection(Direction.Up);
        down= CheckStuckInDirection(Direction.Down);
        left= CheckStuckInDirection(Direction.Left);
        right= CheckStuckInDirection(Direction.Right);

        //ide jönnek,hogy mikor ragad be a játékos

        if(left&&up&&right&&down){stuck=true;}
        else{stuck=false;}

        //logger.Exit(this,"IsStuck",String.valueOf(stuck));
        return stuck;

    }

    /**
     *
     * @return Visszaadja, hogy fel tudje-e tolni a munkást. Játékosnál ez hamis
     */
    public Boolean CanPushToWall() { //ez adja vissza, hogy fel tud-e munkást tolni a falra (false)
        //logger.Enter(this, "CanPushToWall", "");
        Boolean canPush = false;
        //logger.Exit(this, "CanPushToWall", String.valueOf(canPush));
        return canPush;
    }

    /**
     *
     */
    public void Die() {//ez hívódik meg,hogyha meghal a munkás
      //  logger.Enter(this, "Die", "");
        this.GetField().RemoveMoveable(this);
        this.GetWarehouse().RemoveWorker(this);
        this.dead=true;
       // logger.Exit(this, "Die", "this moveable died");

    }

    /**
     *
     * @param p Beállítja a játékos erejét a paraméterben megkapott értékre
     */
    public void SetPower(int p) {
        //logger.Enter(this, "SetPower", String.valueOf(p));
        this.power = p;
       // logger.Exit(this, "SetPower", String.valueOf(p));

    }

    /**
     *
     * @return Visszaadja a játékos erejét
     */
    public int GetPower() {
      //  logger.Enter(this, "GetPower", "");
        int getPower = power;
       // logger.Exit(this, "GetPower", String.valueOf(getPower));
        return power;
    }

    /**
     *
     * @param d Átadja paraméterben az irányt, ahonnan az erőket számoljuk össze
     * @return Visszaadja az összes tapadás értékét
     */
    public int GetAllTraction(Direction d) {
       // logger.Enter(this, "GetAllTraction", "d");
        int traction = 0;
        Field nextField = this.GetField().GetNextField(d);
        Moveable nextMoveable = nextField.GetMoveable();
        if (nextMoveable != null) {
            int nextTraction = nextMoveable.GetAllTraction(d);
            traction += nextTraction;
        }
        //logger.Exit(this, "GetAllTraction", String.valueOf(traction));
        return traction;
    }

    /**
     *
     */
    public void AddHoney(){
       // logger.Enter(this, "AddHoney","");
        Honey honey = new Honey();
        this.GetField().AddTrap(honey);
       // logger.Exit(this, "AddHoney", logger.GetObjectName(honey));

    }

    /**
     *
     */
    public void AddOil(){
       // logger.Enter(this, "AddOil","");
        Oil oil = new Oil();
        this.GetField().AddTrap(oil);
       // logger.Exit(this, "AddOil", logger.GetObjectName(oil));

    }

    /**
     * 
     * @param t Hozzáadja az aktuális tapadáshoz a kapott tapadást
     */
    @Override
    public void ChangeTraction(int t) { //ez a függvény igazából nem csinál semmit

    }

    public boolean GetDeadState() {
        return dead;
    }
}