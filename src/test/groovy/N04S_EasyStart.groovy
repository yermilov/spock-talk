// tag::easySpock[]
import spock.lang.Specification
// end::easySpock[]

import static org.hamcrest.Matchers.hasSize
import static org.junit.Assert.assertThat

// tag::easySpock[]

class N04S_EasyStart extends Specification { // <1>

    def arrayList_length() { // <1>
        setup: // <2>
        ArrayList<String> list = new ArrayList<>();

        when: // <2>
        list.add("we");
        list.add("will");
        list.add("love");
        list.add("spock");

        then: // <2>
        assertThat(list, hasSize(4)); // <3>
    }
// end::easySpock[]

    def 'ArrayList.size() test, but much spockier'() {
        setup:
        ArrayList<String> list = new ArrayList<>()

        when:
        list.add('we')
        list.add('will')
        list.add('love')
        list.add('spock')

        then:
        list.size() == 4
    }

// tag::easySpock[]
}
// end::easySpock[]
