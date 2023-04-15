package by.teachmeskills;

import by.teachmeskills.page.DiaryPage;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.SettingsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest {

    @Test
    public void checkDate() {
        new LoginPage(driver).open().loginAsStandardUser();
        SettingsPage settingsPage = new DiaryPage(driver).openSettings();
        Assertions.assertThat(settingsPage.isOpened()).isFalse().as("Settings Page do not opened");
    }
}
