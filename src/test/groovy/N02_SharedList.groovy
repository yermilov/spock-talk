import spock.lang.*

class N02_SharedList extends Specification {

    @Shared
    def arrayList = new ArrayList<String>()

    def arrayListWorks() {
        when:
            arrayList.add("junit")
            arrayList.add("spock")

        then:
            arrayList == [ "junit", "spock" ]

        cleanup:
            arrayList.clear()
    }

    def "empty ArrayList works as well!"() {
        expect:
            arrayList.size() == 0
    }
}
