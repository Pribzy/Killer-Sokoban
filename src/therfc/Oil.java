package therfc;

public class Oil extends Trap {
    private Logger logger = new Logger();

    @Override
    public  void  ChangeTractionWhenStepOn(Moveable m) {
        logger.Enter(this,"ChangeTraction","");
        m.ChangeTraction(-1);
        logger.Exit(this,"ChangeTraction","traction changed");

    }
    @Override
    public  void  ChangeTractionWhenStepOff(Moveable m) {
        logger.Enter(this,"ChangeTraction","");
        m.ChangeTraction(1);
        logger.Exit(this,"ChangeTraction","traction changed");
    }
}
