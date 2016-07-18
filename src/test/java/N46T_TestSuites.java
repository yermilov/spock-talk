import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class N46T_TestSuites {

    // tag::testSuite[]
    @Test(groups = "fast") // <1>
    public void passedFast() {
        assertEquals(2+2, 4);
    }

    @Test(groups = "slow") // <1>
    public void failingIn20Seconds() throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(20));
        assertEquals(2+2, 5);
    }
    // end::testSuite[]
}
