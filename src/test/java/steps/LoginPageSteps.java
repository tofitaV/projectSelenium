package steps;

import dataProvider.Users;
import io.qameta.allure.Step;
import io.qameta.htmlelements.element.HtmlElement;
import org.openqa.selenium.WebDriver;
import properties.Properties;
import pages.LoginPage;
import steps.common.BaseSteps;

import static matchers.IsElementDisplayedMatcher.isDisplayed;

public class LoginPageSteps extends BaseSteps {

    private final String loginPageUrl = Properties.props.url();

    public String getLoginPageUrl() {
        return loginPageUrl;
    }

    public LoginPageSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public LoginPageSteps clickOnTheSignInButton(){
        HtmlElement signInButton = onLoginPage().signInButton().should(isDisplayed());
        signInButton.click();
        return this;
    }

    @Step
    public LoginPageSteps enterLogin(String login) {
        HtmlElement loginField = onLoginPage().loginField().should(isDisplayed());
        loginField.click();
        loginField.sendKeys(login);
        return this;
    }

    @Step
    public LoginPageSteps enterPassword(String password) {
        HtmlElement passwordField = onLoginPage().passwordField().should(isDisplayed());
        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }

    @Step
    public LoginPageSteps clickOnTheAuthButton() {
        onLoginPage().authButton().should(isDisplayed()).click();
        return new LoginPageSteps(driver);
    }

    @Step
    public LoginPageSteps loginAs(Users user) {
        clickOnTheSignInButton();
        enterLogin(user.getLogin());
        enterPassword(user.getPassword());
        return clickOnTheAuthButton();
    }

    public LoginPage onLoginPage() {
        return on(LoginPage.class);
    }
}
