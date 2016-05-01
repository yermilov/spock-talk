import org.junit.Test;

import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class N23J_Stubs {

    @Test
    public void constantValue() {
        // setup
        Random random = mock(Random.class);
        doReturn(0).when(random).nextInt(26);

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        passwordGenerator.setRandom(random);

        // verify
        assertThat(passwordGenerator.generate(5), is("aaaaa"));
    }

    @Test
    public void multipleValues() {
        // setup
        Random random = mock(Random.class);
        doReturn(0).doReturn(1).doReturn(2).doReturn(3).doReturn(4).when(random).nextInt(26);

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        passwordGenerator.setRandom(random);

        // verify
        assertThat(passwordGenerator.generate(5), is("abcde"));
    }

    @Test(expected = RuntimeException.class)
    public void exception() {
        // setup
        Random random = mock(Random.class);
        doThrow(new RuntimeException()).when(random).nextInt(26);

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        passwordGenerator.setRandom(random);

        // run
        passwordGenerator.generate(5);
    }

    @Test
    public void generatedValue() {
        // setup
        Random random = mock(Random.class);
        doAnswer(inv -> (int) inv.getArguments()[0] - 1).when(random).nextInt(26);

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        passwordGenerator.setRandom(random);

        // verify
        assertThat(passwordGenerator.generate(5), is("zzzzz"));
    }
}
