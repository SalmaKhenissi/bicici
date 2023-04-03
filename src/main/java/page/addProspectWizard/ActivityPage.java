package page.addProspectWizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActivityPage {

    private WebDriver driver;

    private By socioProfessionalCategory = By.className("test-socioProfessionalCategory");
    private By activityDescription = By.className("test-activityDescription");
    private By riskyActivity = By.className("test-riskyActivity");
    private By economicActivitySector = By.className("test-economicActivitySector");

    public ActivityPage(WebDriver driver) {
        this.driver = driver;
    }
}
