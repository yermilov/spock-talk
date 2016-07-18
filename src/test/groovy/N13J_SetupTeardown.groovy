import groovy.sql.Sql;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by yermi on 30.04.2016.
 */
public class N13J_SetupTeardown {

    static Sql sql

    @BeforeClass
    public static void createTable() {
        sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
        sql.execute("create table testing_tool (id int primary key, name varchar(100), version varchar(100))")
    }

    @Test
    void 'JUnit5 is in game!'() {
        try {
            // setup
            sql.execute("insert into testing_tool values (4, 'junit', '5')")

            // run
            def actual = sql.firstRow("select count(*) as toolCount from testing_tool where name = 'junit'")

            // verify
            actual.toolCount == 2
        } finally {
            try {
                // cleanup
                sql.execute("delete from testing_tool where id = 4")
            } finally {
                sql.close()
            }
        }
    }
}
