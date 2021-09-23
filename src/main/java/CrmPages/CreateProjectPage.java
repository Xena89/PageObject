package CrmPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateProjectPage extends BaseView {
    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    public static final String searchOrganizationXpath = "//div[@class='select2-result-label']";
    public static final String saveAndCloseButtonXpath = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(name = "crm_project[name]")
    public WebElement nameProject;

    @Step("Ввести название нового проекта")
    public CreateProjectPage fillName(String name) {
        nameProject.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement specifyOrganization;

    @Step("Выбрать название организации")
    public CreateProjectPage selectOrganization() {
        specifyOrganization.click();
        return this;
    }

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement searchOrganization;

    @Step("Ввести название организации")
    public CreateProjectPage fillOrganization(String name) {
        searchOrganization.sendKeys(name);
        return this;
    }

    @FindBy(xpath = searchOrganizationXpath)
    public List<WebElement> organizationVars;

    @Step("Выбрать элемент списка Все организации")
    public CreateProjectPage optionOrganization() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchOrganizationXpath)));
        organizationVars.get(0).click();
        return this;
    }

    @FindBy(xpath = "//select[contains(@id,'crm_project_businessUnit')]")
    public WebElement projectBusinessUnitSelect;

    @Step("Выбрать подразделение")
    public CreateProjectPage selectProjectBusinessUnit(String projectBusinessUnit) {
        new Select(projectBusinessUnitSelect).selectByVisibleText(projectBusinessUnit);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id,'crm_project_curator')]")
    public WebElement projectCuratorSelect;

    @Step("Выбрать куратора проекта")
    public CreateProjectPage selectProjectCurator(String projectCurator) {
        new Select(projectCuratorSelect).selectByVisibleText(projectCurator);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id,'crm_project_rp')]")
    public WebElement projectRpSelect;

    @Step("Выбрать руководителя проекта")
    public CreateProjectPage selectProjectRp(String projectRp) {
        new Select(projectRpSelect).selectByVisibleText(projectRp);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id,'crm_project_administrator')]")
    public WebElement projectAdministratorSelect;

    @Step("Выбрать администратора проекта")
    public CreateProjectPage selectProjectAdministrator(String projectAdministrator) {
        new Select(projectAdministratorSelect).selectByVisibleText(projectAdministrator);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id, 'crm_project_manager')]")
    public WebElement projectManagerSelect;

    @Step("Выбрать менеджера проекта")
    public CreateProjectPage selectProjectManager(String projectManager) {
        new Select(projectManagerSelect).selectByVisibleText(projectManager);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    public WebElement buttonSaveAndClose;

    @FindBy(xpath = "//*[text()='Проект сохранен']")
    public WebElement newProjectSavedSuccesfully;
}
