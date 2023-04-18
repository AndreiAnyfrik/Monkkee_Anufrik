package by.teachmeskills.page;

import by.teachmeskills.testng.PropertiesLoader;
import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

@Log4j2
public class LoginPage extends BasePage {

    private By USER_NAME = By.id("login");
    private By PASSWORD = By.id("password");
    private By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    private By ERROR = By.xpath("//div[@ng-show='formStatus']");

    public By LOGIN_PAGE_LOCATOR = By.xpath("//label[contains(@for,'login')]");
    public By REGISTER_BUTTON = By.xpath("//a[@href='/account/registration']");
    public By DONATE_BUTTON = By.xpath("//a[@ng-show='donationButtonVisible']");
    public By DE_BUTTON = By.xpath("//a[text()='DE']");
    public By FR_BUTTON = By.xpath("//a[text()='FR']");
    public By PT_BUTTON = By.xpath("//a[text()='PT']");
    private By LANGUAGE_TEXT = By.xpath("//div[contains(@class,'alert')]");
    private By ERROR_INVALID_LOGIN = By.xpath("//form[@ng-hide='loggedIn']//div[@ng-show='formStatus']");
    private By ERROR_EMPTY_LOGIN = By.xpath("//label[contains(text(), 'User')]//ancestor::" +
            "div[contains(@class, 'form-group')]//div[contains(@class, 'help-block')]");
    private By ERROR_EMPTY_PASSWORD = By.xpath("//label[contains(text(), 'Password')]//ancestor::" +
            "div[contains(@class, 'form-group')]//div[contains(@class, 'help-block')]");

    private static final String INVALID_LOGIN = "sdaa";
    private static final String INVALID_PASSWORD = "588894";
    private static final String EMPTY_LOGIN = "";
    private static final String EMPTY_PASSWORD = "";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Attachment
    public LoginPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url"));
        return this;
    }

    public void loginAs(String userName, String password) {
        driver.findElement(USER_NAME).sendKeys(userName);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Log as {},{}", userName, password);
    }

    public DiaryPage loginAsStandardUser() {
        Properties properties = PropertiesLoader.loadProperties();
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        loginAs(username, password);
        return new DiaryPage(driver);
    }

    public boolean isErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR));
        return driver.findElement(ERROR).isDisplayed();
    }

    public RegistrationPage openedRegistrationForm() {
        driver.findElement(REGISTER_BUTTON).click();
        log.info("Registration page is opened ");
        return new RegistrationPage(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_PAGE_LOCATOR));
        return driver.findElement(LOGIN_PAGE_LOCATOR).isDisplayed();
    }

    public DonatePage donate() {
        driver.findElement(DONATE_BUTTON).click();
        return new DonatePage(driver);
    }

    public LoginPage openDEPage() {
        driver.findElement(DE_BUTTON).click();
        return new LoginPage(driver);
    }

    public LoginPage openPTPage() {
        driver.findElement(PT_BUTTON).click();
        return new LoginPage(driver);
    }

    public LoginPage openFRPage() {
        driver.findElement(FR_BUTTON).click();
        return new LoginPage(driver);
    }

    public String checkLanguagePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LANGUAGE_TEXT));
        String actResult = driver.findElement(LANGUAGE_TEXT).getText();
        return actResult;
    }

    public String getErrorAfterInvalidUserNameAndInvalidPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_INVALID_LOGIN));
        String actError = driver.findElement(ERROR_INVALID_LOGIN).getText();
        return actError;
    }

    public String getErrorAfterEmptyLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_EMPTY_LOGIN));
        String actError = driver.findElement(ERROR_EMPTY_LOGIN).getText();
        return actError;
    }

    public String getErrorAfterEmptyPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_EMPTY_PASSWORD));
        String actError = driver.findElement(ERROR_EMPTY_PASSWORD).getText();
        return actError;
    }

    public LoginPage loginWithInvalidUserNameAndInvalidPassword() {
        driver.findElement(USER_NAME).sendKeys(INVALID_LOGIN);
        driver.findElement(PASSWORD).sendKeys(INVALID_PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }

    public LoginPage loginWithAllEmptyFields() {
        driver.findElement(USER_NAME).sendKeys(EMPTY_LOGIN);
        driver.findElement(PASSWORD).sendKeys(EMPTY_PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }

    public LoginPage loginWithEmptyPassword() {
        driver.findElement(USER_NAME).sendKeys(INVALID_LOGIN);
        driver.findElement(PASSWORD).sendKeys(EMPTY_PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }
}
