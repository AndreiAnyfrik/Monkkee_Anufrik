package by.teachmeskills;

import by.teachmeskills.page.*;
import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class FunctionalTest extends BaseTest {

    @Test
    public void checkDonates() {
        DonatePage donate = new LoginPage(driver).open().donate();
        Assertions.assertThat(donate.isOpened()).isTrue().as("Donate page don't opened");
    }

    @Test
    public void changeLanguageDE() {
        DEPage dePage = new LoginPage(driver).open().changeDELanguage();
        Assertions.assertThat(dePage.isOpened()).isTrue().as("DE page don't opened");
    }

    @Test
    public void changeLanguageFR() {
        FRPage frPage = new LoginPage(driver).open().changeFRLanguage();
        Assertions.assertThat(frPage.isOpened()).isTrue().as("DE page don't opened");
    }

    @Test
    public void changeLanguagePT() {
        PTPage ptPage = new LoginPage(driver).open().changePTLanguage();
        Assertions.assertThat(ptPage.isOpened()).isTrue().as("DE page don't opened");
    }
}
