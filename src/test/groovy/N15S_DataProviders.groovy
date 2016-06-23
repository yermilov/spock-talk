import org.apache.commons.math3.primes.Primes
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title
import spock.lang.Unroll

@Title('Spock data tables')
@Narrative('''
As JEEConf speaker
I want to show how great Spock data tables are
''')
class N15S_DataProviders extends Specification {

    // tag::dividualTests[]

    @Unroll // <1>
    def 'calculate runner speed and location after some time for #description'() { // <2>
        expect: 'that runner speed is equal to expected'
        speed0 + accl * time == speed1

        and: 'runner location is equal to expected'
        coord0 + time * (speed0 + accl / 2 * time) == coord1

        where: 'there are set of precalculated data for different situations' // <3>
        coord0 | speed0 | accl | time || coord1 | speed1 || description
        0      | 6      | 0    | 10   || 60     | 6      || 'steady run from starting point'
        5      | 0      | 3    | 3    || 17     | 9      || 'start from still with acceleration'
        -50    | 10     | -1   | 10   || 0      | 0      || 'constant deceleration'
    }

    // end::dividualTests[]

    // tag::complexTest[]

    def 'is coin flip good enough for determine if integer is prime'() {
        when: 'we flip a coin'
        boolean coinFlip = new Random().nextBoolean()

        then: 'it will be great if coin flip predict if number is prime'
        (number % 2 == 0 ? false : coinFlip) == expectedAnswer // <4>

        where: 'data is random' // <1>
        number << (1..5).collect({ new Random().nextInt(1000) }).findAll({ it >= 2 }).sort() // <2>
        expectedAnswer = Primes.isPrime(number) // <3>
    }

    // end::complexTest[]
}
