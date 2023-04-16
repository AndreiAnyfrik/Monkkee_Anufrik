package by.teachmeskills.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DiaryPage extends BasePage {
    private By CREATE_ENTRY_BUTTON = By.id("create-entry");
    private static final By SEARCH = By.id("search");
    private By LIST_OF_NOTES = By.xpath("//div[@ng-bind-html='entry.body']");
    private By SELECT = By.xpath("//input[@title='Select all']");
    private By DELETE = By.xpath("//i[@class='icon-trash']");
    private By ENTRY_DELETED = By.xpath("//div[@class='none centered']");
    private By LOG_OUT = By.xpath("//i[contains(@class,'icon-off')]");
    private By PRINT_FORM = By.xpath("//div[contains(@class, 'buttons')]");
    private By PRINT_BUTTON = By.xpath("//i[@class='icon-print']");
    private By SETTINGS = By.xpath("//a[@class='user-menu__btn']");

    public DiaryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH));
        return driver.findElement(SEARCH).isDisplayed();
    }

    public WritingNotesPage createEntry() {
        driver.findElement(CREATE_ENTRY_BUTTON).click();
        return new WritingNotesPage(driver);
    }

    public List<String> getAllNameNotes() {
        return driver.findElements(LIST_OF_NOTES)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void deleteNotes() {
        driver.findElement(SELECT).click();
        driver.findElement(DELETE).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean isEntryDeleted() {
        return driver.findElement(ENTRY_DELETED).isDisplayed();
    }

    public LoginPage logOut() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOG_OUT));
        driver.findElement(LOG_OUT).click();
        return new LoginPage(driver);
    }

    public DiaryPage printEntry() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SELECT));
        driver.findElement(SELECT).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRINT_BUTTON));
        driver.findElement(PRINT_BUTTON).click();
        return this;
    }

    public boolean switchToPrintForm() {
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(currentWindow);
        String printWindow = new LinkedList<>(windowHandles).getLast();
        driver.switchTo().window(printWindow);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRINT_FORM));
        return driver.findElement(PRINT_FORM).isDisplayed();
    }

    public SettingsPage openSettings() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS));
        driver.findElement(SETTINGS).click();
        return new SettingsPage(driver);
    }
}
