import spock.lang.*

import java.util.concurrent.TimeUnit

@Title('Spock timeout')
@Narrative('''
As JEEConf speaker
I want to show that Spock is slightly better at time limitations
''')
class N33S_Timeout extends Specification {

    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    def 'infinite loop'() {
        setup: 'array list'
        def arrayList = new ArrayList<String>()

        expect: 'we will add to it values forever'
        while (true) { arrayList.add('spock forever!') }
    }
}