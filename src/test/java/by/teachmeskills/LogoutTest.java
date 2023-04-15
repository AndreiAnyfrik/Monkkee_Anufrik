package by.teachmeskills;

import by.teachmeskills.page.DiaryPage;
import by.teachmeskills.page.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void logout() {
        new LoginPage(driver).open().loginAsStandardUser();
        LoginPage loginPage = new DiaryPage(driver).logOut();
        Assertions.assertThat(loginPage.isOpened()).isTrue().as("Login page is not displayed after log out");
    }
}
