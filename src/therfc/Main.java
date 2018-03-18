package therfc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Target;

public class Main {

    public static void main(String[] args) {
       Menu();
    }


    private static void Menu() {
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
        ;
        System.out.println("18.  End Game When All Worker Is Dead");
        System.out.println("19.  End Game When All Box Is Dead");
        System.out.println("20.  End Game When All Box Pushed To TargetFields (All Box Reach TargetField)");
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
            case "20":EndGameWhenAllBoxPushedToTargetFields();Menu();
            default:
                System.out.println("\nNem található ilyen teszteset.\n");Menu();
        }



    }

    private static void EndGameWhenAllBoxPushedToTargetFields() {
        System.out.println("End Game When All Box Pushed To TargetField:");
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
        Game game = Game.getInstance();
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
        Game game = Game.getInstance();
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
        Game game = Game.getInstance();
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
        SteppableField f1 = new SteppableField();
        Hole f2 = new Hole();
        f2.SetOpen(true);
        f1.SetNeighbor(f2, Direction.Right);
        f2.SetNeighbor(f1, Direction.Left);
        f1.AddMoveable(w);
        wh.AddWorker(w);
        wh.AddWorker(w2);
        wh.AddField(f1); wh.AddField(f2);
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
