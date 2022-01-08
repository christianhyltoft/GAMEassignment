import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveTSTField {
    FieldDeed deedtest = new FieldDeed("Road1", "you landed on road 1", 1000, 200, 50,100,150,200,500,600);

    @Test
    public void housetest(){
        deedtest.setAmountOfHouses(4);
        int expected=850;
        assertEquals(50,deedtest.getRent());



    }


}
