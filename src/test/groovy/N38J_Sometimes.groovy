import org.apache.commons.math3.primes.Primes
import org.junit.Test

import java.util.concurrent.TimeUnit

class N38J_Sometimes {

    @Test
    void iWantToBelieve() {
        // setup
        Integer actual = null

        // run
        asyncNextPrime( 1728, { answer -> actual = answer } )

        // verify
        assert actual == 1733
    }

    @Test
    void hm() {
        // setup
        Integer actual = null

        // run
        asyncNextPrime( 1728, { answer -> actual = answer } )

        // hm
        Thread.sleep(3000)

        // verify
        assert actual == 1733
    }

    @Test(timeout = 3000L)
    void complicatedHm() {
        // setup
        Integer actual = null

        // run
        asyncNextPrime( 1728, { answer -> actual = answer } )

        // hmhm
        while (actual == null) {
            if (actual != null) {
                // verify
                assert actual == 1733
            }
        }
    }

    def asyncNextPrime(int number, Closure callback) {
        new Thread() {
            @Override
            void run() {
                Thread.sleep(TimeUnit.SECONDS.toMillis(new Random().nextInt(5)))
                callback.call(Primes.nextPrime(number))
            }
        }.start()
    }
}
