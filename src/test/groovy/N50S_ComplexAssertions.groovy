import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title('Spock complex assertions')
@Narrative('''
As JEEConf speaker
I want to show that Spock complex assertions
''')
class N50S_ComplexAssertions extends Specification {

    def 'verifying array list size using Spock Assertions and with'() {
        setup: 'new ArrayList instance'
        ArrayList<String> list = new ArrayList<>()

        when: 'add values to list'
        list.add('we')
        list.add('will')
        list.add('love')
        list.add('spock')

        // tag::with[]
        then: 'list is not empty, is of size 4, and contains all added values'
        with(list) {
            empty == false
            size() == 4
            get(0) == 'we'
            get(1) == 'will'
            get(2) == 'love'
            get(3) == 'spock'
        }
        // end::with[]
    }

    def 'verifying array list size using Spock Assertions and verifyAll'() {
        setup: 'new ArrayList instance'
        ArrayList<String> list = new ArrayList<>()

        when: 'add values to list'
        list.add('we')
        list.add('will')
        list.add('love')
        list.add('spock')

        // tag::verifyAll[]
        then: 'list is not empty, is of size 3, and contains all added values'
        verifyAll {
            list.empty == false
            list.size() == 3
            list.get(0) == 'we'
            list.get(1) == 'love'
            list.get(2) == 'spock'
        }
        // end::verifyAll[]
    }

}
