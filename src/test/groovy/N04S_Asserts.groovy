import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title('Spock assert')
@Narrative('''
As JEEConf speaker
I want to show how great Spock assertions are
''')
class N04S_Asserts extends Specification {

    def 'ArrayList.size()'() {
        setup: 'new ArrayList instance'
        ArrayList<String> list = new ArrayList<>()

        expect: 'that newly created ArrayList instance is empty'
        list.empty

        when: 'add two values into list'
        list.add 'we'
        list.add 'will'
        list.add 'love'
        list.add 'spock'

        then: "we'll be ok"
        list.findAll({ it.length() < 5 }).groupBy({ it[0] }).find({ k, v -> v.size() > 1 }).value == list.findAll({ it.length() < 5 }).drop(1)
    }
}
