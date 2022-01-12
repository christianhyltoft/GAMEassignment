import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player ptest= new Player(30000,"hans",0);

    @Test
    void changePosition() {
        ptest.changePosition(6);
        assertEquals(6,ptest.getPosition());
        assertTrue(ptest.getPosition()!=7);

        ptest.setPosition(39);
        ptest.changePosition(6);
        assertEquals(5,ptest.getPosition());

        ptest.setPosition(39);
        ptest.changePosition(1);
        assertEquals(0,ptest.getPosition());

        //Tester grænser
        ptest.setPosition(38);
        ptest.changePosition(1);
        assertEquals(39,ptest.getPosition());

        // Tester negative positioner på grund af chancekort der rykker tilbage
        ptest.setPosition(1);
        ptest.changePosition(-3);
        assertEquals(38,ptest.getPosition());





    }
    @Test
    void changeBalancetest(){
        ptest.setBalance(-10000);
        ptest.changeBalance(-4000);
        assertEquals(-14000,ptest.getBalance());



    }
}