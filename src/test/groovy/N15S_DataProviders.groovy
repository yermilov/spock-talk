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

    @Unroll
    def 'calculate runner speed and location after some time for #description'() {
        expect: 'that runner speed is equal to expected'
        initialSpeed + acceleration * time == expectedSpeed

        and: 'runner location is equal to expected'
        initialLocation + time * (initialSpeed + acceleration / 2 * time) == expectedLocation

        where: 'there are set of precalculated data for different situations'
        initialLocation | initialSpeed | acceleration | time || expectedLocation | expectedSpeed || description
        0               | 6            | 0            | 10   || 60               | 6             || 'steady run from starting point'
        5               | 0            | 3            | 3    || 17               | 9             || 'starting from standing with acceleration'
        -50             | 10           | -1           | 10   || 0                | 0             || 'constant deceleration'
    }

    def 'is coin flip good enough for determine if integer is prime'() {
        when: 'we flip a coin'
        boolean coinFlip = new Random().nextBoolean()

        then: 'it will be great if coin flip predict if number is prime'
        coinFlip == Primes.isPrime(number)

        where: 'data is random'
        number << (1..5).collect({ new Random().nextInt(1000) }).findAll({ it >= 2 }).sort()
    }
}