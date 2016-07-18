import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Title('ArrayList tests') // <1>
@Narrative('''
As Java developer
(that trust nothing)
I want to be sure ArrayList works
''') // <2>
@Report
class N07S_IdiomaticSpock extends Specification {

    @Subject // <3>
    ArrayList<String> list

    @Issue('https://github.com/yermilov/spock-talk/issues/1') // <4>
    def 'ArrayList.size()'() {
        setup: 'new ArrayList instance' // <5>
        list = new ArrayList<>()

        expect: 'that newly created ArrayList instance is empty' // <6>
        list.empty

        when: 'add value to list' // <7>
        list.add 'we'

        and: 'add one more value to list' // <8>
        list.add 'will'

        then: 'array list size should be 2' // <9>
        list.size() == 2

        when: 'add two more values into list'
        list.add 'love'
        list.add 'spock'

        then: 'array list size should be 4'
        list.size() == 4

        and: 'list contains all needed values'
        list == [ 'we', 'will', 'love', 'spock' ]
    }
}
