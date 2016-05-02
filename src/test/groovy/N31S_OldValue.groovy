import groovy.sql.Sql
import spock.lang.*

@Title('Spock record old values')
@Narrative('''
As JEEConf speaker
I want to show that Spock can record old values
''')
class N31S_OldValue extends Specification {

    @Shared sql

    def setupSpec() {
        sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
        sql.execute("create table testing_tool (id int primary key, name varchar(100), version varchar(100))")
        sql.execute("insert into testing_tool values (1, 'junit', '4.12'), (2, 'spock', '1.0'), (3, 'testng', '6.9.10')")
    }

    def cleanupSpec() {
        sql.execute("drop table testing_tool")
    }

    def 'modifying data in table'() {
        when: 'add JUnit 5 to the list of unit testing tools'
        sql.execute("insert into testing_tool values (4, 'junit', '5')")

        then: 'number of tools should be incremented'
        sql.firstRow("select count(*) as toolCount from testing_tool").toolCount ==
                old(sql.firstRow("select count(*) as toolCount from testing_tool").toolCount) + 1

        when: 'remove JUnit 5 from the list of unit testing tools'
        sql.execute("delete from testing_tool where id = 4")

        then: 'number of tools should be decremented'
        sql.firstRow("select count(*) as toolCount from testing_tool").toolCount == old(sql.firstRow("select count(*) as toolCount from testing_tool").toolCount) - 1
    }
}
