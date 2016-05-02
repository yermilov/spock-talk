import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class N42T_ConditionalRuns {

    @Test(enabled = false)
    public void alwaysIgnored() {
        // TODO FIXME test is failing
        assertEquals(2+2, 5);
    }
}
