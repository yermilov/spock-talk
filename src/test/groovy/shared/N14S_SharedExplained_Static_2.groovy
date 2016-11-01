package shared

class N14S_SharedExplained_Static_2 extends N14S_SharedExplained_BasicStatic {

    def 'static ArrayList and testng'() {
        when:
        N14S_SharedExplained_BasicStatic.arrayList.add('junit')

        then:
        N14S_SharedExplained_BasicStatic.arrayList.size() == 1
    }
}
