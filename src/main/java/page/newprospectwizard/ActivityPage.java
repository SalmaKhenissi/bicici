package page.newprospectwizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActivityPage extends BaseNewProspectWizard {

    private By socioProfessionalCategory = By.className("formio-component-categorie_socio_professionnelle");
    private By activityDescription = By.name("data[descriptionDeLactivite]");
    private By riskyActivity = By.className("formio-component-activiteARisque");
    private By economicActivitySector = By.className("formio-component-secteurDactiviteEconomique");

    public ActivityPage(WebDriver driver) {
       super(driver);
    }

    public BankingInformationPage saveActivityDetails() throws InterruptedException {
        Thread.sleep(5000);
        this.formIoUtil.clickOnChoiceItem(driver, socioProfessionalCategory, "AGRICULTEURS EXPLOIT");
        driver.findElement(activityDescription).sendKeys("test description");
        this.formIoUtil.clickOnChoiceItem(driver, riskyActivity, "ACTIVITES LOBBYING");
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.formIoUtil.clickOnChoiceItem(driver, economicActivitySector, "AGRI-CHAS-SYLVI-PECH");
        this.jsDriver.executeScript("arguments[0].click();", driver.findElement(this.nextButton));

        return new BankingInformationPage(driver);
    }
}
