package therfc;

public class Main {

    public static void main(String[] args) {
        BoxPushedToSteppableField();

    }

    public static void BoxPushedToSteppableField() { //empty steppablefield
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
        f3.SetNeighbor(f2,Direction.Left);
        f1.AddMoveable(w);
        f2.AddMoveable(b);
        w.SetWarehouse(wh);
        b.SetWarehouse(wh);
        System.out.println("\t-------------------------------------------");
        w.Move(Direction.Right);
    }
}
