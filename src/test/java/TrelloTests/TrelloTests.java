package TrelloTests;

import TrelloPages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
                .fillNewBoardTitle("New Board 100500")
                .saveNewBoardButtonClick();

        assertTrue(driver.getCurrentUrl().contains("/boards"));

    }
}
