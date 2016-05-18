import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

import java.util.concurrent.TimeUnit

@Title('Spock test suites')
@Narrative('''
As JEEConf speaker
I want to show how great Spock test suites are
''')
class N44S_TestSuites extends Specification {

    @Fast
    def passedFast() {
        expect: 'that everything is ok'
        2 + 2 == 4
    }

    @Slow
    def failingIn20Seconds() {
        setup: 'some resource'
        Thread.sleep(TimeUnit.SECONDS.toMillis(20))

        expect: 'that everything is not ok'
        2 + 2 == 5
    }

    @Slow
    def failingIn10Seconds() {
        setup: 'some resource'
        Thread.sleep(TimeUnit.SECONDS.toMillis(10))

        expect: 'that everything is not ok in this universe'
        2 + 2 == 5
    }

    @Slow
    def passedIn20Seconds() {
        setup: 'some resource'
        Thread.sleep(TimeUnit.SECONDS.toMillis(20))

        expect: 'that everything is not ok in this universe'
        2 + 2 == 4
    }

    @Slow
    def passedIn10Seconds() {
        setup: 'some resource'
        Thread.sleep(TimeUnit.SECONDS.toMillis(10))

        expect: 'that everything is not ok in this universe'
        2 + 2 == 4
    }
}
