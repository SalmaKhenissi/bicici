package page.addProspectWizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage {

    private WebDriver driver;

    private By fiscalLine1 = By.className("test-fiscalLine1");
    private By fiscalLine2 = By.className("test-fiscalLine2");
    private By fiscalLine3 = By.className("test-fiscalLine3");
    private By fiscalLine4 = By.className("test-fiscalLine4");
    private By fiscalPostalCode = By.className("test-fiscalPostalCode");
    private By fiscalLocality = By.className("test-fiscalLocality");
    private By fiscalCountry = By.className("test-fiscalCountry");
    private By fiscalEntryDate= By.className("test-fiscalEntryDate");
    private By fiscalExitDate = By.className("test-fiscalExitDate");
    private By fiscalAccommodation= By.className("test-fiscalAccommodation");
    private By isPostAddress = By.className("test-isPostAddress");

    private By postLine1 = By.className("test-postLine1");
    private By postLine2 = By.className("test-postLine2");
    private By postLine3 = By.className("test-postLine3");
    private By postLine4 = By.className("test-postLine4");
    private By postPostalCode = By.className("test-postPostalCode");
    private By postLocality = By.className("test-postLocality");
    private By postCountry = By.className("test-postCountry");
    private By postBox= By.className("test-postBox");
    private By postEntryDate = By.className("test-postEntryDate");

    private By homePhone1 = By.className("test-homePhone1");
    private By isHome1Privileged = By.className("test-isHome1Privileged");
    private By homePhone2 = By.className("test-homePhone2");
    private By isHome2Privileged = By.className("test-isHome2Privileged");
    private By mobilePhone1 = By.className("test-mobilePhone1");
    private By isMobile1Privileged = By.className("test-isMobile1Privileged");
    private By mobilePhone2 = By.className("test-mobilePhone2");
    private By isMobile2Privileged = By.className("test-isMobile2Privileged");
    private By proPhone1 = By.className("test-proPhone1");
    private By isPro1Privileged = By.className("test-isPro1Privileged");
    private By proPhone2 = By.className("test-proPhone2");
    private By isPro2Privileged = By.className("test-isPro2Privileged");
    private By mailPart1 = By.className("test-mailPart1");
    private By ismail1Privileged = By.className("test-isMail1Privileged");
    private By mailPart2 = By.className("test-mailPart2");
    private By isMail2Privileged = By.className("test-isMail2Privileged");

    public ContactDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
}
