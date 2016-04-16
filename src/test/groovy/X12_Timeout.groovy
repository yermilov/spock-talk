import spock.lang.*

import java.util.concurrent.TimeUnit

class N12_Timeout extends Specification {

    @IgnoreRest
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    def 'infinite loop'() {
        given:
            def arrayList = new ArrayList<String>()

        expect:
            while (true) { arrayList.add('spock forever!') }
    }

    def 'junit - no way'() {
        given:
            def arrayList = new ArrayList<String>()

        expect:
            while (true) { arrayList.add('junit forever!') }
    }

    def 'testng????'() {
        given:
            def arrayList = new ArrayList<String>()

        expect:
            while (true) { arrayList.add('testng forever!') }
    }
}