import org.junit.gen5.api.Disabled;
import org.junit.gen5.api.Test;
import org.junit.gen5.junit4.runner.JUnit5;
import org.junit.runner.RunWith;

import static org.junit.gen5.api.Assertions.assertEquals;
import static org.junit.gen5.api.Assumptions.assumeTrue;

@RunWith(JUnit5.class)
public class N43J5_ConditionalRuns {

    @Disabled("will fix it before commit")
    @Test
    public void alwaysIgnored() {
        // TODO FIXME test is failing
        assertEquals(5, 2+2);
    }

    @Test
    public void ignoredOnWindows() {
        assumeTrue(System.getProperty("os.name").toLowerCase().contains("windows"));

        // ...
    }
}
