package shared

import spock.lang.Shared
import spock.lang.Specification

// tag::sharedForSharing[]
class N14S_SharedExplained_BasicShared extends Specification {

    @Shared
            arrayList = new ArrayList<String>()
}
// end::sharedForSharing[]
