import org.springframework.boot.test.OutputCapture
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title('Spock and JUnit rules integration')
@Narrative('''
As JEEConf speaker
I want to show that Spock works great with JUnit Rules API
''')
class N51S_JUnitRules extends Specification {

    @org.junit.Rule OutputCapture capture = new OutputCapture()

    def "capture output print method"() {
        when: 'text is printed to console'
        print "2 + 2 = ${2+2}"

        then: 'it is printed as expected'
        capture.toString() == '2 + 2 = 4'
    }
}