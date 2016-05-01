import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class N17T_DataProviders {

    @DataProvider(name = "data")
    public static Object[][] data() {
        return new Object[][] {
            { 0.0,   6.0,  0.0,  10.0, 60.0, 6.0 },
            { 5.0,   0.0,  3.0,  3.0,  17.0, 9.0 },
            { -50.0, 10.0, -1.0, 10.0, 0.0,  0.0 }
        };
    }

    @Test(dataProvider = "data")
    public void speed(double initialLocation, double initialSpeed, double acceleration, double time, double expectedLocation, double expectedSpeed) {
        double speed = initialSpeed + acceleration * time;
        assertEquals(speed, expectedSpeed);
    }

    @Test(dataProvider = "data")
    public void location(double initialLocation, double initialSpeed, double acceleration, double time, double expectedLocation, double expectedSpeed) {
        double location = initialLocation + time * (initialSpeed + acceleration / 2 * time);
        assertEquals(location, expectedLocation);
    }
}
