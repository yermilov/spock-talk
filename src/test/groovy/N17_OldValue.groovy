import spock.lang.*
import spock.util.concurrent.PollingConditions

import java.util.concurrent.TimeUnit

class N17_OldValue extends Specification {

    def 'plus works!'() {
        setup:
            int x = 5

        when:
            x = x * 3

        then:
            x == old(x) + 10
    }
}
