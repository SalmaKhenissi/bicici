package page.newprospectwizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlowsPage extends BaseNewProspectWizard {

    private By revenuesYear = By.name("data[dataGridRevenuAnnuel][0][anneeRevenus]");
    private By revenuesSources = By.className("formio-component-radio");
    private By revenuesOrigins  = By.name("data[dataGridRevenuAnnuel][0][origineDesRevenusAnnuels]");
    private By annualRevenues = By.name("data[dataGridRevenuAnnuel][0][revenus_annuels]");
    private By revenuesCurrency = By.className("formio-component-devise_revenus_annuels");

    public FlowsPage(WebDriver driver) {
        super(driver);
    }

    public ForeignAccountPage saveAnnualRevenuesOrigin() throws InterruptedException {
        this.getDriver().findElement(revenuesYear).sendKeys("2020");
        this.formIoUtil.clickOnRadioButton(this.getDriver().findElement(revenuesSources), "pension_retraite");
        this.getDriver().findElement(revenuesOrigins).sendKeys("test origin");
        this.getDriver().findElement(annualRevenues).sendKeys("1000");
        this.formIoUtil.clickOnChoiceItem(this.getDriver(), revenuesCurrency, "ARGENT");
        this.jsDriver.executeScript("arguments[0].click();", this.getDriver().findElement(this.nextButton));

        return new ForeignAccountPage(this.getDriver());
    }
}
