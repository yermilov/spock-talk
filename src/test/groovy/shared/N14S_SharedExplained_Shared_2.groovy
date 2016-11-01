package shared

/**
 * Created by yermi on 01.11.2016.
 */
class N14S_SharedExplained_Shared_2 extends N14S_SharedExplained_BasicShared {

    def 'shared ArrayList and testng'() {
        when:
        arrayList.add('junit')

        then:
        arrayList.size() == 1
    }
}
