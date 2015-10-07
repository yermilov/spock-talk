import spock.lang.*

class N01_HelloSpock extends Specification {

    def arrayListWorks() {
        given:
            def arrayList = new ArrayList<String>()

        when:
            arrayList.add('junit')
            arrayList.add('spock')

        then:
            arrayList == [ 'junit', 'spock' ]
    }

    def 'empty ArrayList works as well!'() {
        given:
            def arrayList = new ArrayList<String>()

        expect:
            arrayList.size() == 0
    }

    def 'Groovy assertion originates from Spock'() {
        given:
            def arrayList = new ArrayList<String>()

        when:
            arrayList.add('junit')
            arrayList.add('spock')

        then:
            arrayList == [ 'spock', 'only', '!' ]
    }
}