package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessfulRegistrationPage extends BasePage {

    private By LOCATOR_PAGE = By.xpath("//div[@class='content-container']");

    public SuccessfulRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR_PAGE));
        return driver.findElement(LOCATOR_PAGE).isDisplayed();
    }
}
