import org.apache.commons.math3.primes.Primes
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title
import spock.util.concurrent.AsyncConditions

import java.util.concurrent.TimeUnit

@Title('Spock async conditions')
@Narrative('''
As JEEConf speaker
I want to show that Spock is way much better at async assertions
''')
class N37S_AsyncCondition extends Specification {

    def conditions = new AsyncConditions()

    def 'find next prime after 2817 within 3 seconds'() {
        when: 'async start calculating next prime after 1728'
        asyncNextPrime( 1728, { answer ->
            conditions.evaluate { assert answer == 1733 }
        } )

        then: 'within 3 seconds answer will be found'
        conditions.await(3)
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