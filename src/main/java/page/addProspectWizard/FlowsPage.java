package page.addProspectWizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlowsPage {

    private WebDriver driver;

    private By revenuesYear = By.className("test-revenuesYear");
    private By revenuesSources = By.className("test-revenuesSources");
    private By revenuesOrigins  = By.className("test-revenuesOrigins");
    private By annualRevenues = By.className("test-annualRevenues");
    private By revenuesCurrency = By.className("test-revenuesCurrency");

    public FlowsPage(WebDriver driver) {
        this.driver = driver;
    }
}
