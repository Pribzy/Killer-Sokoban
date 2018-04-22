package therfc.bin.data;

import therfc.bin.main.Logger;

public class Honey extends Trap {
    private Logger logger = new Logger();

    /**
     *
     * @param m A paraméterként megkapott Moveable objektum tapadását megnöveli amikor rálép a mezőre
     */
    @Override
    public  void ChangeTractionWhenStepOn(Moveable m) {//ez történik a paraméterként kapott Moveable tapadásával ha rálép a csapdára
       // logger.Enter(this,"ChangeTractionWhenStepOn",logger.GetObjectName(m));
        m.ChangeTraction(1);
       // logger.Exit(this,"ChangeTractionWhenStepOn","Traction changed");
    }

    /**
     *
     * @param m A paraméterként megkapott Moveable objektum tapadását csökkenti amikor lelép a mezőre
     */
    @Override
    public  void  ChangeTractionWhenStepOff(Moveable m) {//ez történik a paraméterként kapott Moveable tapadásával ha lelép a csapdáról
        //logger.Enter(this,"ChangeTractionWhenStepOff",logger.GetObjectName(m));
        m.ChangeTraction(-1);
        //logger.Exit(this,"ChangeTractionWhenStepOff","traction changed");
    }
}
