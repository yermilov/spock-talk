import spock.lang.*

class X08_Mocks extends Specification {

    def 'mocking random calls'() {
        setup:
            Random random = Mock()
            PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        when:
            passwordGenerator.generate(5)

        then:
            5 * random.nextInt(_)
    }

    def 'mocking random calls + cool features'() {
        setup:
            Random random = Mock()
            PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        when:
            passwordGenerator.generate()

        then:
            (8.._) * random.nextInt(_)
            0 * random.nextLong()
    }

    def 'mocking random calls + ordering'() {
        setup:
            Random random = Mock()
            PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        when:
            passwordGenerator.generate()

        then:
            1 * random.nextInt(10)

        then:
            _ * random.nextInt(26)

        then:
            0 * _
    }
}