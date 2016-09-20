import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@RunWith(JUnitPlatform.class)
public class N18_J5_DynamicTests {

    // tag::dynamicTest[]

    private static final Object[][] DATA = new Object[][] {
            { 0.0,   6.0,  0.0,  10.0, 60.0, 6.0, "steady run from starting point" },
            { 5.0,   0.0,  3.0,  3.0,  17.0, 9.0, "starting from standing with acceleration" },
            { -50.0, 10.0, -1.0, 10.0, 0.0,  0.0, "constant deceleration"}
    };

    @TestFactory
    public Stream<DynamicTest> speedTests() {
        return Arrays.stream(DATA).map(data -> dynamicTest(data[6].toString(), () -> {
            double initialSpeed = (double) data[1];
            double acceleration = (double) data[2];
            double time = (double) data[3];
            double expectedSpeed = (double) data[5];

            double speed = initialSpeed + acceleration * time;
            assertEquals(expectedSpeed, speed);
        }));
    }

    // end::dynamicTest[]

    @TestFactory
    public Stream<DynamicTest> locationTests() {
        return Arrays.stream(DATA).map(data -> dynamicTest(data[6].toString(), () -> {
            double initialLocation = (double) data[0];
            double initialSpeed = (double) data[1];
            double acceleration = (double) data[2];
            double time = (double) data[3];
            double expectedLocation = (double) data[4];

            double location = initialLocation + time * (initialSpeed + acceleration / 2 * time);
            assertEquals(expectedLocation, location);
        }));
    }
}
