package matchers;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import utils.Waiter;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class IsElementDisplayedMatcher extends TypeSafeMatcher<WebElement> {

    Duration timeout = Duration.ofSeconds(20);

    @Override
    protected boolean matchesSafely(WebElement element) {
        return Waiter.waitFor(element, timeout, e -> e.isDisplayed());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("element is displayed");
    }

    @Factory
    public static Matcher<WebElement> isDisplayed(){
        return new IsElementDisplayedMatcher();
    }
}
