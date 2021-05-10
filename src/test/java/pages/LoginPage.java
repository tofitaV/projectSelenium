package pages;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;
import io.qameta.htmlelements.extension.page.BaseUrl;

@BaseUrl("/ru")
public interface LoginPage extends BasePage{

    @FindBy("//a[@id='main-sign-in-btn']")
    HtmlElement signInButton();

    @FindBy("//input[@id='authLoginInput']")
    HtmlElement loginField();

    @FindBy("//input[@id='authPassInput']")
    HtmlElement passwordField();

    @FindBy("//button[@id='authBtn']")
    HtmlElement authButton();
}
