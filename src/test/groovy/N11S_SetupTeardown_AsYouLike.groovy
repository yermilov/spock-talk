import groovy.sql.Sql
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title('Spock setup and cleanup')
@Narrative('''
As JEEConf speaker
I want to show that Spock can be very similar to JUnit
When we talk about setup/cleanup
''')
class N11S_SetupTeardown_AsYouLike extends Specification implements DatabaseSpec {

    def 'tool count'() {
        when: 'we count number of unit testing tools'
        def actual = sql.firstRow("select count(*) as toolCount from testing_tool")

        then: 'it should be 3'
        actual.toolCount == 3
    }

    def 'JUnit5 is in game!'() {
        given: 'JUnit 5 in the list of unit testing tools'
        sql.execute("insert into testing_tool values (4, 'junit', '5')")

        when: 'we count number of JUnits'
        def actual = sql.firstRow("select count(*) as toolCount from testing_tool where name = 'junit'")

        then: 'it should be 2'
        actual.toolCount == 2
    }
}