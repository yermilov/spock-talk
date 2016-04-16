import spock.lang.*
import spock.util.concurrent.PollingConditions

import java.util.concurrent.TimeUnit

class X16_Sometimes extends Specification {

    def 'once it will find answer'() {
        setup:
            def conditions = new PollingConditions(timeout: 20)
            Integer answer = null

        when:
            new Thread() {

                @Override
                void run() {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(new Random().nextInt(10)))
                    answer = 42
                }
            }.start()

        then:
            conditions.eventually {
                assert answer == 42
            }
    }

    def "once it will find answer - but we don't want ot wait"() {
        setup:
            def conditions = new PollingConditions(timeout: 20)
            Integer answer = null

        when:
            new Thread() {

                @Override
                void run() {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(new Random().nextInt(10)))
                    answer = 42
                }
            }.start()

        then:
            conditions.within(10) {
                assert answer == 42
            }
    }
}
