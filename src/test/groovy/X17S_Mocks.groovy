import spock.lang.*

@Title('Spock mocking')
@Narrative('''
As JEEConf speaker
I want to show how great Spock mocks are
''')
class X17S_Mocks extends Specification {

    def 'generating random password of length 5'() {
        given: 'random generator and password generator that uses it'
        Random random = Mock()
        PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        when: 'we ask password generator to generate password of length 5'
        passwordGenerator.generate(5)

        then: 'random generator is invoked 5 times'
        5 * random.nextInt(_)
    }

    def 'generating random password of random length'() {
        given: 'random generator and password generator that uses it'
        Random random = Mock()
        PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        when: 'we ask password generator to generate password of random length'
        passwordGenerator.generate()

        then: 'first random generator is invoked once to generate password length'
        1 * random.nextInt(10)

        then: 'then random generator is invoked at least 8 times more'
        (8.._) * random.nextInt(_)

        then: 'random generator is never invoked for anything else'
        0 * random._
    }
}