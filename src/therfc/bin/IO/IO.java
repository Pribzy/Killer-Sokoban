package therfc.bin.IO;

import therfc.bin.data.*;

import java.io.*;

public class IO {

    public IO() {
    }

    /**
     *
     * @param wh Beállítja a szomszédokat a paraméterben kapott Raktárban
     */
    public void SetNeighBors(Warehouse wh){ //beállítja a szomszédokat
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
            if(i==20){
                wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 1), Direction.Right);
                wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i + 20), Direction.Down);
                wh.GetFieldFromIndex(i).SetNeighbor(wh.GetFieldFromIndex(i - 20), Direction.Up);
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

    /**
     *
     * @param level Megkapja paraméterként az előre elkészített Raktárt
     * @return Visszatér a Raktárral
     * @throws Exception
     */
    public Warehouse GetWarehouseFromFile(File level)throws Exception{ //beállítja a raktárat a fájlból
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
                else  if(LoadLevel(level)[k].charAt(l)=='W'){
                    SteppableField steppableField = new SteppableField();
                    Worker w = new Worker(1);
                    steppableField.AddMoveable(w);
                    newWarehouse.AddWorker(w);
                    newWarehouse.AddField(steppableField);
                }
                else  if(LoadLevel(level)[k].charAt(l)=='B'){
                    SteppableField steppableField = new SteppableField();
                    Box b= new Box(1);
                    steppableField.AddMoveable(b);
                    newWarehouse.AddBox(b);
                    newWarehouse.AddField(steppableField);
                }

            }
        }
        SetSwitchToHole(level,newWarehouse); //a váltók hozzárendelése a lyukakhoz
        SetNeighBors(newWarehouse);
        return newWarehouse;
    }

    /**
     *
     * @param level Megkapja paraméterként az előre elkészített Raktárt
     * @param wh Megkapja paraméterként a Raktárt, ahol a lyukakat hozzárendeli a váltókhoz
     * @throws Exception
     */
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

    /**
     *
     * @param level Megkapja paraméterként az előre elkészített Raktárt
     * @return Visszatér a pályával
     * @throws Exception
     */
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

    /**
     *
     * @param f Megkapja paraméterként az előre elkészített Raktárt txt fájlban
     * @return Visszatér az összekapcsolások számával
     * @throws Exception
     */
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

    /**
     *
     * @param f Megkapja paraméterként az előre elkészített Raktárt txt fájlban
     * @return Visszatér a sorok számával
     * @throws IOException
     */
    public int LineCounter(File f) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(f));
        int count=0;
        while(true){
            String line=br.readLine();
            if(line.equals("$"))
                break;
            count++;
        }
        br.close();
        return count;
    }

    /**
     *
     * @param str Paraméterként kapott stringet beleírja fájlba
     */
    public void WriteToFileByLine(String str){
        try(FileWriter fw = new FileWriter("test.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(str);
            //more code

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    /**
     *
     * @param str Paraméterként kapott stringet beleírja fájlba
     */
    public void WriteToFileByCharacter(String str){
        try(FileWriter fw = new FileWriter("test.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.print(str);
            //more code

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public void DeleteTestFile() throws FileNotFoundException {
        File out = new File("test.txt");
        PrintWriter writer = new PrintWriter(out);
        writer.print("");
        writer.close();
    }

    /**
     *
     * @param test Betölti a paraméterként kapott fájlt
     * @return
     * @throws IOException
     */
    public String LoadTest(File test) throws IOException {
        try(FileWriter fw = new FileWriter("test.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println("$");
            //more code

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
            BufferedReader br = new BufferedReader(new FileReader(test));
            String[] level = new String[LineCounter(test)];

            int i = 0;

            while (i < LineCounter(test)) {
                level[i] = br.readLine();
                if (level[i] == null) {
                    break;
                }
                i++;

            }
            String str = String.join("", level);
            return str;
        }

}
