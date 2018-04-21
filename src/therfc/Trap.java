package therfc;

public abstract class Trap {
    //attribútumok
   private Field field;

    //konstruktor

    //függvények

    /**
     *
     * @param m A paraméterként megkapott Moveable objektum tapadását megnöveli amikor rálép a mezőre
     */
    public abstract void  ChangeTractionWhenStepOn(Moveable m); //ez történik a paraméterként kapott Moveable tapadásával ha rálép a csapdára

    /**
     *
     * @param m A paraméterként megkapott Moveable objektum tapadását megnöveli amikor lelép a mezőre
     */
    public abstract void  ChangeTractionWhenStepOff(Moveable m); //ez történik a paraméterként kapott Moveable tapadásával ha lelép a csapdáról

    public void SetField(Field f){
        this.field=f;
    }

    public Field GetField(){
        return field;
    }


}
