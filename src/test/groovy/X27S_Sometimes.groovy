import org.apache.commons.math3.primes.Primes
import spock.lang.*
import spock.util.concurrent.PollingConditions

import java.util.concurrent.TimeUnit

@Title('Spock eventually')
@Narrative('''
As JEEConf speaker
I want to show that Spock is way much better at eventual assertions
''')
class X27S_Sometimes extends Specification {

    def conditions = new PollingConditions(timeout: 30)

    def 'find next prime after 1728 eventually'() {
        setup: 'holder for answer'
        Integer actual = null

        when: 'async start calculating next prime after 1728'
        asyncNextPrime( 1728, { answer -> actual = answer } )

        then: 'eventually answer will be found'
        conditions.eventually {
            assert actual == 1733
        }
    }

    def 'find next prime after 2817 within 3 seconds'() {
        setup: 'holder for answer'
        Integer actual = null

        when: 'async start calculating next prime after 1728'
        asyncNextPrime( 2817, { answer -> actual = answer } )

        then: 'within 3 seconds answer will be found'
        conditions.within(3) {
            assert actual == 2819
        }
    }

    def asyncNextPrime(int number, Closure callback) {
        new Thread() {
            @Override
            void run() {
                Thread.sleep(TimeUnit.SECONDS.toMillis(new Random().nextInt(5)))
                callback.call(Primes.nextPrime(number))
            }
        }.start()
    }
}
