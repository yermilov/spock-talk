import spock.lang.*

class N07_Stubs extends Specification {

    def 'stubbing random int'() {
        setup:
            Random random = Stub()
            random.nextInt(26) >> 0

            PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        expect:
            passwordGenerator.generate(5) == 'aaaaa'
    }

    def 'stubbing several random ints'() {
        setup:
            Random random = Stub()
            random.nextInt(_) >>> [ 0, 1, 2, 3, 4 ]

            PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        expect:
            passwordGenerator.generate(5) == 'abcde'
    }

    def 'stubbing exception thrown'() {
        setup:
            Random random = Stub()
            random.nextInt(_) >> { throw new RuntimeException() }

            PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        when:
            passwordGenerator.generate(5)

        then:
            thrown(RuntimeException)
    }

    def 'return middle letter'() {
        setup:
            Random random = Stub()
            random.nextInt(_) >> { int max -> max / 2 }

            PasswordGenerator passwordGenerator = new PasswordGenerator(random: random)

        expect:
            passwordGenerator.generate(5) == 'nnnnn'
    }
}