import groovy.sql.Sql
import spock.lang.AutoCleanup
import spock.lang.Narrative
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Title

@Title('Spock setup and cleanup')
@Narrative('''
As JEEConf speaker
I want to show that Spock can be even better than JUnit have
When we talk about setup/cleanup
''')
class N12S_SetupTeardown_AndMore extends Specification {

    // tag::structureSpock[]

    @Shared @AutoCleanup sql // <1> <2>

    // end::structureSpock[]

    def setupSpec() {
        sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
        sql.execute("create table testing_tool (id int primary key, name varchar(100), version varchar(100))")
        sql.execute("insert into testing_tool values (1, 'junit', '4.12'), (2, 'spock', '1.0'), (3, 'testng', '6.9.10')")
    }

    // tag::structureSpock[]
    def 'JUnit5 is in game!'() {
        setup: 'add JUnit 5 to the list of unit testing tools' // <3>
        sql.execute("insert into testing_tool values (4, 'junit', '5')")

        when: 'we count number of JUnits'
        def actual = sql.firstRow("select count(*) as toolCount from testing_tool where name = 'junit'")

        then: 'it should be 2'
        actual.toolCount == 2

        cleanup: 'remove JUnit 5 from the list of unit testing tools' // <4>
        sql.execute("delete from testing_tool where id = 4")
    }
    // end::structureSpock[]

    def 'tool count'() {
        when: 'we count number of unit testing tools'
        def actual = sql.firstRow("select count(*) as toolCount from testing_tool")

        then: 'it should be 3'
        actual.toolCount == 3
    }
}
