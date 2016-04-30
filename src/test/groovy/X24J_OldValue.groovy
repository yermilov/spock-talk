import groovy.sql.Sql
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

import static org.hamcrest.Matchers.is
import static org.hamcrest.Matchers.is
import static org.junit.Assert.assertThat
import static org.junit.Assert.assertThat

class X24J_OldValue {

    static Sql sql

    @BeforeClass
    public static void createTable() {
        sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
        sql.execute("create table testing_tool (id int primary key, name varchar(100), version varchar(100))")
    }

    @AfterClass
    public static void dropTable() {
        sql.execute("drop table testing_tool")
    }

    @Before
    public void insertBasicData() {
        sql.execute("insert into testing_tool values (1, 'junit', '4.12'), (2, 'spock', '1.0'), (3, 'testng', '6.9.10')")
    }

    @After
    public void cleanTable() {
        sql.execute("delete from testing_tool")
    }

    @Test
    public void 'modifying data in table'() {
        // run
        def old = sql.firstRow("select count(*) as toolCount from testing_tool").toolCount
        sql.execute("insert into testing_tool values (4, 'junit', '5')")
        def actual = sql.firstRow("select count(*) as toolCount from testing_tool").toolCount

        // verify
        assertThat(actual, is(old + 1))
    }
}
