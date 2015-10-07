import spock.lang.*

class N03_Fixture extends Specification {

    @Shared
    def arrayList

    def setupSpec() {
        arrayList = new ArrayList<String>()
    }

    def setup() {
        arrayList.clear()
    }

    def cleanup() {
        arrayList.clear()
    }

    def cleanupSpec() {
        arrayList = null
    }

    def 'ArrayList works :|'() {
        when:
            arrayList.add("junit")
            arrayList.add("spock")

        then:
            arrayList == [ "junit", "spock" ]
    }

    def 'empty ArrayList works as well!'() {
        expect:
            arrayList.size() == 0
    }
}
