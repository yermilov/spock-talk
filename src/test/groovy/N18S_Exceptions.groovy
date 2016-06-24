import org.apache.commons.math3.primes.Primes
import spock.lang.*

@Title('Spock exceptions')
@Narrative('''
As JEEConf speaker
I want to show how great Spock exceptions catching is
''')
class N18S_Exceptions extends Specification {

    // tag::expectException[]

    def 'empty ArrayList has no 17th element'() {
        given: 'empty array list'
        def arrayList = new ArrayList<Integer>()

        when: 'we try to retrieve element with index #17'
        arrayList.get(17)

        then: 'exception is thrown with expected message'
        IndexOutOfBoundsException exception = thrown()
        exception.message == 'Index: 17, Size: 0'
    }

    // end::expectException[]

    // tag::notExpectException[]

    def 'large ArrayList has 17th element'() {
        given: 'list of 28 prime numbers'
        def arrayList = new ArrayList<Integer>()
        28.times { arrayList << Primes.nextPrime(arrayList.empty ? 1 : arrayList[-1]) }

        when: 'we try to retrieve element with index #17'
        arrayList.get(17)

        then: 'no exception is thrown'
        notThrown(IndexOutOfBoundsException)
    }

    // end::notExpectException[]
}
