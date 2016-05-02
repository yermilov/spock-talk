import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

public class N41J_ConditionalRuns {

    @Ignore("will fix it before commit")
    @Test
    public void alwaysIgnored() {
        // TODO FIXME test is failing
        assertThat(2+2, is(5));
    }

    @Test
    public void ignoredOnWindows() {
        assumeThat(System.getProperty("os.name").toLowerCase(), is(not(containsString("windows"))));

        // ...
    }
}
