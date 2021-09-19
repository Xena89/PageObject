package CrmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CountSubMenu extends BaseView {

    public CountSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()=\"Контактные лица\"]")
    public WebElement countMenuItem;

    public void goToAllContactsPage() {
        countMenuItem.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(ContactPersonAllPage.createContactXpath)));
    }
}
