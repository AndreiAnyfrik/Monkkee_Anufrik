package by.teachmeskills;

import by.teachmeskills.page.DiaryPage;
import by.teachmeskills.page.LoginPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogoutTest extends BaseTest {

    @Test
    public void logout() {
        new LoginPage(driver).open().loginAsStandardUser();
        LoginPage loginPage = new DiaryPage(driver).logOut();
        assertThat(loginPage.isOpened()).isTrue().as("Login Page has not been displayed after log out");
    }
}
