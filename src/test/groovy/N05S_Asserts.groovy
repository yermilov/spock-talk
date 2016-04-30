import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

import static org.hamcrest.Matchers.hasSize
import static org.hamcrest.Matchers.hasSize
import static org.junit.Assert.assertThat
import static spock.util.matcher.HamcrestSupport.expect

@Title('Spock assert')
@Narrative('''
As JEEConf speaker
I want to show how great Spock assertions are
''')
class N05S_Asserts extends Specification {

    def arrayList_length() {
        setup:
        ArrayList<String> list = new ArrayList<>();

        when:
        list.add("we");
        list.add("will");
        list.add("love");
        list.add("spock");

        then:
        assertThat(list, hasSize(3));
    }

    def 'ArrayList.size() test, but much spockier'() {
        setup:
        ArrayList<String> list = new ArrayList<>()

        when:
        list.add('we')
        list.add('will')
        list.add('love')
        list.add('spock')

        then:
        list.size() == 3
    }

    def 'ArrayList.size() test, spock-way, but for hamcrest fans'() {
        setup:
        ArrayList<String> list = new ArrayList<>()

        when:
        list.add('we')
        list.add('will')
        list.add('love')
        list.add('spock')

        then:
        expect list, hasSize(3)
    }

    def 'complex assertion'() {
        setup:
        ArrayList<String> list = new ArrayList<>()

        expect:
        list.empty

        when:
        list.add 'we'
        list.add 'will'
        list.add 'love'
        list.add 'spock'

        then:
        list.findAll({ it.length() < 5 }).groupBy({ it[0] }).find({ k, v -> v.size() > 1 }).value == list.findAll({ it.length() < 5 }).drop(1)
    }
}
