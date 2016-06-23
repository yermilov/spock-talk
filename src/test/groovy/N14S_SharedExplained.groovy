import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

// tag::sharedForSharing[]

class N14S_SharedExplained_BasicShared extends Specification {

    @Shared arrayList = new ArrayList<String>()
}

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

class N14S_SharedExplained_Shared_2 extends N14S_SharedExplained_BasicShared {

    def 'shared ArrayList and testng'() {
        when:
        arrayList.add('junit')

        then:
        arrayList.size() == 1
    }
}

// end::sharedForSharing[]

// tag::staticForSharing[]

class N14S_SharedExplained_BasicStatic extends Specification {

    static List arrayList = new ArrayList<String>()
}

@Stepwise
class N14S_SharedExplained_Static_1 extends N14S_SharedExplained_BasicStatic {

    def 'static ArrayList and junit'() {
        when:
        arrayList.add('junit')

        then:
        arrayList.size() == 1
    }

    def 'static ArrayList and spock'() {
        when:
        arrayList.add('spock')

        then:
        arrayList.size() == 2
    }
}

class N14S_SharedExplained_Static_2 extends N14S_SharedExplained_BasicStatic {

    def 'static ArrayList and testng'() {
        when:
        arrayList.add('junit')

        then:
        arrayList.size() == 1
    }
}

// end::staticForSharing[]
