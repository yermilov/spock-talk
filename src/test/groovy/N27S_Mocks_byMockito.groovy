import org.mockito.InOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
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
@ContextConfiguration(classes = Config)
class N27S_Mocks_byMockito extends Specification {

    @Autowired
    PasswordGenerator passwordGenerator

    def 'generating random password of length 5'() {
        given: 'random generator and password generator that uses it'
        Random random = mock(Random)
        passwordGenerator.random = random

        when: 'we ask password generator to generate password of length 5'
        passwordGenerator.generate(5)

        // tag::simpleVerify[]
        then: 'random generator is invoked 5 times'
        mockito verify(random, times(5)).nextInt(anyInt())
        // end::simpleVerify[]
    }

    def 'generating random password of random length'() {
        given: 'random generator and password generator that uses it'
        Random random = mock(Random)
        passwordGenerator.random = random

        when: 'we ask password generator to generate password of random length'
        passwordGenerator.generate()

        // tag::complexVerify[]
        then: '''first random generator is invoked once to generate password length,
                 then at least 8 times more and it is never invoked for anything else'''
        InOrder inOrder = inOrder(random)
        mockito inOrder.verify(random, times(1)).nextInt(10)
        mockito inOrder.verify(random, atLeast(8)).nextInt(26)
        mockito inOrder.verifyNoMoreInteractions()
        // end::complexVerify[]
    }

    // tag::mockitoSpock[]
    static def mockito(def verify) {
        true
    }
    // end::mockitoSpock[]
}
