import spock.lang.*

class N02_SharedList extends Specification {

    @Shared
    def arrayList = new ArrayList<String>()

    def 'ArrayList works :|'() {
        when:
            arrayList.add('junit')
            arrayList.add('spock')

        then:
            !arrayList.empty
            arrayList.size() == 2
            arrayList == [ 'junit', 'spock' ]

        cleanup:
            arrayList.clear()
    }

    def 'empty ArrayList works as well!'() {
        expect:
            arrayList.size() == 0
    }
}
