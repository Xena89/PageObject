package CrmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CreateContactPersonPage extends BaseView {
    public CreateContactPersonPage(WebDriver driver) {
        super(driver);
    }

    public static final String searchOrganizationXpath = "//div[@class='select2-result-label']";
    public static final String saveAndCloseButtonXpath = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_lastName')]")
    public WebElement contactLastName;

    public CreateContactPersonPage fillContactLastName(String lastName) {
        contactLastName.sendKeys(lastName);
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_firstName')]")
    public WebElement contactFirstName;

    public CreateContactPersonPage fillContactFirstName(String firstName) {
        contactFirstName.sendKeys(firstName);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement specifyOrganization;

    public CreateContactPersonPage selectOrganization() {
        specifyOrganization.click();
        return this;
    }

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement searchOrganization;

    public CreateContactPersonPage fillOrganization(String name) {
        searchOrganization.sendKeys(name);
        return this;
    }

    @FindBy(xpath = searchOrganizationXpath)
    public List<WebElement> organizationVars;

    public CreateContactPersonPage optionOrganization() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchOrganizationXpath)));
        organizationVars.get(0).click();
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_jobTitle')]")
    public WebElement contactJobTitle;

    public CreateContactPersonPage fillContactJobTitle(String jobTitle) {
        contactJobTitle.sendKeys(jobTitle);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = "//*[text()='Контактное лицо сохранено']")
    public WebElement contactSavedSuccessfullyText;
}
