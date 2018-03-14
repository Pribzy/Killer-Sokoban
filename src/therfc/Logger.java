package therfc;

import java.util.HashMap;

public class Logger {
    //attribútumok
    private HashMap<Object,String> objects = new HashMap<>();

    //konstruktor
    public Logger(){
        objects.put(Wall.class,"Wall");
        objects.put(Worker.class,"Worker");
        objects.put(Box.class,"Box");
        objects.put(SteppableField.class,"SteppableField");
        objects.put(Switch.class,"Switch");
        objects.put(TargetField.class,"TargetField");
        objects.put(Hole.class,"Hole");
        objects.put(Warehouse.class,"Warehouse");
        objects.put(Game.class,"Game");
    }

    //függvények
    public String GetObjectName(Object o){
        return objects.get(o);
    }

    public void Enter(Object o, String fv_name, String parameters){
        System.out.println(GetObjectName(o));
    }
    public void Exit(Object o,String fv_name, String returnValue){

    }
}
