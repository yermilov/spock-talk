import groovy.sql.Sql
// tag::structureJUnit[]
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
// end::structureJUnit[]

import static org.junit.Assert.assertThat
import static org.hamcrest.Matchers.is;

class N08J_SetupTeardown {

    // tag::structureJUnit[]

    static Sql sql // <1>

    @BeforeClass // <2>
    public static void createTable() {
        sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
        sql.execute("create table testing_tool (id int primary key, name varchar(100), version varchar(100))")
    }

    @Before // <3>
    public void insertBasicData() {
        sql.execute("insert into testing_tool values (1, 'junit', '4.12'), (2, 'spock', '1.0'), (3, 'testng', '6.9.10')")
    }

    @Test // <4>
    public void toolCount() {
        // run
        def actual = sql.firstRow("select count(*) as toolCount from testing_tool")

        // verify
        assertThat(actual.toolCount, is(3L))
    }

    @After // <5>
    public void cleanTable() {
        sql.execute("delete from testing_tool")
    }

    @AfterClass // <6>
    public static void dropTable() {
        sql.execute("drop table testing_tool")
        sql.close()
    }

    // end::structureJUnit[]

    @Test
    public void 'JUnit5 is in game!'() {
        // setup
        sql.execute("insert into testing_tool values (4, 'junit', '5')")

        // run
        def actual = sql.firstRow("select count(*) as toolCount from testing_tool where name = 'junit'")

        // verify
        assertThat(actual.toolCount, is(2L))
    }
}
