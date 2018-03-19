package therfc;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    //attribútumok

    private static final Map<String, String> objects;
    private static int tabNumber = 0;

    static {
        objects = new HashMap<String, String>();
        objects.put("therfc.Worker", "Worker");
        objects.put("therfc.Box", "Box");
        objects.put("therfc.SteppableField", "SteppableField");
        objects.put("therfc.TargetField", "TargetField");
        objects.put("therfc.Switch", "Switch");
        objects.put("therfc.Hole", "Hole");
        objects.put("therfc.Wall", "Wall");
        objects.put("therfc.Warehouse", "Warehouse");
        objects.put("therfc.Game", "Game");

    }

    //konstruktor
    public Logger() {

    }

    //függvények
    public String GetObjectName(Object o) { //visszaadja az obejtum nevét
        return objects.get(o.getClass().getName());
    }

    public void Enter(Object o, String fv_name, String parameters) {
        WriteTab();
        System.out.println("-> [" + GetObjectName(o) + ":] " + fv_name + "(" + parameters + ")");
        tabNumber++;
    }

    public void Exit(Object o, String fv_name, String returnValue) {
        tabNumber--;
        WriteTab();
        System.out.println("<- [" + GetObjectName(o) + ":] " + fv_name + " | return (" + returnValue + ")");

    }

    public void WriteTab() { //tabulátorok kiiírása
        for (int i = 0; i <= tabNumber; i++) {
            System.out.print("\t\t");
        }
    }
}
