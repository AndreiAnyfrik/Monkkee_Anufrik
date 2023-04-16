package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.RegistrationPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationNegativeTest extends BaseTest {

    @DataProvider
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"asdasd", "5871839Aa", "5871839Aa"},
                {"", "5871839Aa", ""},
                {"", "5871839Aa", "5871839Aa"},
                {"andrei3112@mail.ru", "654654545", "31231232312"}
        };
    }

    @Test(dataProvider = "invalidCredentials")
    public void negativeLog(String email, String password, String confirmPassword) {
        new LoginPage(driver).open().openedRegistrationForm();
        RegistrationPage registrationPage = new RegistrationPage(driver)
                                            .registerWithAllFields(email, password, confirmPassword);
       // Assert.assertTrue(registrationPage.isErrorDisplayed(), "Error message is not displayed after invalid data");
        assertThat(registrationPage.isErrorDisplayed())
                  .isTrue().as("Error message is not displayed after invalid data");
    }
}

