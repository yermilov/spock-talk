import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Config.class)
public class N26J_Mocks {

    @Autowired
    PasswordGenerator passwordGenerator;

    @Test
    public void passwordOfLength5() {
        // setup
        Random random = mock(Random.class);

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
