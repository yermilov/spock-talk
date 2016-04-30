import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class X11J_DataTables {

    @Parameterized.Parameters(name = "calculate runner speed and location after some time for {6}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 0.0,   6.0,  0.0,  10.0, 60.0, 6.0, "steady run from starting point" },
            { 5.0,   0.0,  3.0,  3.0,  17.0, 9.0, "starting from standing with acceleration" },
            { -50.0, 10.0, -1.0, 10.0, 0.0,  0.0, "constant deceleration"}
        });
    }

    @Parameterized.Parameter(value = 0)
    public double initialLocation;

    @Parameterized.Parameter(value = 1)
    public double initialSpeed;

    @Parameterized.Parameter(value = 2)
    public double acceleration;

    @Parameterized.Parameter(value = 3)
    public double time;

    @Parameterized.Parameter(value = 4)
    public double expectedLocation;

    @Parameterized.Parameter(value = 5)
    public double expectedSpeed;

    @Parameterized.Parameter(value = 6)
    public String description;

    @Test
    public void speed() {
        double speed = initialSpeed + acceleration * time;
        assertThat(speed, is(equalTo(expectedSpeed)));
    }

    @Test
    public void location() {
        double location = initialLocation + time * (initialSpeed + acceleration / 2 * time);
        assertThat(location, is(equalTo(expectedLocation)));
    }
}
