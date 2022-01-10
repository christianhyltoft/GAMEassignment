import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RafflecupTest {
    Rafflecup rafflecupTest= new Rafflecup(2,6);

    @Test
    void sameFacesUpOnAllDice() {
        rafflecupTest.getCup()[0].setValue(6);
        rafflecupTest.getCup()[1].setValue(6);
        assertTrue(rafflecupTest.sameFacesUpOnAllDice());


    }
}