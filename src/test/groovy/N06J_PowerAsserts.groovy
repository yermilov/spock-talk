import org.junit.Test

class N06J_PowerAsserts {

    // tag::assertGroovy[]
    @Test
    void 'ArrayList.size()'() {
        // setup
        ArrayList<String> list = new ArrayList<>()

        // run
        list.add 'we'
        list.add 'will'
        list.add 'love'
        list.add 'spock'

        // verify
        assert list.findAll({ it.length() < 5 }) == list.drop(2)
//        Assertion failed:
//
//        assert list.findAll({ it.length() < 5 }) == list.drop(2)
//        |    |                            |  |    |
//        |    [we, will, love]             |  |    [love, spock]
//        [we, will, love, spock]           |  [we, will, love, spock]
//        false
    }
    // end::assertGroovy[]
}
