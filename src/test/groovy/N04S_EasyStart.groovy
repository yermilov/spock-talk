import spock.lang.Specification

import static org.hamcrest.Matchers.hasSize
import static org.junit.Assert.assertThat

class N04S_EasyStart extends Specification {

    def arrayList_length() {
        setup:
        ArrayList<String> list = new ArrayList<>();

        when:
        list.add("we");
        list.add("will");
        list.add("love");
        list.add("spock");

        then:
        assertThat(list, hasSize(4));
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
        list.size() == 4
    }
}