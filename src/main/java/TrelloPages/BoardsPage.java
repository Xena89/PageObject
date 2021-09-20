package TrelloPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BoardsPage extends BaseView{
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


    public BoardsPage createNewClick() {
        createButton.click();
        return this;
    }
    public BoardsPage createNewBoardClick() {
        createNewBoardButton.click();
        return this;
    }

    public BoardsPage fillNewBoardTitle(String title) {
        newBoardTitle.sendKeys(title);
        return this;
    }

    public BoardsPage saveNewBoardButtonClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(saveNewBoardButton));
        saveNewBoardButton.click();
        return this;
    }

}
