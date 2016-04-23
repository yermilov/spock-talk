import spock.lang.*

@Title('Spock conditional runs')
@Narrative('''
As JEEConf speaker
I want to show how great Spock conditional runs are
''')
class X11_ConditionalRuns extends Specification {

    //@IgnoreRest

    @Ignore
    def 'this test is always ignored'() {
        expect: 'that 2+2=5'
        2 + 2 == 5
    }

    @IgnoreIf({ os.windows || os.linux })
    def 'this test is ignored on Windows or Linux'() {
        expect: 'that we are on Mac'
        'current OS' == 'OS X'
    }

    @Requires({ jvm.java8 })
    def 'this test requires Java 8'() {
        when:
        def process = 'java -version'.execute()

        then: 'that we are on Java 8'
        process.errorStream.text.contains('java version "1.8.0_73"')
    }

    @IgnoreIf({ new Random().nextBoolean() })
    def 'this test is SOMETIMES ignored'() {
        setup:
            def arrayList = new ArrayList<String>()

        when:
            arrayList.add('junit')
            arrayList.add('spock')

        then:
            arrayList == [ 'spock', 'only', '!' ]
    }
}