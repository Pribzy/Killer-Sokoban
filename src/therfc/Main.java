package therfc;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
      // Menu(); //Szkeleton menü
        //TestLevel();
       tests();



    }
//Prototípus---------------------------------

    private static void tests() throws Exception {
        System.out.println("Test Cases:");
        System.out.println("=======================");
        System.out.println("1. Palya betoltese");
        System.out.println("2. Jatekos hozzadasa");
        System.out.println("=======================\n");
        System.out.print("Selected Test Case: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = null;
        try {
            command = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        switch (command){
            case "1": prototypeCommands(1); tests();
            case "2": prototypeCommands(2); tests();

            default:
                System.out.println("");

        }

    }



    private static void prototypeCommands(int testNumber) throws Exception {
        Game game=Game.GetInstance();

        System.out.print("Command: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = null;
        try {
            command = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        switch (command){
            case "start": start(game); prototypeCommands(testNumber);
            case "addworker": addworker(game); prototypeCommands(testNumber);
            case "drawmap": drawmap(game); prototypeCommands(testNumber);
            case "addbox": addbox(game);prototypeCommands(testNumber);
            case "selectworker": selectworker(game);prototypeCommands(testNumber);
            case "trapslocation": trapslocation(game);prototypeCommands(testNumber);
            case "workerslocation": workerslocation(game);prototypeCommands(testNumber);
            case "boxeslocation": boxeslocation(game);prototypeCommands(testNumber);
            case "getworkerneighbors": getworkerneighbors(game);prototypeCommands(testNumber);
            case "check": check(game,testNumber);tests();
            default:
                System.out.println("");prototypeCommands(testNumber);

        }
    }

    private static void check(Game game,int num) throws Exception {

       if(num==1) {
           String str = "####################" +
                   "#__________###_____#" +
                   "#T_____S___HT______#" +
                   "#_________________##" +
                   "#________________###" +
                   "#___C_____T______###" +
                   "##_____T__________##" +
                   "#________#_________#" +
                   "#_H______#_________#" +
                   "#__________________#" +
                   "#_S__________T_____#" +
                   "#_________HHHCHH___#" +
                   "#__________________#" +
                   "#__________________#" +
                   "####_____S_________#" +
                   "#______________H___#" +
                   "###__________C_____#" +
                   "#_____T____________#" +
                   "#___________H______#" +
                   "####################" +
                   "";
           if (str.equals(game.GetIO().LoadTest(new File("test.txt")))) {
               System.out.println("Succes Test!\n");
           } else System.out.println("Failed Test!\n");
       }
        if (num==2) {
            String str_1 = "####################" +
                    "#__________###_____#" +
                    "#T_____S___HT______#" +
                    "#_________________##" +
                    "#________________###" +
                    "#___C_____T______###" +
                    "##_____T__________##" +
                    "#________#_________#" +
                    "#_H______#_________#" +
                    "#__________________#" +
                    "#_S__________T_____#" +
                    "#_________HHHCHH___#" +
                    "#__________________#" +
                    "#__________________#" +
                    "####_____S_________#" +
                    "#______________H___#" +
                    "###__________C_____#" +
                    "#_____T____________#" +
                    "#___________H______#" +
                    "####################" +
                    "" +
                    "Worker added to X: 5, Y: 5" +
                    "Failed to add box to this field, because it's not empty!" +
                    "w1 - X:5, Y:5, Power:1, Stuck:false" +
                    "";
            System.out.println(game.GetIO().LoadTest(new File("test.txt")));
            if (str_1.equals(game.GetIO().LoadTest(new File("test.txt")))) {
                System.out.println("Succes Test!\n");
            } else {
                System.out.println("Failed Test!\n");
            }
        }



    }

    private static void getworkerneighbors(Game game) {
        Logger logger = new Logger();
        for (int i = 0; i <game.GetWarehouse().GetWorkers().size() ; i++) {
            System.out.println("w"+(i+1)+":");
            game.GetIO().WriteToFileByLine("w"+(i+1)+":");
            Field field = game.GetWarehouse().GetWorkerFromIndex(i).GetField().GetNextField(Direction.Up);
            Trap trap =game.GetWarehouse().GetWorkerFromIndex(i).GetField().GetNextField(Direction.Up).GetTrap();
            Moveable  moveable =game.GetWarehouse().GetWorkerFromIndex(i).GetField().GetNextField(Direction.Up).GetMoveable();


            System.out.println("Up: "+logger.GetObjectName(field)+"{"+logger.GetObjectName(moveable)+","+logger.GetObjectName(trap)+"}");
            game.GetIO().WriteToFileByLine("Up: "+logger.GetObjectName(field)+"{"+logger.GetObjectName(moveable)+","+logger.GetObjectName(trap)+"}");

            field = game.GetWarehouse().GetWorkerFromIndex(i).GetField().GetNextField(Direction.Down);
            trap =game.GetWarehouse().GetWorkerFromIndex(i).GetField().GetNextField(Direction.Down).GetTrap();
            moveable =game.GetWarehouse().GetWorkerFromIndex(i).GetField().GetNextField(Direction.Down).GetMoveable();

            System.out.println("Down: "+logger.GetObjectName(field)+"{"+logger.GetObjectName(moveable)+","+logger.GetObjectName(trap)+"}");
            game.GetIO().WriteToFileByLine("Down: "+logger.GetObjectName(field)+"{"+logger.GetObjectName(moveable)+","+logger.GetObjectName(trap)+"}");

            field = game.GetWarehouse().GetWorkerFromIndex(i).GetField().GetNextField(Direction.Left);
            trap =game.GetWarehouse().GetWorkerFromIndex(i).GetField().GetNextField(Direction.Left).GetTrap();
            moveable =game.GetWarehouse().GetWorkerFromIndex(i).GetField().GetNextField(Direction.Left).GetMoveable();

            System.out.println("Left: "+logger.GetObjectName(field)+"{"+logger.GetObjectName(moveable)+","+logger.GetObjectName(trap)+"}");
            game.GetIO().WriteToFileByLine("Left: "+logger.GetObjectName(field)+"{"+logger.GetObjectName(moveable)+","+logger.GetObjectName(trap)+"}");

            field = game.GetWarehouse().GetWorkerFromIndex(i).GetField().GetNextField(Direction.Right);
            trap =game.GetWarehouse().GetWorkerFromIndex(i).GetField().GetNextField(Direction.Right).GetTrap();
            moveable =game.GetWarehouse().GetWorkerFromIndex(i).GetField().GetNextField(Direction.Right).GetMoveable();

            System.out.println("Right: "+logger.GetObjectName(field)+"{"+logger.GetObjectName(moveable)+","+logger.GetObjectName(trap)+"}"+"\n");
            game.GetIO().WriteToFileByLine("Right: "+logger.GetObjectName(field)+"{"+logger.GetObjectName(moveable)+","+logger.GetObjectName(trap)+"}"+"\n");



        }
    }

    private static void trapslocation(Game game) {
        for (int i = 0; i <game.GetWarehouse().GetFields().size() ; i++) {
            Logger logger = new Logger();
            if(game.GetWarehouse().GetFieldFromIndex(i).GetTrap()!=null){
                int y= i/20;
                int x = i-20*y;

                System.out.println(logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i).GetTrap())+" - X:"
                +x+", Y:"+y);
                game.GetIO().WriteToFileByLine(logger.GetObjectName(game.GetWarehouse().GetFieldFromIndex(i).GetTrap())+" - X:"
                        +x+", Y:"+y);
            }
        }
    }
    private static void boxeslocation(Game game) {
        for (int i = 0; i <game.GetWarehouse().GetBoxes().size() ; i++) {

            int y= (game.GetWarehouse().GetFields().indexOf(game.GetWarehouse().GetBoxFromIndex(i).GetField()))/20;
            int x = (game.GetWarehouse().GetFields().indexOf(game.GetWarehouse().GetBoxFromIndex(i).GetField())- 20*y);
            int traction = game.GetWarehouse().GetBoxFromIndex(i).GetTraction();
            System.out.println("b"+(i+1)+" - X:"
                    +x+", Y:"+y+", Traction:"+traction+", Stuck:"+game.GetWarehouse().GetBoxFromIndex(i).IsStuck());
            game.GetIO().WriteToFileByLine("b"+(i+1)+" - X:"
                    +x+", Y:"+y+", Traction:"+traction+", Stuck:"+game.GetWarehouse().GetBoxFromIndex(i).IsStuck());

        }
        System.out.println();
        game.GetIO().WriteToFileByLine("\n");
    }
    //54 -> x=14, y=2
    private static void workerslocation(Game game){
        for (int i = 0; i <game.GetWarehouse().GetWorkers().size() ; i++) {
            int y= (game.GetWarehouse().GetFields().indexOf(game.GetWarehouse().GetWorkerFromIndex(i).GetField()))/20;
            int x = (game.GetWarehouse().GetFields().indexOf(game.GetWarehouse().GetWorkerFromIndex(i).GetField())- 20*y);
            int power = game.GetWarehouse().GetWorkerFromIndex(i).GetPower();
            System.out.println("w"+(i+1)+" - X:"
                    +x+", Y:"+y+", Power:"+power+", Stuck:"+game.GetWarehouse().GetWorkerFromIndex(i).IsStuck());
            game.GetIO().WriteToFileByLine("w"+(i+1)+" - X:"
                    +x+", Y:"+y+", Power:"+power+", Stuck:"+game.GetWarehouse().GetWorkerFromIndex(i).IsStuck());
        }
        System.out.println();
        game.GetIO().WriteToFileByLine("\n");
    }

    private static void selectworker(Game game) {

        for (int i = 0; i <game.GetWarehouse().GetWorkers().size() ; i++) {
            int y= (game.GetWarehouse().GetFields().indexOf(game.GetWarehouse().GetWorkerFromIndex(i).GetField()))/20;
            int x = (game.GetWarehouse().GetFields().indexOf(game.GetWarehouse().GetWorkerFromIndex(i).GetField())- 20*y);

            System.out.println((i+1)+": w"+(i+1)+" [X: "+x+" , Y: "+y+" , Power: "+game.GetWarehouse().GetWorkerFromIndex(i).GetPower()+"]");
        }
        System.out.print("Selected Worker: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String wNumber = null;
        try {
            wNumber = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert wNumber != null;
        Integer workerNumber = (Integer.parseInt(wNumber))-1;

        System.out.print("Command to w"+(workerNumber+1)+": ");

        String command = null;
        try {
            command = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(command.equals("move 1")){
            move(game,Direction.Up,game.GetWarehouse().GetWorkerFromIndex(workerNumber));
        }
        else  if(command.equals("move 2")){
            move(game,Direction.Down,game.GetWarehouse().GetWorkerFromIndex(workerNumber));
        }
        else  if(command.equals("move 3")){
            move(game,Direction.Left,game.GetWarehouse().GetWorkerFromIndex(workerNumber));
        }
       else  if(command.equals("move 4")){
            move(game,Direction.Right,game.GetWarehouse().GetWorkerFromIndex(workerNumber));
        }
        else  if(command.equals("addtrap 1")){
            addtrap(game, game.GetWarehouse().GetWorkerFromIndex(workerNumber),1);
        }
        else  if(command.equals("addtrap 2")){
           addtrap(game, game.GetWarehouse().GetWorkerFromIndex(workerNumber),2);
        }




    }
    private static void move(Game game,Direction d,Worker w){
        int y= (game.GetWarehouse().GetFields().indexOf(w.GetField()))/20;
        int x = (game.GetWarehouse().GetFields().indexOf(w.GetField())-20*y);
        String outPrevious ="Previous Field: X: "+x+", " + "Y: "+y;
        System.out.print(outPrevious+"\n");
        game.GetIO().WriteToFileByLine(outPrevious);



        w.Move(d);
         y= (game.GetWarehouse().GetFields().indexOf(w.GetField()))/20;
         x = (game.GetWarehouse().GetFields().indexOf(w.GetField())-20*y);
        String outCurrent ="Current Field: X: " + x + ", " + "Y: " + y;
        System.out.print(outCurrent+"\n");
        game.GetIO().WriteToFileByLine(outCurrent);



    }
    public static void addtrap(Game game,Worker w,Integer trap){
        int y= (game.GetWarehouse().GetFields().indexOf(w.GetField()))/20;
        int x = (game.GetWarehouse().GetFields().indexOf(w.GetField())-20*y);
        if(trap==1){
            w.AddHoney();
            System.out.println("Added Honey To X: "+x+", Y: "+y);
            game.GetIO().WriteToFileByLine("Added Honey To X: "+x+", Y: "+y);
        }
        else if(trap==2){
            w.AddOil();
            System.out.println("Added Oil To X: "+x+", Y: "+y);
            game.GetIO().WriteToFileByLine("Added Oil To X: "+x+", Y: "+y);
        }
    }

    private static void addbox(Game game) {
        System.out.print("X: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String xCoord = null;
        try {
            xCoord = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer x = Integer.parseInt(xCoord);
        System.out.print("Y: ");
        String yCoord = null;
        try {
            yCoord = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer y = Integer.parseInt(yCoord);
        System.out.print("Traction: ");
        String traction = null;
        try {
            traction = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer t = Integer.parseInt(traction);


        Box b = new Box();
        b.SetTraction(t);
        if(game.GetWarehouse().GetFieldFromIndex(x+(y*20)).GetMoveable()!=null){
            System.out.println("Failed to add box to this field, because it's not empty!");
            game.GetIO().WriteToFileByLine("Failed to add box to this field, because it's not empty!");
        } else if (!game.GetWarehouse().GetFieldFromIndex(x+(y*20)).CheckStepOn()){
            System.out.println("Failed to add box to this field, because this field is a wall!");
            game.GetIO().WriteToFileByLine("Failed to add box to this field, because it's not empty!");
        }
        else {
            game.GetWarehouse().AddBox(b);
            game.GetWarehouse().GetFieldFromIndex(x + (y * 20)).AddMoveable(b);
            System.out.println("Box added to X: "+x+", Y: "+y);
            game.GetIO().WriteToFileByLine("Box added to X: "+x+", Y: "+y+"\n");
        }
    }

    private static void drawmap(Game game) {
        game.DrawMap();
    }

    private static void addworker(Game game) {
        System.out.print("X: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String xCoord = null;
        try {
            xCoord = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer x = Integer.parseInt(xCoord);
        System.out.print("Y: ");
        String yCoord = null;
        try {
            yCoord = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer y = Integer.parseInt(yCoord);
        System.out.print("Power: ");
        String power = null;
        try {
            power = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer p = Integer.parseInt(power);

        Worker w = new Worker();
        w.SetPower(p);
        if(game.GetWarehouse().GetFieldFromIndex(x+(y*20)).GetMoveable()!=null){
            System.out.println("Failed to add worker to this field, because it's not empty!\n");
            game.GetIO().WriteToFileByLine("Failed to add box to this field, because it's not empty!");
        } else if (!game.GetWarehouse().GetFieldFromIndex(x+(y*20)).CheckStepOn()){
            System.out.println("Failed to add worker to this field, because this field is a wall!\n");
            game.GetIO().WriteToFileByLine("Failed to add box to this field, because it's not empty!");
        }
        else {
            game.GetWarehouse().AddWorker(w);
            game.GetWarehouse().GetFieldFromIndex(x + (y * 20)).AddMoveable(w);
            System.out.println("Worker added to X: "+x+", Y: "+y+"\n");
            game.GetIO().WriteToFileByLine("Worker added to X: "+x+", Y: "+y);
        }

    }


    private static void start(Game game){
        try {
            game.GetIO().DeleteTestFile();
            game.StartGame();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//Szkeleton 'minipályák'-----------------------------------------------------
    private static void Menu() { //menürendszer
        System.out.println("Tesztesetek:");
        System.out.println("=======================");
        System.out.println("1. Worker Move To SteppableField");
        System.out.println("2. Worker Move To Switch");
        System.out.println("3. Worker Move To Open Hole");
        System.out.println("4. Worker Move To Close Hole");
        System.out.println("5. Worker Move To TargetField");
        System.out.println("6. Worker Move To Wall");
        System.out.println("7. Worker Push Box To SteppableField");
        System.out.println("8. Worker Push Box To Switch");
        System.out.println("9. Worker Push Box To TargetField");
        System.out.println("10. Worker Push Box To Wall");
        System.out.println("11. Worker Push Box To Open Hole");
        System.out.println("12. Worker Push Box To Close Hole");
        System.out.println("13. Worker Push Worker To SteppableField");
        System.out.println("14. Worker Push Worker To Wall");
        System.out.println("15. Worker Push More(3) Box To SteppableField");
        System.out.println("16. Worker Push Box And Worker To SteppableField");
        System.out.println("17. Worker Push Box And Worker To Wall");
        System.out.println("18.  End Game When All Worker Is Dead");
        System.out.println("19.  End Game When All Box Is Dead");
        System.out.println("20.  End Game When All  TargetFields Are Inactive (All Box Reach TargetField)");
        System.out.println("21. Worker Push Box And Worker And Box To SteppableField");
        System.out.println("22. Worker Push Box To SteppableField With Honey");
        System.out.println("23. Worker Push Box To SteppableField With Oil");
        System.out.println("=======================");

        System.out.print("Válasszon tesztesetet: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String level = null;
        try {
            level = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (level){
            case "1":WorkerMoveToSteppableField(); Menu();
            case "2":WorkerMoveToSwitch();Menu();
            case "3":WorkerMoveToOpenHole();Menu();
            case "4":WorkerMoveToCloseHole();Menu();
            case "5":WorkerMoveToTargetField();Menu();
            case "6":WorkerMoveToWall();Menu();
            case "7":WorkerPushBoxToSteppableField(); Menu();
            case "8":WorkerPushBoxToSwitch();Menu();
            case "9":WorkerPushBoxToTargetField();Menu();
            case "10":WorkerPushBoxToWall();Menu();
            case "11":WorkerPushBoxToOpenHole();Menu();
            case "12":WorkerPushBoxToCloseHole();Menu();
            case "13":WorkerPushWorkerToSteppableField();Menu();
            case "14":WorkerPushWorkerToWall();Menu();
            case "15":WorkerPushMoreBoxToSteppableField();Menu();
            case "16":WorkerPushBoxAndWorkerToSteppableField();Menu();
            case "17":WorkerPushBoxAndWorkerToWall();Menu();
            case "18":EndGameWhenAllWorkerIsDead();Menu();
            case "19":EndGameWhenAllBoxIsDead();Menu();
            case "20": EndGameWhenAllTargetFieldsAreInactive();Menu();
            case "21":WorkerPushBoxAndWorkerAndBoxToSteppableField();Menu();
            case "22":WorkerPushBoxToSteppableFieldWithHoney();Menu();
            case "23":WorkerPushBoxToSteppableFieldWithOil();Menu();
            default:
                System.out.println("\nNem található ilyen teszteset.\n");Menu();
        }



    }

    private static void WorkerPushBoxToSteppableFieldWithOil() {
        System.out.println("Worker Push Box To SteppableField:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b = new Box();
        Worker w = new Worker();
        Oil h=new Oil();
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        SteppableField f3 = new SteppableField();
        f3.AddTrap(h);
        b.SetTraction(2);
        w.SetPower(2);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w);
        f2.AddMoveable(b);
        wh.AddWorker(w);
        wh.AddBox(b);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    private static void WorkerPushBoxToSteppableFieldWithHoney() {
        System.out.println("Worker Push Box To SteppableField:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b = new Box();
        Worker w = new Worker();
        Honey h=new Honey();
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        SteppableField f3 = new SteppableField();
        f3.AddTrap(h);
        b.SetTraction(2);
        w.SetPower(2);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w);
        f2.AddMoveable(b);
        wh.AddWorker(w);
        wh.AddBox(b);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    private static void WorkerPushBoxAndWorkerAndBoxToSteppableField() {
        System.out.println("Worker Push Box And Worker And Box To SteppableField:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b1 = new Box();
        Box b2=new Box();
        Worker w1 = new Worker();
        Worker w2 = new Worker();

        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        SteppableField f3 = new SteppableField();
        SteppableField f4 = new SteppableField();
        SteppableField f5 = new SteppableField();
        w1.SetPower(4);
        w2.SetPower(1);
        b1.SetTraction(2);
        b2.SetTraction(2);

        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f3.SetNeighbor(f4,Direction.Right);
        f4.SetNeighbor(f5,Direction.Right);

        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f4.SetNeighbor(f3, Direction.Left);
        f5.SetNeighbor(f4, Direction.Left);

        f1.AddMoveable(w1);
        f2.AddMoveable(b1);
        f3.AddMoveable(w2);
        f4.AddMoveable(b2);


        wh.AddWorker(w1);
        wh.AddWorker(w2);
        wh.AddBox(b1);
        wh.AddBox(b2);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3); wh.AddField(f4); wh.AddField(f5);
        System.out.println("\t-------------------------------------------");
        w1.Move(Direction.Right);
        System.out.println();
    }

    private static void EndGameWhenAllTargetFieldsAreInactive() {
        System.out.println("TEnd Game When All  TargetFields Are Inactive:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b = new Box();
        Box b2 = new Box();
        Worker w = new Worker(68);
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        TargetField f3 = new TargetField();
        f3.SetActive(true);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w);
        f2.AddMoveable(b);
        wh.AddWorker(w);
        wh.AddBox(b);
        wh.AddBox(b2);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3);
        Game game = Game.GetInstance();
        game.SetWarehouse(wh);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    private static void EndGameWhenAllBoxIsDead() {
        System.out.println("End Game When All Box Is Dead:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b = new Box();

        Worker w = new Worker();
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        Hole f3 = new Hole();
        f3.SetOpen(true);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w);
        f2.AddMoveable(b);
        wh.AddWorker(w);
        wh.AddBox(b);
        Game game = Game.GetInstance();
        game.SetWarehouse(wh);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    private static void EndGameWhenAllWorkerIsDead() {
        System.out.println("End Game When All Worker Is Dead:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Worker w = new Worker();
        SteppableField f1 = new SteppableField();
        Hole f2 = new Hole();
        f2.SetOpen(true);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f1.AddMoveable(w);
        wh.AddWorker(w);
        Game game = Game.GetInstance();
        game.SetWarehouse(wh);
        wh.AddField(f1); wh.AddField(f2);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    //11.
    private static void WorkerPushBoxToOpenHole() {
        System.out.println("Worker Push Box To OpenHole:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b = new Box();
        Box b2 = new Box();
        Worker w = new Worker();
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        Hole f3 = new Hole();
        f3.SetOpen(true);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w);
        f2.AddMoveable(b);
        wh.AddWorker(w);
        wh.AddBox(b);
        wh.AddBox(b2);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    //12
    private static void WorkerPushBoxToCloseHole() {
        System.out.println("Worker Push Box To CloseHole:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b = new Box();
        Worker w = new Worker();
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        Hole f3 = new Hole();
        f3.SetOpen(false);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w);
        f2.AddMoveable(b);
        wh.AddWorker(w);
        wh.AddBox(b);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    //13.
    private static void WorkerPushWorkerToSteppableField() {
        System.out.println("Worker Push Worker To SteppableField:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Worker w1 = new Worker();
        Worker w2 = new Worker();
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        SteppableField f3 = new SteppableField();

        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w1);
        f2.AddMoveable(w2);
        wh.AddWorker(w1);
        wh.AddWorker(w2);
        //b.SetWarehouse(wh);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3);
        System.out.println("\t-------------------------------------------");
        w1.Move(Direction.Right);
        System.out.println();
    }

    //14.
    private static void WorkerPushWorkerToWall() {
        System.out.println("Worker Push Worker To Wall:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Worker w1 = new Worker();
        Worker w2 = new Worker();
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        Wall f3 = new Wall();

        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w1);
        f2.AddMoveable(w2);
        wh.AddWorker(w1);
        wh.AddWorker(w2);
        //b.SetWarehouse(wh);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3);
        System.out.println("\t-------------------------------------------");
        w1.Move(Direction.Right);
        System.out.println();
    }

    //15.
    private static void WorkerPushMoreBoxToSteppableField() {
        System.out.println("Worker Push More Box To SteppableField:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b1 = new Box();
        Box b2 = new Box();
        Box b3 = new Box();
        Worker w = new Worker();

        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        SteppableField f3 = new SteppableField();
        SteppableField f4 = new SteppableField();
        SteppableField f5 = new SteppableField();

        b1.SetTraction(1);
        b2.SetTraction(2);
        b3.SetTraction(1);
        Oil oil = new Oil();
        w.SetPower(3);
        f3.AddTrap(oil);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f3.SetNeighbor(f4,Direction.Right);
        f4.SetNeighbor(f5,Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f4.SetNeighbor(f3, Direction.Left);
        f5.SetNeighbor(f4, Direction.Left);
        f1.AddMoveable(w);
        f2.AddMoveable(b1);
        f3.AddMoveable(b2);
        f4.AddMoveable(b3);
        wh.AddWorker(w);
        wh.AddBox(b1);
        wh.AddBox(b2);
        wh.AddBox(b3);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3); wh.AddField(f4); wh.AddField(f5);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    //16
    private static void WorkerPushBoxAndWorkerToSteppableField() {
        System.out.println("Worker Push Box And Worker To SteppableField:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b = new Box();
        Worker w1 = new Worker();
        Worker w2 = new Worker();

        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        SteppableField f3 = new SteppableField();
        SteppableField f4 = new SteppableField();


        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f3.SetNeighbor(f4,Direction.Right);

        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f4.SetNeighbor(f3, Direction.Left);

        f1.AddMoveable(w1);
        f2.AddMoveable(b);
        f3.AddMoveable(w2);

        wh.AddWorker(w1);
        wh.AddWorker(w2);
        wh.AddBox(b);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3); wh.AddField(f4);
        System.out.println("\t-------------------------------------------");
        w1.Move(Direction.Right);
        System.out.println();
    }

    //17.
    private static void WorkerPushBoxAndWorkerToWall() {
        System.out.println("Worker Push Box And Worker To Wall:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b = new Box();
        Worker w1 = new Worker();
        Worker w2 = new Worker();
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        SteppableField f3 = new SteppableField();
        Wall f4 = new Wall();


        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f3.SetNeighbor(f4,Direction.Right);

        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f4.SetNeighbor(f3, Direction.Left);

        f1.AddMoveable(w1);
        f2.AddMoveable(b);
        f3.AddMoveable(w2);

        wh.AddWorker(w1);
        wh.AddWorker(w2);
        wh.AddBox(b);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3); wh.AddField(f4);
        System.out.println("\t-------------------------------------------");
        w1.Move(Direction.Right);
        System.out.println();
    }

    //eredeti 10.
    private static void WorkerPushBoxToWall() {
        System.out.println("Worker Push Box To Wall:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b = new Box();
        Worker w = new Worker();
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        Wall f3 = new Wall();
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w);
        f2.AddMoveable(b);
        wh.AddWorker(w);
        wh.AddBox(b);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    //9.
    private static void WorkerPushBoxToTargetField() {
        System.out.println("Worker Push Box To SteppableField:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b = new Box();
        Box b2 = new Box();
        Worker w = new Worker();
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        TargetField f3 = new TargetField();
        TargetField f4 = new TargetField();
        f4.SetActive(true);
        f3.SetActive(true);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w);
        f2.AddMoveable(b);
        wh.AddWorker(w);
        wh.AddBox(b);
        wh.AddBox(b2);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3); wh.AddField(f4);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    //8.
    private static void WorkerPushBoxToSwitch() {
        System.out.println("Worker Push Box To Switch:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b = new Box();
        Worker w = new Worker();
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        Switch f3 = new Switch();
        Hole f4 = new Hole();
        f3.SetHole(f4);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w);
        f2.AddMoveable(b);
        wh.AddWorker(w);
        wh.AddBox(b);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3); wh.AddField(f4);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    //4.
    private static void WorkerMoveToCloseHole() {
        System.out.println("Worker Move To Close Hole:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Worker w = new Worker();
        SteppableField f1 = new SteppableField();
        Hole f2 = new Hole();
        f2.SetOpen(false);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f1.AddMoveable(w);
        wh.AddWorker(w);
        wh.AddField(f1); wh.AddField(f2);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    //5.
    private static void WorkerMoveToTargetField() {
        System.out.println("Worker Move To TargetField:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Worker w = new Worker();
        SteppableField f1 = new SteppableField();
        TargetField f2 = new TargetField();
        f2.SetActive(true);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f1.AddMoveable(w);
        wh.AddWorker(w);
        wh.AddField(f1); wh.AddField(f2);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();

    }

    // ez a 6.
    private static void WorkerMoveToWall() {
        System.out.println("Worker Move To Wall:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Worker w = new Worker();
        SteppableField f1 = new SteppableField();
        Wall f2 = new Wall();
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f1.AddMoveable(w);
        wh.AddWorker(w);
        wh.AddField(f1); wh.AddField(f2);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    //3.
    private static void WorkerMoveToOpenHole() {
        System.out.println("Worker Move To Open Hole:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Worker w = new Worker();
        Worker w2= new Worker();
        SteppableField f3 = new SteppableField();
        f3.AddMoveable(w2);
        SteppableField f1 = new SteppableField();
        Hole f2 = new Hole();
        f2.SetOpen(true);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f1.AddMoveable(w);
        wh.AddWorker(w);
        wh.AddWorker(w2);
        wh.AddField(f1); wh.AddField(f2);wh.AddField(f3);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    //2.
    private static void WorkerMoveToSwitch() {
        System.out.println("Worker Move To Switch:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Worker w = new Worker();
        SteppableField f1 = new SteppableField();
        Switch f2 = new Switch();
        Hole f3 = new Hole();
        f2.SetHole(f3);

        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w);
        wh.AddWorker(w);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    // ez a 7.
    private static void WorkerPushBoxToSteppableField() { //empty steppablefield
        System.out.println("Worker Push Box To SteppableField:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Box b = new Box();
        Worker w = new Worker();


        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        SteppableField f3 = new SteppableField();
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f3, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f3.SetNeighbor(f2, Direction.Left);
        f1.AddMoveable(w);
        f2.AddMoveable(b);
        wh.AddWorker(w);
        wh.AddBox(b);
        wh.AddField(f1); wh.AddField(f2); wh.AddField(f3);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

    //ez a 1.
    private static void WorkerMoveToSteppableField() {
        System.out.println("Worker Move To SteppableField:");
        System.out.println("\tinit:--------------------------------------");
        Warehouse wh = new Warehouse();
        Worker w = new Worker();
        SteppableField f1 = new SteppableField();
        SteppableField f2 = new SteppableField();
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f1.AddMoveable(w);
        wh.AddWorker(w);
        wh.AddField(f1); wh.AddField(f2);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

}
