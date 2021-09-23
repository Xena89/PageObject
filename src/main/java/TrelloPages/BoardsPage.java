package TrelloPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BoardsPage extends BaseView {
    public BoardsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-test-id = 'header-create-menu-button']")
    public WebElement createButton;

    @FindBy(xpath = "//button/span[text()='Создайте доску']")
    public WebElement createNewBoardButton;

    @FindBy(xpath = "//input[@placeholder='Добавить заголовок доски']")
    public WebElement newBoardTitle;

    @FindBy(xpath = "//button[text()='Создать доску']")
    public WebElement saveNewBoardButton;

    @Step("Нажать на кнопку Создать")
    public BoardsPage createNewClick() {
        createButton.click();
        return this;
    }

    @Step("Выбрать пункт Создать новую доску")
    public BoardsPage createNewBoardClick() {
        createNewBoardButton.click();
        return this;
    }

    @Step("Ввести название новой доски")
    public BoardsPage fillNewBoardTitle(String title) {
        newBoardTitle.sendKeys(title);
        return this;
    }

    @Step("Нажать на кнопку сохнанить новую доску")
    public BoardsPage saveNewBoardButtonClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(saveNewBoardButton));
        saveNewBoardButton.click();
        return this;
    }

}
