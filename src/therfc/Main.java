package therfc;

public class Main {

    public static void main(String[] args) {
    Warehouse wh = new Warehouse();
	Box b = new Box();
	SteppableField f1 = new SteppableField();
	SteppableField f2 = new SteppableField();
	f1.SetNeighbor(f2,Direction.Right);
    f2.SetNeighbor(f1,Direction.Left);
	f1.AddMoveable(b);
	b.SetWarehouse(wh);

	b.Push(null,Direction.Right);

    }
}
