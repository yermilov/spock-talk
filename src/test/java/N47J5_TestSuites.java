import org.junit.gen5.api.Tag;
import org.junit.gen5.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.gen5.api.Assertions.assertEquals;

public class N47J5_TestSuites {

    @Tag("fast")
    @Test
    public void passedFast() {
        assertEquals(4, 2+2);
    }

    @Tag("slow")
    @Test
    public void failingIn20Seconds() throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(20));
        assertEquals(5, 2+2);
    }
}
