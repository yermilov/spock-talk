import spock.lang.*

@Title('Spock emoji')
@Narrative('''
As JEEConf speaker
I want to show you something terrifying
''')
class X22S_WhoLovesJ extends Specification {

    def 'something terrifying'() {
        when: 'mocking goes to far'
        Mock(Random)

        then: 'that guy who ends up maintaining your code will be a violent psychopath who knows where you live'
        (_.._) * _.(_) >> _
    }
}