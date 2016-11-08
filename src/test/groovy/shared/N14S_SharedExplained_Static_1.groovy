package shared

import spock.lang.Stepwise

// tag::staticForSharing[]

@Stepwise
class N14S_SharedExplained_Static_1 extends N14S_SharedExplained_BasicStatic {

    def 'static ArrayList and junit'() {
        when:
        N14S_SharedExplained_BasicStatic.arrayList.add('junit')

        then:
        N14S_SharedExplained_BasicStatic.arrayList.size() == 1
    }

    def 'static ArrayList and spock'() {
        when:
        N14S_SharedExplained_BasicStatic.arrayList.add('spock')

        then:
        N14S_SharedExplained_BasicStatic.arrayList.size() == 2
    }
}
// end::staticForSharing[]
