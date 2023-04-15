package by.teachmeskills;

import by.teachmeskills.page.DiaryPage;
import by.teachmeskills.page.LoginPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPositiveTest extends BaseTest {

    @Test
    public void positiveLog() {
        DiaryPage diaryPage = new LoginPage(driver).open()
                .loginAsStandardUser();
        assertThat(diaryPage.isOpened())
                .isTrue()
                .as("Diary page should be opened after user logged in with valid credentials");
    }
}
