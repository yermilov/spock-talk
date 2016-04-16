import spock.lang.*

class N11_ConditionalRuns extends Specification {

    @Ignore
    def 'this test is ignored'() {
        setup:
            def arrayList = new ArrayList<String>()

        when:
            arrayList.add('junit')
            arrayList.add('spock')

        then:
            arrayList == [ 'spock', 'only', '!' ]
    }

    @IgnoreIf({ new Random().nextBoolean()})
    def 'this test is SOMETIMES ignored'() {
        setup:
            def arrayList = new ArrayList<String>()

        when:
            arrayList.add('junit')
            arrayList.add('spock')

        then:
            arrayList == [ 'spock', 'only', '!' ]
    }

    @IgnoreIf({ os.windows || os.linux })
    def 'this test is ignored on Windows or Linux (no Mac :D)'() {
        setup:
            def arrayList = new ArrayList<String>()

        when:
            arrayList.add('junit')
            arrayList.add('spock')

        then:
            arrayList == [ 'spock', 'only', '!' ]
    }

    @Requires({ jvm.java8 })
    def 'this test requires Java 8'() {
        setup:
            def arrayList = new ArrayList<String>()

        when:
            arrayList.add('junit')
            arrayList.add('spock')

        then:
            arrayList == [ 'spock', 'only', '!' ]
    }
}