package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEPage extends BasePage{
    private By DE_PAGE = By.xpath("//div[contains(text(),'Sprache ')]");
    public DEPage(WebDriver driver) {
        super(driver);
    }
    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DE_PAGE));
        return driver.findElement(DE_PAGE).isDisplayed();
    }
}
