package therfc;

public class Honey extends Trap {
    private Logger logger = new Logger();
    @Override
    public  void ChangeTractionWhenStepOn(Moveable m) {//ez történik a paraméterként kapott Moveable tapadásával ha rálép a csapdára
        logger.Enter(this,"ChangeTractionWhenStepOn",logger.GetObjectName(m));
        m.ChangeTraction(1);
        logger.Exit(this,"ChangeTractionWhenStepOn","Traction changed");
    }
    @Override
    public  void  ChangeTractionWhenStepOff(Moveable m) {//ez történik a paraméterként kapott Moveable tapadásával ha lelép a csapdáról
        logger.Enter(this,"ChangeTractionWhenStepOff",logger.GetObjectName(m));
        m.ChangeTraction(-1);
        logger.Exit(this,"ChangeTractionWhenStepOff","traction changed");
    }
}
