package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DonatePage extends BasePage {
    private By DONATE_PAGE = By.id("donate");

    public DonatePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElement(DONATE_PAGE).isDisplayed();
    }
}
