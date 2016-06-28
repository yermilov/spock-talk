import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.*

@Title('Spock stubbing')
@Narrative('''
As JEEConf speaker
I want to show how great Spock stubs are
''')
// tag::spring[]
@ContextConfiguration(classes = Config)
class N22S_Stubs extends Specification {

    @Autowired
    PasswordGenerator passwordGenerator
// end::spring[]

    def 'generating password when random generator return constant value'() {
        // tag::returnValue[]
        given: 'random generator that always return 0'
        Random random = Stub()
        random.nextInt(26) >> 0
        // end::returnValue[]

        and: 'password generator based on this random generator'
        passwordGenerator.random = random

        expect: 'certain generated password'
        passwordGenerator.generate(5) == 'aaaaa'
    }

    def 'generating password when random generator return predefined values'() {
        // tag::returnMultipleValues[]
        given: 'random generator that always return predefined values'
        Random random = Stub()
        random.nextInt(_) >>> [ 0, 1, 2, 3, 4 ]
        // end::returnMultipleValues[]

        and: 'password generator based on this random generator'
        passwordGenerator.random = random

        expect: 'certain generated password'
        passwordGenerator.generate(5) == 'abcde'
    }

    def 'generating password when random generator fails'() {
        // tag::throwException[]
        given: 'random generator that always throw exception'
        Random random = Stub()
        random.nextInt(_) >> { throw new RuntimeException() }
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
        Random random = Stub()
        random.nextInt(_) >> { int max -> max - 1 }
        // end::customBehavior[]

        and: 'password generator based on this random generator'
        passwordGenerator.random = random

        expect: 'certain generated password'
        passwordGenerator.generate(5) == 'zzzzz'
    }
}
