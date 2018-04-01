package therfc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
      // Menu(); //Szkeleton menü
        //TestLevel();
        Game game=Game.GetInstance();
        try {
            game.StartGame();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void TestLevel(){
        Warehouse wh = new Warehouse();
        Wall wall_1= new Wall();
        Wall wall_2= new Wall();
        Wall wall_3= new Wall();
        Wall wall_4= new Wall();
        Wall wall_5= new Wall();
        Wall wall_6= new Wall();
        Wall wall_7= new Wall();
        Wall wall_8= new Wall();
        Wall wall_9= new Wall();
        Wall wall_10= new Wall();
        Wall wall_11= new Wall();
        Wall wall_12= new Wall();
        Wall wall_13= new Wall();
        Wall wall_14= new Wall();
        SteppableField s_1 = new SteppableField();
        SteppableField s_2 = new SteppableField();
        SteppableField s_3 = new SteppableField();
        SteppableField s_4 = new SteppableField();
        wall_1.SetNeighbor(wall_2,Direction.Right); wall_1.SetNeighbor(wall_14,Direction.Down);
        wall_2.SetNeighbor(wall_3,Direction.Right); wall_2.SetNeighbor(wall_1,Direction.Left);
        wall_3.SetNeighbor(wall_4,Direction.Right); wall_3.SetNeighbor(wall_2,Direction.Left);
        wall_4.SetNeighbor(wall_5,Direction.Right); wall_4.SetNeighbor(wall_3,Direction.Left);
        wall_5.SetNeighbor(wall_6,Direction.Right); wall_5.SetNeighbor(wall_4,Direction.Left);
        wall_6.SetNeighbor(wall_7,Direction.Down); wall_6.SetNeighbor(wall_5,Direction.Left);
        wall_7.SetNeighbor(wall_8,Direction.Down); wall_7.SetNeighbor(wall_6,Direction.Up);
        wall_8.SetNeighbor(wall_7,Direction.Up); wall_8.SetNeighbor(wall_9,Direction.Left);
        wall_9.SetNeighbor(wall_8,Direction.Right); wall_9.SetNeighbor(wall_10,Direction.Left);
        wall_10.SetNeighbor(wall_9,Direction.Right); wall_10.SetNeighbor(wall_11,Direction.Left);
        wall_11.SetNeighbor(wall_10,Direction.Right); wall_11.SetNeighbor(wall_12,Direction.Left);
        wall_12.SetNeighbor(wall_11,Direction.Right); wall_12.SetNeighbor(wall_13,Direction.Left);
        wall_13.SetNeighbor(wall_12,Direction.Right); wall_13.SetNeighbor(wall_14,Direction.Up);
        wall_14.SetNeighbor(wall_1,Direction.Up); wall_14.SetNeighbor(wall_13,Direction.Down);
        s_1.SetNeighbor(wall_2,Direction.Up);s_1.SetNeighbor(wall_12,Direction.Down);s_1.SetNeighbor(wall_14,Direction.Left);s_1.SetNeighbor(s_2,Direction.Right);
        s_2.SetNeighbor(wall_3,Direction.Up);s_2.SetNeighbor(wall_11,Direction.Down);s_2.SetNeighbor(s_1,Direction.Left);s_2.SetNeighbor(s_3,Direction.Right);
        s_3.SetNeighbor(wall_4,Direction.Up);s_3.SetNeighbor(wall_10,Direction.Down);s_3.SetNeighbor(s_2,Direction.Left);s_3.SetNeighbor(s_4,Direction.Right);
        s_4.SetNeighbor(wall_5,Direction.Up);s_4.SetNeighbor(wall_9,Direction.Down);s_4.SetNeighbor(s_3,Direction.Left);s_4.SetNeighbor(wall_7,Direction.Right);

        Worker w = new Worker();
        Box b = new Box();

        w.SetPower(3);
        b.SetTraction(4);

        Oil oil = new Oil();
        s_2.AddMoveable(w);
        s_3.AddTrap(oil);
        s_3.AddMoveable(b);

        wh.AddBox(b); wh.AddWorker(w);
        wh.AddField(wall_1);
        wh.AddField(wall_2);
        wh.AddField(wall_3);
        wh.AddField(wall_4);
        wh.AddField(wall_5);
        wh.AddField(wall_6);
        wh.AddField(wall_7);
        wh.AddField(wall_8);
        wh.AddField(wall_9);
        wh.AddField(wall_10);
        wh.AddField(wall_11);
        wh.AddField(wall_12);
        wh.AddField(wall_13);
        wh.AddField(wall_14);
        wh.AddField(s_1);
        wh.AddField(s_2);
        wh.AddField(s_3);
        wh.AddField(s_4);
        Game game = Game.GetInstance();
        game.SetWarehouse(wh);
        w.Move(Direction.Right);



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
