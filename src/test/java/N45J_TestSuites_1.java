import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class N45J_TestSuites_1 {

    @Category(Fast.class)
    @Test
    public void passedFast() {
        assertThat(2+2, is(4));
    }

    @Category(Slow.class)
    @Test
    public void failingIn20Seconds() throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(20));
        assertThat(2+2, is(4));
    }
}
