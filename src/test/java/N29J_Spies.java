import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Config.class)
public class N29J_Spies {

    @Autowired
    String alphabet;

    @Autowired
    Random random;

    @Test
    public void passwordOfRandomLength() {
        // setup
        PasswordGenerator passwordGenerator = spy(PasswordGenerator.class);
        passwordGenerator.setRandom(random);
        passwordGenerator.setAlphabet(alphabet);
        doReturn("password").when(passwordGenerator).generate(anyInt());

        // run
        passwordGenerator.generate();

        // verify
        ArgumentCaptor<Integer> argument = ArgumentCaptor.forClass(Integer.class);
        verify(passwordGenerator).generate(argument.capture());
        assertThat(argument.getValue(), is(greaterThanOrEqualTo(8)));
        assertThat(argument.getValue(), is(lessThan(18)));
    }
}
