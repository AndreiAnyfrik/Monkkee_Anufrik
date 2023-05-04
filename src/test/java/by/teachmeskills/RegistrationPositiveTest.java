package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.RegistrationPage;
import by.teachmeskills.page.SuccessfulRegistrationPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationPositiveTest extends BaseTest {

    @Test
    public void registrationWithRequiredFields() {
        RegistrationPage registrationPage = new LoginPage(driver).open().openedRegistrationForm();
        assertThat(registrationPage.isOpened()).isTrue().as("RegistrationPage don't opened");
        SuccessfulRegistrationPage registration = new RegistrationPage(driver).getRegistration();
        assertThat(registration.isOpened()).isTrue().as("SuccessfulRegistrationPage has not been opened");
    }
}
