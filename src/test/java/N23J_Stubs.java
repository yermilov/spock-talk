import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Config.class)
public class N23J_Stubs {

    @Autowired
    PasswordGenerator passwordGenerator;

    @Test
    public void constantValue() {
        // setup
        Random random = mock(Random.class);
        doReturn(0).when(random).nextInt(26);

        passwordGenerator.setRandom(random);

        // verify
        assertThat(passwordGenerator.generate(5), is("aaaaa"));
    }

    @Test
    public void multipleValues() {
        // setup
        Random random = mock(Random.class);
        doReturn(0).doReturn(1).doReturn(2).doReturn(3).doReturn(4).when(random).nextInt(26);

        passwordGenerator.setRandom(random);

        // verify
        assertThat(passwordGenerator.generate(5), is("abcde"));
    }

    @Test(expected = RuntimeException.class)
    public void exception() {
        // setup
        Random random = mock(Random.class);
        doThrow(new RuntimeException()).when(random).nextInt(26);

        passwordGenerator.setRandom(random);

        // run
        passwordGenerator.generate(5);
    }

    @Test
    public void generatedValue() {
        // setup
        Random random = mock(Random.class);
        doAnswer(inv -> (int) inv.getArguments()[0] - 1).when(random).nextInt(26);

        passwordGenerator.setRandom(random);

        // verify
        assertThat(passwordGenerator.generate(5), is("zzzzz"));
    }
}
