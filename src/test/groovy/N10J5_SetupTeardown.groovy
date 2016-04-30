import groovy.sql.Sql
import org.junit.gen5.api.AfterAll
import org.junit.gen5.api.AfterEach
import org.junit.gen5.api.BeforeAll
import org.junit.gen5.api.BeforeEach
import org.junit.gen5.api.Test
import org.junit.gen5.junit4.runner.JUnit5
import org.junit.runner.RunWith

import static org.junit.gen5.api.Assertions.assertEquals

@RunWith(JUnit5.class)
class N10J5_SetupTeardown {

    static Sql sql

    @BeforeAll
    public static void createTable() {
        sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
        sql.execute("create table testing_tool (id int primary key, name varchar(100), version varchar(100))")
    }

    @AfterAll
    public static void dropTable() {
        sql.execute("drop table testing_tool")
        sql.close()
    }

    @BeforeEach
    public void insertBasicData() {
        sql.execute("insert into testing_tool values (1, 'junit', '4.12'), (2, 'spock', '1.0'), (3, 'testng', '6.9.10')")
    }

    @AfterEach
    public void cleanTable() {
        sql.execute("delete from testing_tool")
    }

    @Test
    public void toolCount() {
        // run
        def actual = sql.firstRow("select count(*) as toolCount from testing_tool")

        // verify
        assertEquals(3L, actual.toolCount)
    }

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
