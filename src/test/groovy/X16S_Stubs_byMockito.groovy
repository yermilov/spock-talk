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
class N16S_Stubs_byMockito extends Specification {

    def 'generating password when random generator return constant value'() {
        given: 'random generator that always return 0'
        Random random = mock(Random)
        doReturn(0).when(random).nextInt(26)

        and: 'password generator based on this random generator'
        PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        expect: 'certain generated password'
        passwordGenerator.generate(5) == 'aaaaa'
    }

    def 'generating password when random generator return predefined values'() {
        given: 'random generator that always return predefined values'
        Random random = mock(Random)
        doReturn(0).doReturn(1).doReturn(2).doReturn(3).doReturn(4).when(random).nextInt(26)

        and: 'password generator based on this random generator'
        PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        expect: 'certain generated password'
        passwordGenerator.generate(5) == 'abcde'
    }

    def 'generating password when random generator fails'() {
        given: 'random generator that always throw exception'
        Random random = mock(Random)
        doThrow(new RuntimeException()).when(random).nextInt(26)

        and: 'password generator based on this random generator'
        PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        when: 'we try to generate password'
        passwordGenerator.generate(5)

        then: 'exception is thrown'
        thrown(RuntimeException)
    }

    def 'generating password when random generator return biggest possible value'() {
        given: 'random generator that always return biggest possible value'
        Random random = mock(Random)
        doAnswer({ inv -> (int) inv.getArguments()[0] - 1}).when(random).nextInt(26)

        and: 'password generator based on this random generator'
        PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        expect: 'certain generated password'
        passwordGenerator.generate(5) == 'zzzzz'
    }
}