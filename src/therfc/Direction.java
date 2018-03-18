package therfc;
import java.util.*;


public enum  Direction {
    Up,Down,Right,Left;

    public Direction OppositeDirection(){
        switch (this){
            case Up: return Down;
            case Down: return Up;
            case Right: return Left;
            case Left: return Right;
            default: return null;
        }
    }
}