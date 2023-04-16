package by.teachmeskills;

import by.teachmeskills.page.*;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FunctionalTest extends BaseTest {

    @Test
    public void checkDonates() {
        DonatePage donate = new LoginPage(driver).open().donate();
        assertThat(donate.isOpened()).isTrue().as("Donate Page has not been opened");
    }

    @Test
    public void changeLanguageDE() {
        DEPage dePage = new LoginPage(driver).open().changeDELanguage();
        assertThat(dePage.isOpened()).isTrue().as("DE Page has not been opened");
    }

    @Test
    public void changeLanguageFR() {
        FRPage frPage = new LoginPage(driver).open().changeFRLanguage();
        assertThat(frPage.isOpened()).isTrue().as("FR Page has not been opened");
    }

    @Test
    public void changeLanguagePT() {
        PTPage ptPage = new LoginPage(driver).open().changePTLanguage();
        assertThat(ptPage.isOpened()).isTrue().as("PT Page has not been opened");
    }
}
