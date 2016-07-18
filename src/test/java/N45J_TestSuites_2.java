import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// tag::testSuite[]
@RunWith(Categories.class)
@Categories.IncludeCategory(Fast.class) // <2>
@Suite.SuiteClasses(N45J_TestSuites_1.class)
public class N45J_TestSuites_2 {}
// end::testSuite[]
