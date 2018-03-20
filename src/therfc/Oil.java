package therfc;

public class Oil extends Trap {
    private Logger logger = new Logger();

    @Override
    public  void  ChangeTractionWhenStepOn(Moveable m) {
        logger.Enter(this,"ChangeTractionWhenStepOn",logger.GetObjectName(m));
        m.ChangeTraction(-1);
        logger.Exit(this,"ChangeTractionWhenStepOn","traction changed");

    }
    @Override
    public  void  ChangeTractionWhenStepOff(Moveable m) {
        logger.Enter(this,"ChangeTractionWhenStepOff",logger.GetObjectName(m));
        m.ChangeTraction(1);
        logger.Exit(this,"ChangeTractionWhenStepOff","traction changed");
    }
}
