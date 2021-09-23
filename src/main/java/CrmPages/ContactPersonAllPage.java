package CrmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.qameta.allure.Step;

public class ContactPersonAllPage extends BaseView {
    public ContactPersonAllPage(WebDriver driver) {
        super(driver);
    }

    public static final String createContactXpath = "//*[text()=\"Создать контактное лицо\"]";

    @FindBy(xpath = createContactXpath)
    public WebElement createContactButton;

    @Step("Нажать на кнопку Создать контакт")
    public CreateContactPersonPage createContact() {
        createContactButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(CreateContactPersonPage.saveAndCloseButtonXpath)));
        return new CreateContactPersonPage(driver);
    }
}
