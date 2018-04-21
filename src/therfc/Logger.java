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
        objects.put("null", " ");
    }

    //konstruktor
    public Logger() {

    }

    //függvények

    /**
     *
     * @param o Paraméterben megkap egy objektumot, aminek a nevére vagyunk kíváncsiak
     * @return Visszaadja a paraméterben kapott objektum nevét
     */
    public String GetObjectName(Object o) { //visszaadja az obejtum nevét
        if(o==null){
            return " ";
        } else {
            return objects.get(o.getClass().getName());
        }
    }

    /**
     *
     * @param o
     * @param fv_name
     * @param parameters
     */
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
    public void DrawWarehoouse(Warehouse wh,Game game){
        for (int i = 0; i <wh.GetFields().size() ; i++) {

            if(GetObjectName(wh.GetFieldFromIndex(i))=="Wall"){
               System.out.print("#");
               game.GetIO().WriteToFileByCharacter("#");
            }
            else  if(GetObjectName(wh.GetFieldFromIndex(i))=="TargetField"){
                if(wh.GetFieldFromIndex(i).GetMoveable()!=null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("B");
                        game.GetIO().WriteToFileByCharacter("B");
                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("W");
                        game.GetIO().WriteToFileByCharacter("W");
                    }
                }
                else if(wh.GetFieldFromIndex(i).GetMoveable()==null) {

                        System.out.print("T");
                    game.GetIO().WriteToFileByCharacter("T");

                }

            }
            else  if(GetObjectName(wh.GetFieldFromIndex(i))=="SteppableField"){
                if(wh.GetFieldFromIndex(i).GetMoveable()!=null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("B");
                        game.GetIO().WriteToFileByCharacter("B");
                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("W");
                        game.GetIO().WriteToFileByCharacter("W");
                    }
                }
                else if(wh.GetFieldFromIndex(i).GetMoveable()==null){

                        System.out.print("_");
                    game.GetIO().WriteToFileByCharacter("_");



                }
            }
            else  if(GetObjectName(wh.GetFieldFromIndex(i))=="Hole"){
                if(wh.GetFieldFromIndex(i).GetMoveable()!=null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("B");
                        game.GetIO().WriteToFileByCharacter("B");
                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("W");
                        game.GetIO().WriteToFileByCharacter("W");
                    }
                }
                else if(wh.GetFieldFromIndex(i).GetMoveable()==null){

                        Hole hole =(Hole) wh.GetFieldFromIndex(i);
                        if(hole.GetOpen()) {
                            System.out.print("H");
                            game.GetIO().WriteToFileByCharacter("H");
                        }
                        else if(!hole.GetOpen()) {
                            System.out.print("C");
                            game.GetIO().WriteToFileByCharacter("C");
                        }


                }
            }
            else  if(GetObjectName(wh.GetFieldFromIndex(i))=="Switch"){
                if(wh.GetFieldFromIndex(i).GetMoveable()!=null) {
                    if (wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("B");
                        game.GetIO().WriteToFileByCharacter("B");
                    } else if (!wh.GetFieldFromIndex(i).GetMoveable().CanPushToWall()) {
                        System.out.print("W");
                        game.GetIO().WriteToFileByCharacter("W");
                    }
                }
                else if(wh.GetFieldFromIndex(i).GetMoveable()==null){

                        System.out.print("S");
                    game.GetIO().WriteToFileByCharacter("S");


                }
            }
            if(i%20==19){
                System.out.println();
                game.GetIO().WriteToFileByLine("");
            }

        }
        System.out.println();
        game.GetIO().WriteToFileByLine("\n");

    }
}
