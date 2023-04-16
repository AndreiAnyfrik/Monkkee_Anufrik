package by.teachmeskills;

import by.teachmeskills.page.DiaryPage;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.SettingsPage;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SettingsTest extends BaseTest {

    @Test
    public void checkDate() {
        new LoginPage(driver).open().loginAsStandardUser();
        SettingsPage settingsPage = new DiaryPage(driver).openSettings();
        assertThat(settingsPage.isOpened()).isFalse().as("Settings Page has not been opened");
    }
}
