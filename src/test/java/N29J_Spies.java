import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class N29J_Spies {

    @Test
    public void passwordOfRandomLength() {
        // setup
        PasswordGenerator passwordGenerator = spy(PasswordGenerator.class);
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
