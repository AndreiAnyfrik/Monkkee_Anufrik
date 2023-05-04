package by.teachmeskills;

import by.teachmeskills.page.DiaryPage;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.SettingsPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckDescriptionSettingsTest extends BaseTest {

    @Test
    public void checkSettingsPageOpened() {
        new LoginPage(driver).open().loginAsStandardUser();
        SettingsPage settingsPage = new DiaryPage(driver).openSettings();
        assertThat(settingsPage.isOpened()).isTrue().as("Settings Page has not been opened");
    }

    @Test
    public void checkEmailSettingsDescription() {
        String expDescription = "Here you can change the email address that is associated with your monkkee account. " +
                "After submitting the form, an email with a confirmation link will be sent to this address. " +
                "When clicking on this link, your address will be changed.";
        new LoginPage(driver).open().loginAsStandardUser();
        String actDescription = new DiaryPage(driver).openSettings().openEmail().checkEmailDescription();
        assertThat(actDescription).isEqualTo(expDescription).as("Description of Email don't match");
    }

    @Test
    public void checkLoginAliasDescription() {
        String expDescription = "Here you can assign a login alias which you can use to sign in with instead of your" +
                " email address. Logging in with your email address will still be possible.";
        new LoginPage(driver).open().loginAsStandardUser();
        String actDescription = new DiaryPage(driver).openSettings().openLoginAlias().checkLoginAliasDescription();
        assertThat(actDescription).isEqualTo(expDescription).as("Description of Login Alias don't match");
    }

    @Test
    public void checkPasswordDescription() {
        String expDescription = "Here you can change your password. If you have opened monkkee in other browser" +
                " windows, please close them first. When changing your password, all your entries (2), images (0)" +
                " and tags (0) will be re-encrypted.";
        new LoginPage(driver).open().loginAsStandardUser();
        String actDescription = new DiaryPage(driver).openSettings().openPassword().checkPasswordDescription();
        assertThat(actDescription).isEqualTo(expDescription).as("Description of Password don't match");
    }

    @Test
    public void checkInactivityTimeoutDescription() {
        String expDescription = "Here you can determine how long you may remain inactive before being" +
                " automatically logged off.";
        new LoginPage(driver).open().loginAsStandardUser();
        String actDescription = new DiaryPage(driver).openSettings().openInactivityTimeout()
                .checkInactivityTimeoutDescription();
        assertThat(actDescription).isEqualTo(expDescription).as("Description of Inactivity Timeout don't match");
        boolean timeoutChangeSuccess = new SettingsPage(driver).changeInactivityTimeout().isTimeoutChangeSuccess();
        assertThat(timeoutChangeSuccess).isTrue().as("Success message don't displayed");
    }

    @Test
    public void checkEditorDescription() {
        String expDescription = "Here you can decide whether you would like to start your entries with a heading" +
                " or with normal text.";
        new LoginPage(driver).open().loginAsStandardUser();
        String actDescription = new DiaryPage(driver).openSettings().openEditor().checkEditorDescription();
        assertThat(actDescription).isEqualTo(expDescription).as("Description of Editor don't match");
    }

    @Test
    public void checkExportDescription() {
        String expDescription = "Use the export function to download your journal to your computer and store it locally.";
        new LoginPage(driver).open().loginAsStandardUser();
        String actDescription = new DiaryPage(driver).openSettings().openExport().checkExportDescription();
        assertThat(actDescription).isEqualTo(expDescription).as("Description of Export don't match");
    }

    @Test
    public void checkDonationsDescription() {
        String expDescription = "monkkee is free of charge and should remain free – You can make a contribution to help" +
                " keep monkkee alive and running! Become part of a growing community of monkkee supporters – Help the" +
                " monkkee team with your donation! Click here to go to the donation page.";
        new LoginPage(driver).open().loginAsStandardUser();
        String actDescription = new DiaryPage(driver).openSettings().openDonations().checkDonationsDescription();
        assertThat(actDescription).isEqualTo(expDescription).as("Description of Donations don't match");
    }

    @Test
    public void checkDeleteAccountDescription() {
        String expDescription = "Do you really want to delete your monkkee user account? That is really a pity! Your " +
                "account will not be instantly deleted when clicking on the button below. You will first receive an " +
                "email with a confirmation link. Only when you have clicked on the link will your user" +
                " account be deleted.";
        new LoginPage(driver).open().loginAsStandardUser();
        String actDescription = new DiaryPage(driver).openSettings().openDeleteAccount().checkDeleteAccountDescription();
        assertThat(actDescription).isEqualTo(expDescription).as("Description of Delete Account don't match");
    }
}
