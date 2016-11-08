package shared

import spock.lang.Specification

// tag::staticForSharing[]
class N14S_SharedExplained_BasicStatic extends Specification {

    static List arrayList = new ArrayList<String>()
}
// end::staticForSharing[]
