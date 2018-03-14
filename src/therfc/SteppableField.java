package therfc;
import java.util.*;

/**
 * 
 */
public class SteppableField extends Field {

    //attribútumok
    private Logger logger = new Logger();
    //konstruktor
    public SteppableField() {
    }

   //függvények
    public void StepOn(Worker w, Direction d) {
        
    }

    public void StepOn(Box b, Direction d) {
        logger.Enter(this,"StepOn","b,d");
        Field previousField=this.GetPreviousField(d);
        previousField.RemoveMoveable(b);
        this.AddMoveable(b);
        logger.Exit(this,"StepOn","b stepped on this field");
    }



}