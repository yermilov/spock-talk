import org.junit.Test;

import java.util.ArrayList;

public class N34J_Timeout {

    @Test(timeout = 2000)
    public void infiniteLoop() {
        // setup
        ArrayList<String> arrayList = new ArrayList<>();

        // run
        while (true) { arrayList.add("junit forever!"); }
    }
}
