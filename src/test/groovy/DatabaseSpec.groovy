import groovy.sql.Sql

trait DatabaseSpec {

    static Sql sql

    def setupSpec() {
        sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
        sql.execute("create table testing_tool (id int primary key, name varchar(100), version varchar(100))")
    }

    def cleanupSpec() {
        sql.execute("drop table testing_tool")
        sql.close()
    }

    def setup() {
        sql.execute("insert into testing_tool values (1, 'junit', '4.12'), (2, 'spock', '1.0'), (3, 'testng', '6.9.10')")
    }

    def cleanup() {
        sql.execute("delete from testing_tool")
    }
}