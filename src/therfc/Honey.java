package therfc;

public class Honey extends Trap {
    private Logger logger = new Logger();
    @Override
    public  void ChangeTractionWhenStepOn(Moveable m) {
        logger.Enter(this,"ChangeTraction","");
        m.ChangeTraction(1);
        logger.Exit(this,"ChangeTraction","Traction changed");
    }
    @Override
    public  void  ChangeTractionWhenStepOff(Moveable m) {
        logger.Enter(this,"ChangeTraction","");
        m.ChangeTraction(-1);
        logger.Exit(this,"ChangeTraction","traction changed");
    }
}
