import spock.lang.*

@Stepwise
class X13_Stepwise extends Specification {

    @Shared
    def arrayList = new ArrayList<String>()

    def 'empty ArrayList works'() {
        expect:
            arrayList.size() == 0
    }

    def 'ArrayList works'() {
        when:
            arrayList.add('junit')
            arrayList.add('spock')

        then:
            !arrayList.empty
            arrayList.size() == 2
            arrayList == [ 'junit', 'spock' ]
    }
}
