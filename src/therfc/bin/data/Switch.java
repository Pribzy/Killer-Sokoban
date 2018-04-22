package therfc.bin.data;

import therfc.bin.main.Logger;

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

    /**
     * @param w Megkapja paraméterként a munkást, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a munkást fogja tenni
     */
    public void StepOn(Worker w, Direction d) {// Ez történik Ha egy munkás Switchre lép
        // logger.Enter(this, "StepOn", "w,d");
        Field previousField = neighbors.get(d.OppositeDirection());
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
        // logger.Exit(this, "StepOn", "w stepped on switch");
    }

    /**
     * @param b Megkapja paraméterként a dobozt, amit majd a következő mezőre fog tenni
     * @param d Megkapja paraméterként a d irányt, amerre a dobozt foja tenni
     */
    public void StepOn(Box b, Direction d) {// Ez történik Ha egy doboz Sitch-re lép
        //logger.Enter(this, "StepOn", "b,d");
        Field previousField = neighbors.get(d.OppositeDirection());
        if (this.GetMoveable() != null) {
            Worker pushWorker = b.GetWorker();
            this.GetMoveable().Push(pushWorker, d);
            if (this.GetMoveable() == null) {
                previousField.RemoveMoveable(b);
                this.AddMoveable(b);
                hole.SetOpen(true);
                Game game = Game.GetInstance();
                System.out.println("Switch On");
                game.GetIO().WriteToFileByLine("Switch On");
            }
        } else {
            previousField.RemoveMoveable(b);
            this.AddMoveable(b);
            hole.SetOpen(true);
            Game game = Game.GetInstance();
            System.out.println("Switch On");
            game.GetIO().WriteToFileByLine("Switch On");
        }
        //logger.Exit(this, "StepOn", "b stepped on switch");
    }

    /**
     * @param h Beállítja a hozzátartozó lyukat
     */
    public void SetHole(Hole h) { //Beállítja a lyukát
        this.hole = h;

    }

    /**
     * @param m Leveszi magáról a Moveable objektumot a mező
     */
    @Override
    public void RemoveMoveable(Moveable m) {
        //logger.Enter(this,"RemoveMoveable",logger.GetObjectName(m));
        this.moveable = null;
        hole.SetOpen(false);
        Game game = Game.GetInstance();
        if (logger.GetObjectName(m) == "Box") {
            System.out.println("Switch Off");
            game.GetIO().WriteToFileByLine("Switch Off");
        }
        // logger.Exit(this,"RemoveMoveable",logger.GetObjectName(m)+" removed from "+logger.GetObjectName(this));

    }


}