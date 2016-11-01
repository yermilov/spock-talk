import spock.lang.*

@Title('Spock conditional runs')
@Narrative('''
As JEEConf speaker
I want to show how great Spock conditional runs are
''')
class N39S_ConditionalRuns_Part1 extends Specification {

    // tag::ignore[]
    @Ignore('will fix it before commit')
    def 'this test is always ignored'() {
        // TODO FIXME test is failing
        expect: 'that 2+2=5'
        2 + 2 == 5
    }
    // end::ignore[]

    // tag::conditionalIgnore[]
    @IgnoreIf({ os.windows || sys['pretend.os'] == 'windows' })
    def 'this test is ignored on Windows'() {
        expect: 'that we are not on Windows'
        !System.properties['os.name'].toString().toLowerCase().contains('windows')
    }

    @Requires({ jvm.java8 && env['JAVA_HOME'] != null })
    def 'this test requires JAVA_HOME set and Java 8 installed'() {
        expect: 'that we are on Java 8'
        'java -version'.execute().errorStream.text.contains('java version "1.8.0_101"')
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
    // end::conditionalIgnore[]

    // tag::pendingFeature[]
    @PendingFeature
    def 'this test is passing'() {
        expect: 'that 2*2=4'
        2 * 2 == 4
    }

    @PendingFeature
    def 'this test is failing'() {
        expect: 'that 2*2=5'
        2 * 2 == 5
    }
    // end::pendingFeature[]
}
