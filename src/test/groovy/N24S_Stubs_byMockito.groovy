import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

import static org.mockito.Mockito.doAnswer
import static org.mockito.Mockito.doReturn
import static org.mockito.Mockito.doThrow
import static org.mockito.Mockito.mock

@Title('Spock stubbing')
@Narrative('''
As JEEConf speaker
I want to show that Mockito still works inside Spock
''')
@ContextConfiguration(classes = Config)
class N24S_Stubs_byMockito extends Specification {

    @Autowired
    PasswordGenerator passwordGenerator

    def 'generating password when random generator return constant value'() {
        // tag::returnValue[]
        given: 'random generator that always return 0'
        Random random = mock(Random)
        doReturn(0).when(random).nextInt(26)
        // end::returnValue[]

        and: 'password generator based on this random generator'
        passwordGenerator.random = random

        expect: 'certain generated password'
        passwordGenerator.generate(5) == 'aaaaa'
    }

    def 'generating password when random generator return predefined values'() {
        // tag::returnMultipleValues[]
        given: 'random generator that always return predefined values'
        Random random = mock(Random)
        doReturn(0).doReturn(1).doReturn(2).doReturn(3).doReturn(4).when(random).nextInt(26)
        // end::returnMultipleValues[]

        and: 'password generator based on this random generator'
        passwordGenerator.random = random

        expect: 'certain generated password'
        passwordGenerator.generate(5) == 'abcde'
    }

    def 'generating password when random generator fails'() {
        // tag::throwException[]
        given: 'random generator that always throw exception'
        Random random = mock(Random)
        doThrow(new RuntimeException()).when(random).nextInt(26)
        // end::throwException[]

        and: 'password generator based on this random generator'
        passwordGenerator.random = random

        when: 'we try to generate password'
        passwordGenerator.generate(5)

        then: 'exception is thrown'
        thrown(RuntimeException)
    }

    def 'generating password when random generator return biggest possible value'() {
        // tag::customBehavior[]
        given: 'random generator that always return biggest possible value'
        Random random = mock(Random)
        doAnswer({ inv -> (int) inv.getArguments()[0] - 1}).when(random).nextInt(26)
        // end::customBehavior[]

        and: 'password generator based on this random generator'
        passwordGenerator.random = random

        expect: 'certain generated password'
        passwordGenerator.generate(5) == 'zzzzz'
    }
}
