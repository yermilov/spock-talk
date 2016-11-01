import spock.lang.*

@Title('Spock emoji')
@Narrative('''
As JEEConf speaker
I want to show you something terrifying
''')
class N30S_WithGreatPowerComesGreatResponsibility extends Specification {

    // tag::syntaxBomb[]
    def 'syntax bomb'() {
        when: 'mocking goes to far'
        Mock(Random)

        then: '''that guy who ends up maintaining
                 your code will be a violent psychopath
                 who knows where you live'''
        (_.._) * _.(_) >> _
    }
    // end::syntaxBomb[]

    // tag::staticFinal[]
    def 'static final mocking'() {
        given: 'we can mock *static* method of *final* class java.lang.Math'
        GroovySpy(Math, global: true)
        1 * Math.abs(_) >> 28

        expect: 'a miracle happens'
        Math.abs(17) == 28
    }
    // end::staticFinal[]

    def 'constructor mocking'() {
        given: 'we can mock constructor of *final* class java.lang.String'
        GroovySpy(String, global: true)
        new String(_) >> new String('boom!')

        expect: 'a miracle happens'
        new String('WAT') == 'boom!'
    }
}
