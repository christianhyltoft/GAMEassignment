import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTaxTest {
    FieldTax ftest= new FieldTax("tax","You landed on tax",null,4000,10);
    Player ptest= new Player(400000,"hans",4);
    Player ptest2= new Player(6000,"bent",5);

    @Test
    void landOn() {
        ftest.landOn(ptest,null);
        assertEquals(360000,ptest.getBalance());

        ftest.landOn(ptest2,null);
        assertEquals(2000,ptest2.getBalance());


    }
}