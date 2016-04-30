import groovyx.net.http.HTTPBuilder
import spock.lang.IgnoreRest
import spock.lang.Narrative
import spock.lang.Requires
import spock.lang.Specification
import spock.lang.Title

@Title('Spock conditional runs')
@Narrative('''
As JEEConf speaker
I want to show how great Spock conditional runs are
''')
class X30S_ConditionalRuns_Part2 extends Specification {

    @IgnoreRest
    def 'this test makes all other test ignored'() {
        expect: 'a miracle'
        2 + 2 == 5
    }

    @Requires({ N30S_ConditionalRuns_Part2.isGoogleSearchAvaiable() })
    def 'this test runs only if Google Search is avaiable'() {
        setup: 'http connection service'
        def http = new HTTPBuilder('https://google.com')

        when: 'we search for the best java unit testing framework'
        def response = http.get(path : '/search', query : [q:'best java unit testing framework'])

        then: 'answer mentions spock'
        response.toString().toLowerCase().contains 'spock'
    }

    static boolean isGoogleSearchAvaiable() {
        try {
            new HTTPBuilder('http://www.google.com').get([:])
            return true
        } catch (e) {
            return false
        }
    }
}