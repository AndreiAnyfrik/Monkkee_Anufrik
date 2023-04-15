package by.teachmeskills.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WritingNotesPage extends BasePage {
    private By LOCATOR_PAGE = By.xpath("//span[@class='link_text_long']");
    private By WRITE = By.id("editable");
    private By BACK_HOME = By.id("back-to-overview");

    public WritingNotesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElement(LOCATOR_PAGE).isDisplayed();
    }

    public DiaryPage writeNote(String text) {
        driver.findElement(WRITE).sendKeys(text);
        driver.findElement(BACK_HOME).click();
        log.info("Note : {}", text);
        return new DiaryPage(driver);
    }
}
