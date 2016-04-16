import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Title('ArrayList tests')
@Narrative('''
As Java developer
(that trust nothing)
I want to be sure ArrayList works
''')
class N03S_IdiomaticStart extends Specification {

    @Subject
    ArrayList<String> list

    @Issue('https://github.com/yermilov/spock-talk/issues/1')
    def 'ArrayList.size()'() {
        setup: 'new ArrayList instance'
        list = new ArrayList<>()

        expect: 'that newly created ArrayList instance is empty'
        list.empty

        when: 'add two values into list'
        list.add 'we'
        list.add 'will'

        then: 'array list size should be 2'
        list.size() == 2

        when: 'add two more values into list'
        list.add 'love'
        list.add 'junit'

        then: 'array list size should be 4'
        list.size() == 4
    }
}
