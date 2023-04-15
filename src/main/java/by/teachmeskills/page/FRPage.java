package by.teachmeskills.page;

import by.teachmeskills.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FRPage extends BasePage {
    private By FR_PAGE = By.xpath("//div[contains(text(),'Langue')]");

    public FRPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElement(FR_PAGE).isDisplayed();
    }
}
