package shared

// tag::sharedForSharing[]

class N14S_SharedExplained_Shared_2 extends N14S_SharedExplained_BasicShared {

    def 'shared ArrayList and testng'() {
        when:
        arrayList.add('junit')

        then:
        arrayList.size() == 1
    }
}
// end::sharedForSharing[]
