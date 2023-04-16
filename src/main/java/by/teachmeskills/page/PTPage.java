package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PTPage extends BasePage {
    private By PT_PAGE = By.xpath("//div[contains(text(),'Idioma')]");

    public PTPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElement(PT_PAGE).isDisplayed();
    }
}
