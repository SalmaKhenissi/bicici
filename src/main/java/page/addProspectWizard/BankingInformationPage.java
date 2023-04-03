package page.addProspectWizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankingInformationPage {

    private WebDriver driver;

    private By nationalId = By.className("test-nationalId");
    private By officeCode = By.className("test-officeCode");
    private By comment = By.className("test-comment");

    private By accountType = By.className("test-accountType");
    private By accountCurrency = By.className("test-accountCurrency");
    private By accountOpeningReason = By.className("test-accountOpeningReason");

    private By profileClient = By.className("test-profileClient");

    private By forecastAmount = By.className("test-forecastAmount");
    private By fundsOrigin = By.className("test-fundsOrigin");
    private By contributionCurrency = By.className("test-contributionCurrency");
    private By depositType = By.className("test-depositType");

    public BankingInformationPage(WebDriver driver) {
        this.driver = driver;
    }
}
