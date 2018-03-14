package therfc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            case "8":WorkerPushBoxToSteppableTargetSwitch();Menu();
            case "9":WorkerPushBoxToSteppableFieldTarget();Menu();
            case "10":WorkerPushBoxToWall();Menu();
            case "11":WorkerPushBoxToOpenHole();Menu();
            case "12":WorkerPushBoxToCloseHole();Menu();
            case "13":WorkerPushWorkerToSteppableField();Menu();
            case "14":WorkerPushWorkerToWall();Menu();
            case "15":WorkerPushMoreBoxToSteppableField();Menu();
            case "16":WorkerPushBoxAndWorkerToSteppableField();Menu();
            case "17":WorkerPushBoxAndWorkerToWall();Menu();
            default: Menu();
        }



    }

    private static void WorkerPushBoxToOpenHole() {
    }

    private static void WorkerPushBoxToCloseHole() {
    }

    private static void WorkerPushWorkerToSteppableField() {
    }

    private static void WorkerPushWorkerToWall() {
    }

    private static void WorkerPushMoreBoxToSteppableField() {
    }

    private static void WorkerPushBoxAndWorkerToSteppableField() {
    }

    private static void WorkerPushBoxAndWorkerToWall() {
    }

    private static void WorkerPushBoxToWall() {
    }

    private static void WorkerPushBoxToSteppableFieldTarget() {
    }

    private static void WorkerPushBoxToSteppableTargetSwitch() {
    }

    private static void WorkerMoveToCloseHole() {
    }

    private static void WorkerMoveToTargetField() {
    }

    private static void WorkerMoveToWall() {
    }

    private static void WorkerMoveToOpenHole() {
    }

    private static void WorkerMoveToSwitch() {
    }

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
        w.SetWarehouse(wh);
        b.SetWarehouse(wh);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }

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
        w.SetWarehouse(wh);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
        System.out.println();
    }
}
