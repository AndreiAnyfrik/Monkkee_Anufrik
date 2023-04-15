package by.teachmeskills;

import by.teachmeskills.page.DiaryPage;
import by.teachmeskills.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginNegativeTest extends BaseTest {

    @DataProvider
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"", ""},
                {"", "5871839Aa"},
                {"andrei311296@mail.ru", ""}
        };
    }

    @Test(dataProvider = "invalidCredentials")
    public void negativeLog(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open().loginAs(userName, password);
        Assert.assertFalse(loginPage.isErrorDisplayed(), "Error message is not displayed after invalid data");
    }
}