import spock.lang.*

class N05_SpecificationAsItIs extends Specification {

    def 'ArrayList works :()'() {
        given: 'empty list'
            def arrayList = new ArrayList<String>()

        when: 'we add element'
            arrayList.add('junit')

        and: 'add one more element'
            arrayList.add('spock')

        then: 'we expect that array will be of size 2'
            arrayList.size() == 2
    }
}