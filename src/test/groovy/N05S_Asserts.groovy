import com.google.common.truth.Truth
import org.assertj.core.api.Assertions
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

import static org.hamcrest.Matchers.hasSize
import static org.junit.Assert.assertThat
import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertEquals
import static spock.util.matcher.HamcrestSupport.expect

@Title('Spock assert')
@Narrative('''
As JEEConf speaker
I want to show how great Spock assertions are
''')
class N05S_Asserts extends Specification {

    def 'verifying array list size using assertEquals'() {
        setup:
        ArrayList<String> list = new ArrayList<>();

        when:
        list.add("we");
        list.add("will");
        list.add("love");
        list.add("spock");

        then:
        assertEquals(list.size(), 3);
    }

    def 'verifying array list size using assertTrue'() {
        setup:
        ArrayList<String> list = new ArrayList<>();

        when:
        list.add("we");
        list.add("will");
        list.add("love");
        list.add("spock");

        then:
        assertTrue(list.size() == 3);
    }

    def 'verifying array list size using assertThat.hasSize'() {
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

    def 'verifying array list size using Spock Asserions'() {
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

    def 'verifying array list size using expect.hasSize'() {
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

    def 'verifying array list size using Assertions.assertThat.hasSize'() {
        setup:
        ArrayList<String> list = new ArrayList<>();

        when:
        list.add("we");
        list.add("will");
        list.add("love");
        list.add("spock");

        then:
        Assertions.assertThat(list).hasSize(3);
    }

    def 'verifying array list size using Truth.assertThat.hasSize'() {
        setup:
        ArrayList<String> list = new ArrayList<>();

        when:
        list.add("we");
        list.add("will");
        list.add("love");
        list.add("spock");

        then:
        Truth.assertThat(list).hasSize(3);
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
