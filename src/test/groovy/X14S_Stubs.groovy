import spock.lang.*

@Title('Spock stubbing')
@Narrative('''
As JEEConf speaker
I want to show how great Spock stubs are
''')
class N14S_Stubs extends Specification {

    def 'generating password when random generator return constant value'() {
        given: 'random generator that always return 0'
            Random random = Stub()
            random.nextInt(26) >> 0

        and: 'password generator based on this random generator'
            PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        expect: 'certain generated password'
            passwordGenerator.generate(5) == 'aaaaa'
    }

    def 'generating password when random generator return predefined values'() {
        given: 'random generator that always return predefined values'
        Random random = Stub()
        random.nextInt(_) >>> [ 0, 1, 2, 3, 4 ]

        and: 'password generator based on this random generator'
        PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        expect: 'certain generated password'
        passwordGenerator.generate(5) == 'abcde'
    }

    def 'generating password when random generator fails'() {
        given: 'random generator that always throw exception'
            Random random = Stub()
            random.nextInt(_) >> { throw new RuntimeException() }

        and: 'password generator based on this random generator'
            PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        when: 'we try to generate password'
            passwordGenerator.generate(5)

        then: 'exception is thrown'
            thrown(RuntimeException)
    }

    def 'generating password when random generator return biggest possible value'() {
        given: 'random generator that always return biggest possible value'
            Random random = Stub()
            random.nextInt(_) >> { int max -> max - 1 }

        and: 'password generator based on this random generator'
            PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        expect: 'certain generated password'
            passwordGenerator.generate(5) == 'zzzzz'
    }
}