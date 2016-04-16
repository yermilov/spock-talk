import spock.lang.*

class N10_WhoLovesJ extends Specification {

    def 'anybody loves J?'() {
        setup:
            PasswordGenerator passwordGenerator = Spy(PasswordGenerator)

        when:
            passwordGenerator.generate()

        then:
            (_.._) * _.(_) >> _
    }
}