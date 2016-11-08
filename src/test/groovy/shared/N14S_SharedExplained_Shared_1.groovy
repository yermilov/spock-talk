package shared

import spock.lang.Stepwise

// tag::sharedForSharing[]

@Stepwise
class N14S_SharedExplained_Shared_1 extends N14S_SharedExplained_BasicShared {

    def 'shared ArrayList and junit'() {
        when:
        arrayList.add('junit')

        then:
        arrayList.size() == 1
    }

    def 'shared ArrayList and spock'() {
        when:
        arrayList.add('spock')

        then:
        arrayList.size() == 2
    }
}
// end::sharedForSharing[]
