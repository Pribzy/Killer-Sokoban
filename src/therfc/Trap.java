package therfc;

public abstract class Trap {
    //attribútumok
   private Field field;
    //konstruktor

    //függvények
    public abstract void ChangeTraction();

    public void AddField(Field f){
        this.field=f;
    }
    public Field GetField(){
        return field;
    }
}
