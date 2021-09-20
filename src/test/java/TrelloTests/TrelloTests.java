package TrelloTests;

import TrelloPages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

import CrmPages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class TrelloTests extends BeforeAndAfterActions {
    @Test
    @DisplayName("Тест логина и создания новой доски")
    void loginTrelloAndCreateNewBoardTest() {
        driver.get("https://trello.com/ru/login");
        driver.manage().window().maximize();
        new LoginPageTrello(driver)
                .fillInputLogin("quickusja89@hotmail.com")
                .loginWithAtlassianClick()
                .fillInputPassword("100989quick")
                .clickLoginButton();
        new BoardsPage(driver)
                .createNewClick()
                .createNewBoardClick()
                .fillNewBoardTitle("New Board 100500");

    }
}
