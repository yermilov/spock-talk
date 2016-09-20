import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@RunWith(JUnitPlatform.class)
public class N43J5_ConditionalRuns {

    // tag::ignore[]
    @Disabled("will fix it before commit")
    @Test
    public void alwaysIgnored() {
        // TODO FIXME test is failing
        assertEquals(5, 2+2);
    }
    // end::ignore[]

    @Test
    public void ignoredOnWindows() {
        assumeTrue(System.getProperty("os.name").toLowerCase().contains("windows"));

        // ...
    }
}
