import groovy.lang.Closure;
import org.apache.commons.math3.primes.Primes;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by yermi on 23.04.2016.
 */
public class X28J_Sometimes {

    @Test(timeout = 10000)
    public void findNextPrimeEventually() throws ExecutionException, InterruptedException {
        // run
        Future<Integer> actual = asyncNextPrime(1728);

        // verify
        while (!actual.isDone()) {
            if (actual.isDone()) {
                assertThat(actual.get(), is(1733));
            }
        }
    }

    static Future<Integer> asyncNextPrime(final int number) {
        return Executors.newSingleThreadExecutor().submit(() -> {
            Thread.sleep(TimeUnit.SECONDS.toMillis(new Random().nextInt(5)));
            return Primes.nextPrime(number);
        });
    }
}
