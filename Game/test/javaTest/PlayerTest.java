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




    }
}