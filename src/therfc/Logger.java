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
        objects.put("therfc.Honey", "Honey");
        objects.put("therfc.Oil", "Oil");

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
    public void DrawWarehoouse(Warehouse wh){
        for (int i = 0; i <wh.GetFields().size() ; i++) {

            if(GetObjectName(wh.GetFieldFromIndex(i))=="Wall"){
               System.out.print("#");
            }
            else  if(GetObjectName(wh.GetFieldFromIndex(i))=="TargetField"){
                if(wh.GetFieldFromIndex(i).GetMoveable()!=null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("B");
                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("W");
                    }
                }
                else if(wh.GetFieldFromIndex(i).GetMoveable()==null){
                    System.out.print("T");
                }

            }
            else  if(GetObjectName(wh.GetFieldFromIndex(i))=="SteppableField"){
                if(wh.GetFieldFromIndex(i).GetMoveable()!=null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("B");
                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("W");
                    }
                }
                else if(wh.GetFieldFromIndex(i).GetMoveable()==null){
                    System.out.print("_");
                }
            }
            else  if(GetObjectName(wh.GetFieldFromIndex(i))=="Hole"){
                if(wh.GetFieldFromIndex(i).GetMoveable()!=null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("B");
                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("W");
                    }
                }
                else if(wh.GetFieldFromIndex(i).GetMoveable()==null){
                    Hole hole =(Hole) wh.GetFieldFromIndex(i);
                    if(hole.GetOpen()) {
                        System.out.print("H");
                    }
                    else if(!hole.GetOpen()) {
                        System.out.print("C");
                    }
                }
            }
            else  if(GetObjectName(wh.GetFieldFromIndex(i))=="Switch"){
                if(wh.GetFieldFromIndex(i).GetMoveable()!=null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("B");
                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("W");
                    }
                }
                else if(wh.GetFieldFromIndex(i).GetMoveable()==null){
                    System.out.print("S");
                }
            }
            if(i%20==19){
                System.out.println();
            }

        }

    }
}
