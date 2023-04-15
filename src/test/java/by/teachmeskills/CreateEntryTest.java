package by.teachmeskills;

import by.teachmeskills.page.DiaryPage;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.WritingNotesPage;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateEntryTest extends BaseTest {

    @Test
    public void createEntry() {
        new LoginPage(driver).open().loginAsStandardUser();
        WritingNotesPage entry = new DiaryPage(driver).createEntry();
        assertThat(entry.isOpened()).isTrue().as("WritingNotesPage don't opened");
        final String expNote = "test";
        new WritingNotesPage(driver).writeNote(expNote);
        List<String> actNote = new DiaryPage(driver).getAllNameNotes();
        assertThat(actNote).as("Text of new" + expNote + "does not displayed").contains(expNote);
    }

    @Test
    public void deleteEntry() {
        new LoginPage(driver).open().loginAsStandardUser();
        new DiaryPage(driver).createEntry();
        final String expectedNote = "test";
        new WritingNotesPage(driver).writeNote(expectedNote).deleteNotes();
        boolean entryDeleted = new DiaryPage(driver).isEntryDeleted();
        assertThat(entryDeleted).as("Notes don't deleted").isTrue();
    }

    @Test
    public void printEntry() {
        String test = "test";
        new LoginPage(driver).open().loginAsStandardUser();
        new DiaryPage(driver).createEntry();
        new WritingNotesPage(driver).writeNote(test);
        DiaryPage diaryPage = new DiaryPage(driver).printEntry();
        assertThat(diaryPage.isOpenedPrintForm()).isTrue().as("Print form don't opened");
    }
}
