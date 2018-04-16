package therfc;

/**
 * 
 */
public class Box extends Moveable {

    //attribútumok
    private Worker pushWorker;
    private int traction;
    private Logger logger = new Logger();



   //konstruktor
    public Box() {

    }

    /**
     *
     * @param w Munkás, ami tolja a dobozt
     * @param d Melyik irányba tolódik a doboz
     */
    //függvények
    public void Push(Worker w, Direction d) { //ha tolják,ez a függvény hívódik meg
        //logger.Enter(this,"Push","w,d");
        SetWorker(w);
        Field nextField=this.GetField().GetNextField(d);
        nextField.StepOn(this,d);
        this.GetWarehouse().CheckStuckedBoxes();
        //logger.Exit(this,"Push","box pushed to next field");

    }

    /**
     *
     * @return
     */
    public Worker GetWorker() {
        //logger.Enter(this,"GetWorker","");
       // logger.Exit(this,"GetWorker","w");
        return pushWorker;
    }

    /**
     *
     * @return
     */
    public Boolean IsStuck() { // ez a függvény nézi meg,hogy beszorult-e a doboz
        //logger.Enter(this,"IsStuck","");
        Boolean stuck;
        Boolean up,down,right,left;
        up= CheckStuckInDirection(Direction.Up);
        down= CheckStuckInDirection(Direction.Down);
        left= CheckStuckInDirection(Direction.Left);
        right= CheckStuckInDirection(Direction.Right);

        //ide jönnek,hogy mikor ragad be a doboz
        if(up&&right){ stuck=true; }
        else if(right&&down){ stuck=true; }
        else if(down&&left){ stuck=true; }
        else if(left&&up){ stuck=true; }
        else{stuck=false;}
        //logger.Exit(this,"IsStuck",String.valueOf(stuck));
        return stuck;

    }


    /**
     *
     * @param w
     */
    private void SetWorker(Worker w) { //beállítja azt a munkást,amelyik tolja
        //logger.Enter(this,"SetWorker","w");
        this.pushWorker=w;
        //logger.Exit(this,"SetWorker","pushWorker setted to 'w' ");
    }

    /**
     *
     * @return
     */
    public Boolean CanPushToWall() { //azt adja vissza, hogy fel tudja-e tolni a munkást (igaz)
       // logger.Enter(this,"CanPushToWall","");
        Boolean canPush=true;
        //logger.Exit(this,"CanPushToWall",String.valueOf(canPush));
       return canPush;

    }

    /**
     *
     */
    public void Die() {
        //logger.Enter(this,"Die","");
        this.GetField().RemoveMoveable(this);
        this.GetWarehouse().RemoveBox(this);
       // logger.Exit(this,"Die","this moveable died");

    }

    /**
     *
     * @param d
     * @return
     */
    public int GetAllTraction(Direction d){
        //logger.Enter(this,"GetAllTraction","d");
        Field nextField = this.GetField().GetNextField(d);
        int myTraction=traction;
        Moveable nextMoveable = nextField.GetMoveable();
        if(nextMoveable!=null){
            int nextTraction = nextMoveable.GetAllTraction(d);
            myTraction+=nextTraction;
        }
        //logger.Exit(this,"GetAllTraction",String.valueOf(myTraction));
        return myTraction;
    }

    /**
     *
     * @param t
     */
    @Override
    public void ChangeTraction(int t) { //hozzáadja az aktuális tapadásához a paraméterként kapott tapadást
        int oldTraction=traction;
        //logger.Enter(this,"ChangeTraction",String.valueOf(t));
        this.traction+=t;
        //logger.Exit(this,"ChangeTraction","traction changed from "+String.valueOf(oldTraction)+" to "+String.valueOf(this.traction));

    }

    /**
     *
     * @param i
     */
     public void SetTraction(int i){
        this.traction=i;
     }

    /**
     *
     * @return
     */
    public int GetTraction(){
        return traction;
    }


}