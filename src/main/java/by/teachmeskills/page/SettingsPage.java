package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage {

    private By SETTINGS_PAGE = By.id("settings-page-select");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElement(SETTINGS_PAGE).isDisplayed();
    }
}
