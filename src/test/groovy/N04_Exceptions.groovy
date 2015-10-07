import spock.lang.*

class N04_Exceptions extends Specification {

    def 'empty ArrayList has no 17th element'() {
        given:
            def arrayList = new ArrayList<String>()

        when:
            arrayList.get(17)

        then:
           IndexOutOfBoundsException exception = thrown()
           exception.message == 'Index: 17, Size: 0'
    }

    def 'large ArrayList has 17th element'() {
        given:
            def arrayList = new ArrayList<String>()
            28.times { arrayList << 'why 17?' }

        when:
            arrayList.get(17)

        then:
            notThrown(IndexOutOfBoundsException)
    }
}
