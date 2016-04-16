import spock.lang.*

class X14_AutoCleanup extends Specification {

    @AutoCleanup('clear')
    def cleanMeUp = new Expando(clear: { println 'CLEANED!' })

    def 'ArrayList works :|'() {
        given:
            def arrayList = new ArrayList<String>()

        when:
            arrayList.add('junit')
            arrayList.add('spock')

        then:
            !arrayList.empty
            arrayList.size() == 2
            arrayList == [ 'junit', 'spock' ]
    }
}
