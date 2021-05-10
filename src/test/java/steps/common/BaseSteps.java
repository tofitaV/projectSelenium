package steps.common;
import com.google.inject.Inject;

import io.qameta.allure.Step;
import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;
import org.openqa.selenium.WebDriver;
import steps.LoginPageSteps;

import java.sql.Connection;

public class BaseSteps {
    protected WebDriver driver;

    @Inject
    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    protected <T extends WebPage> T on(Class<T> pageClass) {
        return new WebPageFactory().get(driver, pageClass);
    }

    @Step
    public LoginPageSteps openLoginPage() {
        LoginPageSteps loginPageSteps = new LoginPageSteps(driver);
        driver.get(loginPageSteps.getLoginPageUrl());
        return loginPageSteps;
    }


}
