import org.junit.Test;
import org.mockito.InOrder;

import java.util.Random;

import static org.mockito.Mockito.*;

public class X18J_Mocks {

    @Test
    public void passwordOfLength5() {
        // setup
        Random random = mock(Random.class);

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        passwordGenerator.setRandom(random);

        // run
        passwordGenerator.generate(5);

        // verify
        verify(random, times(5)).nextInt(anyInt());
    }

    @Test
    public void passwordOfRandomLength() {
        // setup
        Random random = mock(Random.class);

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        passwordGenerator.setRandom(random);

        // run
        passwordGenerator.generate();

        // verify
        InOrder inOrder = inOrder(random);
        inOrder.verify(random, times(1)).nextInt(10);
        inOrder.verify(random, atLeast(8)).nextInt(26);
        inOrder.verifyNoMoreInteractions();
    }
}
