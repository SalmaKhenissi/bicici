package page.addProspectWizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForeignAccountPage {

    private WebDriver driver;

    private By hasUSNationality = By.className("test-hasUSNationality");
    private By hasDoubleUSNationality = By.className("test-hasDoubleUSNationality");
    private By isUSResident = By.className("test-isUSResident");
    private By hasUSAddress = By.className("test-hasUSAddress");
    private By hasUSActivity = By.className("test-hasUSActivity");
    private By hasUSPhone = By.className("test-hasUSPhone");

    public ForeignAccountPage(WebDriver driver) {
        this.driver = driver;
    }
}
