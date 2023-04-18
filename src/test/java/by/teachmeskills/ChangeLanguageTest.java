package by.teachmeskills;

import by.teachmeskills.page.DonatePage;
import by.teachmeskills.page.LoginPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangeLanguageTest extends BaseTest {

    @Test
    public void checkDonates() {
        DonatePage donate = new LoginPage(driver).open().donate();
        assertThat(donate.isOpened()).isTrue().as("Donate Page has not been opened");
    }

    @Test
    public void changeLanguageDE() {
        String expResult = "Sprache temporär geändert. Um deine Profil-Sprache dauerhaft zu ändern, besuche den" +
                " Menüpunkt \"Einstellungen\" nach dem Login.";
        new LoginPage(driver).open().openDEPage();
        String actResult = new LoginPage(driver).checkLanguagePage();
        assertThat(expResult).isEqualTo(actResult).as("DE language Login page has not been opened");
    }

    @Test
    public void changeLanguageFR() {
        String expResult = "Langue temporairement changée. Afin de changer de façon permanente la langue de votre" +
                " compte, veuillez accéder au point de menu \"Paramètres\" après le login.";
        new LoginPage(driver).open().openFRPage();
        String actResult = new LoginPage(driver).checkLanguagePage();
        assertThat(expResult).isEqualTo(actResult).as("FR language Login page has not been opened");
    }

    @Test
    public void changeLanguagePT() {
        String expResult = "Idioma alterado temporariamente. Para modificar a linguagem de seu perfil permanentemente," +
                " vá para o item do menu \"Configurações\" após estar logado.";
        new LoginPage(driver).open().openPTPage();
        String actResult = new LoginPage(driver).checkLanguagePage();
        assertThat(expResult).isEqualTo(actResult).as("PT language Login page has not been opened");
    }
}
