// tag::assertjTruth[]
import com.google.common.truth.Truth
import org.assertj.core.api.Assertions
// end::assertjTruth[]
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

// tag::assertHamcrest[]
import static org.hamcrest.Matchers.hasSize
import static org.junit.Assert.assertThat
// end::assertHamcrest[]
import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertEquals
// tag::expectSpock[]
import static spock.util.matcher.HamcrestSupport.expect
// end::expectSpock[]

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
        // tag::assertEqualsTrue[]

        assertEquals(list.size(), 3);
//        java.lang.AssertionError:
//        Expected :4
//        Actual   :3
        // end::assertEqualsTrue[]
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
        // tag::assertEqualsTrue[]

        assertTrue(list.size() == 3);
//        java.lang.AssertionError
//        at org.junit.Assert.fail(Assert.java:86)
//        at org.junit.Assert.assertTrue(Assert.java:41)
//        at org.junit.Assert.assertTrue(Assert.java:52)
        // end::assertEqualsTrue[]
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
        // tag::assertHamcrest[]

        assertThat(list, hasSize(3));
//        java.lang.AssertionError:
//        Expected: a collection with size \<3>
//        but: collection size was \<4>
        // end::assertHamcrest[]
    }

    def 'verifying array list size using Spock Assertions'() {
        setup:
        ArrayList<String> list = new ArrayList<>()

        when:
        list.add('we')
        list.add('will')
        list.add('love')
        list.add('spock')

        // tag::assertSpock[]

        then:
        list.size() == 3
//        Condition not satisfied:
//
//        list.size() == 3
//        |    |      |
//        |    4      false
//        [we, will, love, spock]
        // end::assertSpock[]
    }

    def 'verifying array list size using expect.hasSize'() {
        setup:
        ArrayList<String> list = new ArrayList<>()

        when:
        list.add('we')
        list.add('will')
        list.add('love')
        list.add('spock')

        // tag::expectSpock[]

        then:
        expect list, hasSize(3)
//        Condition not satisfied:
//
//        expect list, hasSize(3)
//        |      |
//        false  [we, will, love, spock]
//
//        Expected: a collection with size \<3>
//        but: collection size was \<4>
          // end::expectSpock[]
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
        // tag::assertjTruth[]

        Assertions.assertThat(list).hasSize(3);
//        java.lang.AssertionError:
//        Expected size:<3> but was:<4> in:
//        <["we", "will", "love", "spock"]>
        // end::assertjTruth[]
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
        // tag::assertjTruth[]

        Truth.assertThat(list).hasSize(3);
//      java.lang.AssertionError: Not true that <[we, will, love, spock]> has a size of <3>. It is \<4>
        // end::assertjTruth[]
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
//        Condition not satisfied:
//
//        list.findAll({ it.length() < 5 }).groupBy({ it[0] }).find({ k, v -> v.size() > 1 }).value == list.findAll({ it.length() < 5 }).drop(1)
//        |    |                            |                  |                              |     |  |    |                            |
//        |    [we, will, love]             |                  w=[we, will]                   |     |  |    [we, will, love]             [will, love]
//        [we, will, love, spock]           [w:[we, will], l:[love]]                          |     |  [we, will, love, spock]
//        |     false
//        [we, will]
    }
}
