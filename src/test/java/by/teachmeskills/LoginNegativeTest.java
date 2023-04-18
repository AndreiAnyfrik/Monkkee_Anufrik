package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void invalidUserName() {
        String expError = "Login failed";
        String errorAfterInvalidUserNameAndInvalidPassword = new LoginPage(driver).open().loginWithInvalidUserNameAndInvalidPassword()
                .getErrorAfterInvalidUserNameAndInvalidPassword();
        assertThat(errorAfterInvalidUserNameAndInvalidPassword)
                .isEqualTo(expError).as("Error message is not displayed after invalid data");
    }

    @Test
    public void emptyPassword() {
        String expError = "Mandatory field";
        String errorAfterEmptyPassword = new LoginPage(driver).open().loginWithEmptyPassword()
                .getErrorAfterEmptyPassword();
        assertThat(errorAfterEmptyPassword)
                .isEqualTo(expError).as("Error message is not displayed after invalid data");
    }

    @Test
    public void emptyAllFields() {
        String expError = "Mandatory field";
        String errorAfterEmptyPassword = new LoginPage(driver).open().loginWithAllEmptyFields().getErrorAfterEmptyPassword();
        assertThat(errorAfterEmptyPassword)
                .isEqualTo(expError).as("Error message is not displayed after invalid data");
        String errorAfterEmptyPassword1 = new LoginPage(driver).getErrorAfterEmptyLogin();
        assertThat(errorAfterEmptyPassword1)
                .isEqualTo(expError).as("Error message is not displayed after invalid data");
    }

}