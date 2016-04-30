import spock.lang.*

@Title('Spock conditional runs')
@Narrative('''
As JEEConf speaker
I want to show how great Spock conditional runs are
''')
class X29S_ConditionalRuns_Part1 extends Specification {

    @Ignore('will fix it before commit')
    def 'this test is always ignored'() {
        // TODO FIXME test is failing
        expect: 'that 2+2=5'
        2 + 2 == 5
    }

    @IgnoreIf({ os.windows })
    def 'this test is ignored on Windows'() {
        expect: 'that we are on Linux'
        !System.properties['os.name'].toString().toLowerCase().contains('windows')
    }

    @Requires({ jvm.java8 })
    def 'this test requires Java 8'() {
        expect: 'that we are on Java 8'
        'java -version'.execute().errorStream.text.contains('java version "1.8.0_73"')
    }

    @IgnoreIf({ new Random().nextBoolean() })
    def 'this test is SOMETIMES ignored'() {
        when: 'i hate my job'
        Integer.metaClass.plus = { Integer other ->
            return 5
        }

        then: 'i can make them pay'
        2 + 2 == 5
    }
}