import spock.lang.*

@Title('Spock spies')
@Narrative('''
As JEEConf speaker
I want to show how great Spock spies are
''')
class N28S_Spies extends Specification {

    def 'when generating random password of random length then something should be generated'() {
        setup: 'spy on password generator'
        PasswordGenerator passwordGenerator = Spy(PasswordGenerator)

        when: 'we ask password generator to generate password of random length'
        passwordGenerator.generate()

        then: 'it tries to generate password of some length'
        1 * passwordGenerator.generate(_)
    }

    def 'when generating random password of random length then something with non-null length should be generated'() {
        setup: 'spy on password generator'
        PasswordGenerator passwordGenerator = Spy(PasswordGenerator)

        when: 'we ask password generator to generate password of random length'
        passwordGenerator.generate()

        then: 'it tries to generate password of some not-null length'
        1 * passwordGenerator.generate(!null)
    }

    def 'when generating random password of random length then something with integer length should be generated'() {
        setup: 'spy on password generator'
        PasswordGenerator passwordGenerator = Spy(PasswordGenerator)

        when: 'we ask password generator to generate password of random length'
        passwordGenerator.generate()

        then: 'it tries to generate password of some integer length'
        1 * passwordGenerator.generate(_ as Integer)
    }

    def 'when generating random password of random length then password of length from 8 to 17 should be generated'() {
        setup: 'spy on password generator'
        PasswordGenerator passwordGenerator = Spy(PasswordGenerator)

        when: 'we ask password generator to generate password of random length'
        passwordGenerator.generate()

        then: 'it tries to generate password of length from 8 to 17'
        1 * passwordGenerator.generate({ it >= 8 && it < 18 })
    }
}