package therfc;

public abstract class Trap {
    //attribútumok
   private Field field;
    //konstruktor

    //függvények
    public abstract void  ChangeTractionWhenStepOn(Moveable m);
    public abstract void  ChangeTractionWhenStepOff(Moveable m);

    public void SetField(Field f){
        this.field=f;
    }

    public Field GetField(){
        return field;
    }
}
