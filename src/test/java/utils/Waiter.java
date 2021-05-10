package utils;

import org.openqa.selenium.WebElement;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.function.Predicate;

public class Waiter {

    public static <T extends WebElement> boolean waitFor(T element, Duration timeout, Predicate<T> condition) {
        Clock clock = Clock.systemDefaultZone();
        int pollingIntervalInMs = 250;

        Instant end = clock.instant().plus(timeout);
        boolean isReady = false;
        while (clock.instant().compareTo(end) <= 0 && !isReady) {
            try {
                isReady = condition.test(element);
            } catch (Exception ex) {
                try {
                    Thread.sleep(pollingIntervalInMs);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return isReady;
    }

}
