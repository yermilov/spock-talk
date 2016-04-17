import org.junit.Test

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty
import static org.junit.Assume.assumeThat

class N05J_PowerAsserts {

    @Test
    void 'ArrayList.size()'() {
        // setup
        ArrayList<String> list = new ArrayList<>()
        assumeThat(list, is(empty()));

        // run
        list.add 'we'
        list.add 'will'
        list.add 'love'
        list.add 'spock'

        // verify
        assert list.findAll({ it.length() < 5 }).groupBy({ it[0] }).find({ k, v -> v.size() > 1 }).value.join('#').toUpperCase() == 'WAT?? CAN_WE_GUESS_IT???'
    }
}
