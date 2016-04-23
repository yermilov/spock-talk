import org.mockito.InOrder
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

import static org.mockito.Matchers.anyInt
import static org.mockito.Mockito.atLeast
import static org.mockito.Mockito.inOrder
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.times
import static org.mockito.Mockito.verify

@Title('Spock mocking')
@Narrative('''
As JEEConf speaker
I want to show that Mockito still works inside Spock
''')
class N19S_Mocks_byMockito extends Specification {

    def 'generating random password of length 5'() {
        given: 'random generator and password generator that uses it'
        Random random = mock(Random)
        PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        when: 'we ask password generator to generate password of length 5'
        passwordGenerator.generate(5)

        then: 'random generator is invoked 5 times'
        verify(random, times(5)).nextInt(anyInt()) || true
    }

    def 'generating random password of random length'() {
        given: 'random generator and password generator that uses it'
        Random random = mock(Random)
        PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        when: 'we ask password generator to generate password of random length'
        passwordGenerator.generate()

        then: 'first random generator is invoked once to generate password length'
        InOrder inOrder = inOrder(random)
        inOrder.verify(random, times(1)).nextInt(10) || true

        and: 'then random generator is invoked at least 8 times more'
        inOrder.verify(random, atLeast(8)).nextInt(26) || true

        and: 'random generator is never invoked for anything else'
        inOrder.verifyNoMoreInteractions() || true
    }
}