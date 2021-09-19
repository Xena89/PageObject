package CrmTests;

import CrmPages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CrmTests extends BeforeAndAfterActions{

    @Test
    @DisplayName("Тест логина и создания нового проекта")
    void loginCrmAndCreateProjectPageObjectTest() {
        driver.get("https://crm.geekbrains.space/");
        new LoginPageCrm(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Проекты");

        new ProjectsSubMenu(driver).goToProjectsAllPage();

        new ProjectAllPage(driver)
                .createProject()
                .fillName("12dsfsdfddываыва34554321тест")
                .selectOrganization()
                .fillOrganization("Все организации")
                .optionOrganization()
                .selectProjectBusinessUnit("Research & Development")
                .selectProjectCurator("Applanatest Applanatest Applanatest")
                .selectProjectRp("Applanatest1 Applanatest1 Applanatest1")
                .selectProjectAdministrator("Applanatest1 Applanatest1 Applanatest1")
                .selectProjectManager("Applanatest1 Applanatest1 Applanatest1")
                .buttonSaveAndClose.click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(text(),'Загрузка')]")));

        assertThat(new CreateProjectPage(driver).newProjectSavedSuccesfully, isDisplayed());
    }

    @Test
    @DisplayName("Тест создание контактного лица")
    void loginInCrmAndCreateContactPageObjectTest() {
        driver.get("https://crm.geekbrains.space/");
        new LoginPageCrm(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Контрагенты");

        new CountSubMenu(driver).goToAllContactsPage();

        new ContactPersonAllPage(driver)
                .createContact()
                .fillContactLastName("Парамонов")
                .fillContactFirstName("Парамон")
                .selectOrganization()
                .fillOrganization("Все организации")
                .optionOrganization()
                .fillContactJobTitle("developer")
                .saveAndCloseButton.click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(text(),'Загрузка')]")));

        assertThat(new CreateContactPersonPage(driver).contactSavedSuccessfullyText, isDisplayed());
    }
}
