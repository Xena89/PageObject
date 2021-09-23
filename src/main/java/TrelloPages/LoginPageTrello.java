package TrelloPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageTrello extends BaseView {

    public LoginPageTrello(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='user']")
    public WebElement inputLogin;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[contains(@value, 'Atlassian')]")
    public WebElement loginAtlassianIsVisible;

    @FindBy(xpath = "//button[contains(@id,'login-submit')]")
    public WebElement loginButton;

    @Step("Заполнить поле логин")
    public LoginPageTrello fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле пароль")
    public LoginPageTrello fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Нажать на кнопку логин с Атлассиан")
    public LoginPageTrello loginWithAtlassianClick() {
        loginAtlassianIsVisible.click();
        return this;
    }

    @Step("Нажать на кнопку логин")
    public LoginPageTrello clickLoginButton() {
        loginButton.click();
        return new LoginPageTrello(driver);
    }

}
