import spock.lang.*

class X09_Spies extends Specification {

    def 'sping on password generator'() {
        setup:
            PasswordGenerator passwordGenerator = Spy(PasswordGenerator)

        when:
            passwordGenerator.generate()

        then:
            1 * passwordGenerator.generate(_)
    }

    def 'sping on password generator - better'() {
        setup:
            PasswordGenerator passwordGenerator = Spy(PasswordGenerator)

        when:
            passwordGenerator.generate()

        then:
            1 * passwordGenerator.generate(!null)
    }

    def 'sping on password generator - even better'() {
        setup:
            PasswordGenerator passwordGenerator = Spy(PasswordGenerator)

        when:
            passwordGenerator.generate()

        then:
            1 * passwordGenerator.generate(_ as Integer)
    }

    def 'sping on password generator - best'() {
        setup:
            PasswordGenerator passwordGenerator = Spy(PasswordGenerator)

        when:
            passwordGenerator.generate()

        then:
            1 * passwordGenerator.generate({ it >= 8 && it < 18 })
    }
}