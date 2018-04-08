package therfc;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 
 */
public class Game {


    //attribútumok
    private Warehouse level;
    private static Game game = new Game( );
    private Logger logger = new Logger();

    //konstruktor
    private Game() { }

    //függvények
    /* statikus példány metódus*/
    public static Game GetInstance( ) {
        return game;
    }


//szkeleton függvények
    public  void StartGame( ) throws Exception {

        level = SetWarehouseFromFile(new File("trial.txt"));
        SetNeighBors(level);
        logger.DrawWarehoouse(level);
    }

    public void AddWorker(int x,int y,int power){
        Worker w = new Worker();
        w.SetPower(power);
        if(level.GetFieldFromIndex(x+(y*20)).GetMoveable()!=null){
            System.out.println("Failed to add worker to this field, because it's not empty!");
        } else if (!level.GetFieldFromIndex(x+(y*20)).CheckStepOn()){
            System.out.println("Failed to add worker to this field, because this field is a wall!");
        }
        else {
            level.AddWorker(w);
            level.GetFieldFromIndex(x + (y * 20)).AddMoveable(w);
            System.out.println("Succes added to X: "+x+", Y: "+y);
        }
    }
    public void AddBox(int x,int y,int traction){
        Box b = new Box();
        b.SetTraction(traction);
        if(level.GetFieldFromIndex(x+(y*20)).GetMoveable()!=null){
            System.out.println("Failed to add box to this field, because it's not empty!");
        } else if (!level.GetFieldFromIndex(x+(y*20)).CheckStepOn()){
            System.out.println("Failed to add box to this field, because this field is a wall!");
        }
        else {
            level.AddBox(b);
            level.GetFieldFromIndex(x + (y * 20)).AddMoveable(b);
            System.out.println("Succes added to X: "+x+", Y: "+y);
        }
    }
    public void DrawMap(){
        logger.DrawWarehoouse(level);
    }
    public void SelectWorker(){


    }
//-------------------------------------
    public void SetNeighBors(Warehouse wh){
        for (int i = 0; i <wh.GetFields().size() ; i++) {
            if(i<20){

               if(i==0){
                   wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 1), Direction.Right);
                   wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 20), Direction.Down);
               }
               if(i!= 0 && i!=19) {
                   wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 20), Direction.Down);
                   wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 1), Direction.Left);
                   wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 1), Direction.Right);
               }
               if(i==19){
                   wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 20), Direction.Down);
                   wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 1), Direction.Left);
               }




            }
            if(i>20 && i<380) {
                if(i%20!=0 && i%20!=19) {
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 1), Direction.Right);
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 20), Direction.Down);
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 1), Direction.Left);
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 20), Direction.Up);
                }
                if(i%20==0) {
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 1), Direction.Right);
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 20), Direction.Down);
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 20), Direction.Up);
                }
                if(i%20==19) {
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 1), Direction.Left);
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 20), Direction.Down);
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 20), Direction.Up);
                }

            }
            if(i>=380){
                if(i==380){
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 1), Direction.Right);
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 20), Direction.Up);
                }
                if(i!= 380 && i!=399) {
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 20), Direction.Up);
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 1), Direction.Left);
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 1), Direction.Right);
                }
                if(i==399){
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 20), Direction.Up);
                    wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 1), Direction.Left);
                }

            }
        }

    }

    public Warehouse SetWarehouseFromFile(File level)throws Exception{
        Warehouse newWarehouse= new Warehouse();
        Hole hole;
        for (int k = 0; k < LoadLevel(level).length; k++) {
            for (int l = 0; l <20 ; l++) {
                if(LoadLevel(level)[k].charAt(l)=='#'){
                    newWarehouse.AddField(new Wall());
                }
                else  if(LoadLevel(level)[k].charAt(l)=='_'){
                    newWarehouse.AddField(new SteppableField());
                }
                else  if(LoadLevel(level)[k].charAt(l)=='T'){
                    newWarehouse.AddField(new TargetField());
                }
                else  if(LoadLevel(level)[k].charAt(l)=='S'){
                    Switch s = new Switch();
                    newWarehouse.AddField(s);


                }
                else  if(LoadLevel(level)[k].charAt(l)=='H'){
                    hole = new Hole();
                    hole.SetOpen(true);
                    newWarehouse.AddField(hole);
                }
                else  if(LoadLevel(level)[k].charAt(l)=='C'){
                    hole = new Hole();
                    hole.SetOpen(false);
                    newWarehouse.AddField(hole);
                }

            }
        }
        SetSwitchToHole(level,newWarehouse); //a váltók hozzárendelése a lyukakhoz

        return newWarehouse;
    }
    public void SetSwitchToHole(File level,Warehouse wh)throws Exception{ //Hozzárendeli a váltókhoz a lyukakat
        String s[]=LoadSwitchToHole(level);
        for (int i = 0; i <SwitchAndHoleCounter(level) ; i++) {


            String row[] = s[i].split("->");
            String sw[] = row[0].split(":"); //switch koordináták
            String hole[] = row[1].split(":"); //lyuk koordináták
            Integer mySwitch_x = Integer.parseInt(sw[0]);
            Integer mySwitch_y = Integer.parseInt(sw[1]);
            Integer myHole_x = Integer.parseInt(hole[0]);
            Integer myHole_y = Integer.parseInt(hole[1]);
            Switch mySwitch = (Switch) wh.GetFieldFromIndex(mySwitch_x + (mySwitch_y * 20));
            Hole myHole = (Hole) wh.GetFieldFromIndex(myHole_x + (myHole_y * 20));
            mySwitch.SetHole(myHole);
        }




    }


    public String[] LoadLevel(File level) throws Exception{ //a txt-ből beolvassa a pálya részt
        BufferedReader br=new BufferedReader(new FileReader(level));
        String[] switchToHole= new String[SwitchAndHoleCounter(level)];
        String[] newLevel= new String[20];
        int i=0;
        int j=0;
        while(i< SwitchAndHoleCounter(level)){
            switchToHole[i]=br.readLine();
            if(switchToHole[i]==null){
                break;
            }

            i++;

        }
        String separator =br.readLine();
        i++;

        int to =i+20;
        while(i< to){
            newLevel[j]=br.readLine();
            if(newLevel[j]==null){
                break;
            }
            j++;
            i++;

        }
        br.close();
        return newLevel;
    }
    public String[] LoadSwitchToHole(File level) throws Exception{ //a txt-ből beolvassa azt a részt, ahol össze van rendelve a Switch és Hole
        BufferedReader br=new BufferedReader(new FileReader(level));
        String[] switchToHole= new String[SwitchAndHoleCounter(level)];
        String[] newLevel= new String[20];
        int i=0;
        int j=0;
        while(i< SwitchAndHoleCounter(level)){
            switchToHole[i]=br.readLine();
            if(switchToHole[i]==null){
                break;
            }

            i++;

        }
        String separator =br.readLine();
        i++;

        int to =i+20;
        while(i< to){
            newLevel[j]=br.readLine();
            if(newLevel[j]==null){
                break;
            }
            j++;
            i++;

        }
        br.close();
        return switchToHole;
    }

    public int SwitchAndHoleCounter(File f) throws Exception{ //megszámolja a paraméterül kapott fájlban azokat a sorokat,
                                                                // ahol a switchek ás lyukak összekapcsolása van
        BufferedReader br=new BufferedReader(new FileReader(f));
        int count=0;
        while(true){
            String line=br.readLine();
            if(line.equals("%"))
                break;
            count++;
        }
        br.close();
        return count;
    }
//-----------------------------------------------------------------------------------------------------------------------------------
    public  void EndGame( ) { //ha vége a játéknak,ez a függvény hívódik meg
        //logger.Enter(this,"EndGame","");
        Worker yourWinner=level.GetMaxPointPlayer(); //visszaadja a legnagyobb pontú játékost ami eddig történt
        System.out.println("Your Winner! Your points: "+yourWinner.GetPoints());
        //a szekvenciadiagramokban nincs benne a GetPoints() függvény, mivel azt csak a kiiratáshoz használjuk
        //logger.Exit(this,"EndGame","max point player");
    }



    public void SetWarehouse(Warehouse wh){
        this.level=wh;
    }

    public Warehouse GetWarehouse() {
        return level;
    }
}