package TrelloPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageTrello extends BaseView{

    public LoginPageTrello(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='user']")
    public WebElement inputLogin;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginAtlassian;

    @FindBy(xpath = "//button[contains(@id,'login-submit')]")
    public WebElement loginButton;


    public LoginPageTrello fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPageTrello fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPageTrello ClickFieldAtlassian(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login']"))).click();
        return this;
    }
    public LoginPageTrello clickLoginButton() {
        loginButton.click();
        return new LoginPageTrello(driver);
    }

}
