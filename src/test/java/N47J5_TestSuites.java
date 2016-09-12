import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class N47J5_TestSuites {

    // tag::testSuite[]
    @Tag("fast") // <1>
    @Test
    public void passedFast() {
        assertEquals(4, 2+2);
    }

    @Tag("slow") // <1>
    @Test
    public void failingIn20Seconds() throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(20));
        assertEquals(5, 2+2);
    }
    // end::testSuite[]
}
