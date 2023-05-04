package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SettingsPage extends BasePage {

    private By SETTINGS_PAGE = By.xpath("//h1[contains(text(),'Language selection')]");
    private By EMAIL = By.xpath("//a[@href='#/settings/email']//ancestor::li//i");
    private By LOGIN_ALIAS = By.xpath("//a[@href='#/settings/login']//ancestor::li//i");
    private By LOGIN_ALIAS_DESCRIPTION = By.xpath("//div[@class='explanation']");
    private By PASSWORD = By.xpath("//a[@href='#/settings/password']//ancestor::li//i");
    private By PASSWORD_DESCRIPTION = By.xpath("//p[@class='ng-binding']");
    private By INACTIVITY_TIMEOUT = By.xpath("//a[@href='#/settings/logout']//ancestor::li//i");
    private By INACTIVITY_TIMEOUT_DESCRIPTION = By.xpath("//div[@class='explanation']");
    private By EMAIL_DESCRIPTION = By.xpath("//div[@class='explanation']");
    private By EDITOR = By.xpath("//a[@href='#/settings/editor']//ancestor::li//i");
    private By EDITOR_DESCRIPTION = By.xpath("//div[contains(text(),'whether ')]");
    private By EXPORT = By.xpath("//a[@href='#/settings/export']//ancestor::li//i");
    private By EXPORT_DESCRIPTION = By.xpath("//p[contains(text(),'journal')]");
    private By DONATIONS = By.xpath("//a[@href='#/settings/donation_payment']//ancestor::li//i");
    private By DONATIONS_DESCRIPTION = By.xpath("//div[contains(text(),'free ')]");
    private By DELETE_ACCOUNT = By.xpath("//a[@href='#/settings/delete_account']//ancestor::li//i");
    private By DELETE_ACCOUNT_DESCRIPTION = By.xpath("//div[contains(text(),'really')]");

    private By CHANGE_INACTIVITY_TIMEOUT = By.xpath("//option[contains(text(),'10 minutes')]");
    private By SUCCESS_CHANGE = By.xpath("//div[contains(text(),'successfully')]");
    private By OK_BUTTON = By.xpath("//div[@class='btn-text-content']");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_PAGE));
        return driver.findElement(SETTINGS_PAGE).isDisplayed();
    }

    public SettingsPage openEmail() {
        driver.findElement(EMAIL).click();
        return new SettingsPage(driver);
    }

    public String checkEmailDescription() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_DESCRIPTION));
        String actDescription = driver.findElement(EMAIL_DESCRIPTION).getText();
        return actDescription;
    }

    public SettingsPage openLoginAlias() {
        driver.findElement(LOGIN_ALIAS).click();
        return new SettingsPage(driver);
    }

    public String checkLoginAliasDescription() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_ALIAS_DESCRIPTION));
        String actDescription = driver.findElement(LOGIN_ALIAS_DESCRIPTION).getText();
        return actDescription;
    }

    public SettingsPage openPassword() {
        driver.findElement(PASSWORD).click();
        return new SettingsPage(driver);
    }

    public String checkPasswordDescription() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_DESCRIPTION));
        String actDescription = driver.findElement(PASSWORD_DESCRIPTION).getText();
        return actDescription;
    }

    public SettingsPage openInactivityTimeout() {
        driver.findElement(INACTIVITY_TIMEOUT).click();
        return new SettingsPage(driver);
    }

    public String checkInactivityTimeoutDescription() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(INACTIVITY_TIMEOUT_DESCRIPTION));
        String actDescription = driver.findElement(INACTIVITY_TIMEOUT_DESCRIPTION).getText();
        return actDescription;
    }

    public SettingsPage openEditor() {
        driver.findElement(EDITOR).click();
        return new SettingsPage(driver);
    }

    public String checkEditorDescription() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EDITOR_DESCRIPTION));
        String actDescription = driver.findElement(EDITOR_DESCRIPTION).getText();
        return actDescription;
    }

    public SettingsPage openExport() {
        driver.findElement(EXPORT).click();
        return new SettingsPage(driver);
    }

    public String checkExportDescription() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EXPORT_DESCRIPTION));
        String actDescription = driver.findElement(EXPORT_DESCRIPTION).getText();
        return actDescription;
    }

    public SettingsPage openDonations() {
        driver.findElement(DONATIONS).click();
        return new SettingsPage(driver);
    }

    public String checkDonationsDescription() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DONATIONS_DESCRIPTION));
        String actDescription = driver.findElement(DONATIONS_DESCRIPTION).getText();
        return actDescription;
    }

    public SettingsPage openDeleteAccount() {
        driver.findElement(DELETE_ACCOUNT).click();
        return new SettingsPage(driver);
    }

    public String checkDeleteAccountDescription() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DELETE_ACCOUNT_DESCRIPTION));
        String actDescription = driver.findElement(DELETE_ACCOUNT_DESCRIPTION).getText();
        return actDescription;
    }

    public SettingsPage changeInactivityTimeout() {
        driver.findElement(CHANGE_INACTIVITY_TIMEOUT).click();
        driver.findElement(OK_BUTTON).click();
        return new SettingsPage(driver);
    }

    public boolean isTimeoutChangeSuccess() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CHANGE));
        return driver.findElement(SUCCESS_CHANGE).isDisplayed();
    }
}
