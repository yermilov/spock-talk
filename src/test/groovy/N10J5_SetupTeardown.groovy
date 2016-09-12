import groovy.sql.Sql
// tag::structureJUnit5[]
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
// end::structureJUnit5[]
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class N10J5_SetupTeardown {

    // tag::structureJUnit5[]

    static Sql sql

    @BeforeAll
    public static void createTable() {
        sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
        sql.execute("create table testing_tool (id int primary key, name varchar(100), version varchar(100))")
    }

    @BeforeEach
    public void insertBasicData() {
        sql.execute("insert into testing_tool values (1, 'junit', '4.12'), (2, 'spock', '1.0'), (3, 'testng', '6.9.10')")
    }

    @Test
    public void toolCount() {
        // run
        def actual = sql.firstRow("select count(*) as toolCount from testing_tool")

        // verify
        assertEquals(3L, actual.toolCount)
    }

    @AfterEach
    public void cleanTable() {
        sql.execute("delete from testing_tool")
    }

    @AfterAll
    public static void dropTable() {
        sql.execute("drop table testing_tool")
        sql.close()
    }
    // end::structureJUnit5[]

    @Test
    public void 'JUnit5 is in game!'() {
        // setup
        sql.execute("insert into testing_tool values (4, 'junit', '5')")

        // run
        def actual = sql.firstRow("select count(*) as toolCount from testing_tool where name = 'junit'")

        // verify
        assertEquals(2L, actual.toolCount)
    }
}
