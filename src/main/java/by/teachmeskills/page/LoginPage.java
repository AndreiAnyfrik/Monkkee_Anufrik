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
    public By SEND_PASSWORD = By.xpath("//a[@href='/account/password_reminder']");
    public By REGISTER_BUTTON = By.xpath("//a[@href='/account/registration']");
    public By DONATE_BUTTON = By.xpath("//a[@ng-show='donationButtonVisible']");
    public By EN_BUTTON = By.xpath("//span[text()='EN']");
    public By DE_BUTTON = By.xpath("//a[text()='DE']");
    public By FR_BUTTON = By.xpath("//a[text()='FR']");
    public By PT_BUTTON = By.xpath("//a[text()='PT']");
    public static final String STANDARD_USER = "andrei311296@mail.ru";
    public static final String STANDARD_PASSWORD = "5871839Aa";

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
        loginAs(STANDARD_USER, STANDARD_PASSWORD);
        return new DiaryPage(driver);
    }

    public boolean isErrorDisplayed() {
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

    public DEPage changeDELanguage() {
        driver.findElement(DE_BUTTON).click();
        return new DEPage(driver);
    }

    public PTPage changePTLanguage() {
        driver.findElement(PT_BUTTON).click();
        return new PTPage(driver);
    }

    public FRPage changeFRLanguage() {
        driver.findElement(FR_BUTTON).click();
        return new FRPage(driver);
    }
}
