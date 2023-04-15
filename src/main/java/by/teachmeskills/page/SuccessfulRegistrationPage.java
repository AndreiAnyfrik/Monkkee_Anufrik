package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulRegistrationPage extends BasePage {

    private By LOCATOR_PAGE = By.xpath("//div[@class='content-container']");

    public SuccessfulRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElement(LOCATOR_PAGE).isDisplayed();
    }
}
