import com.sun.source.tree.AssertTree;
import junit.*;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveTSTField {
    FieldDeed deedtest = new FieldDeed("Road1", "you landed on road 1", 1000, 200, 50, 200);

    @Test
    public void housetest(){
        deedtest.setAmountOfHouses(4);
        int expected=850;

        assertEquals(expected,deedtest.getTotalrent());


    }


}
