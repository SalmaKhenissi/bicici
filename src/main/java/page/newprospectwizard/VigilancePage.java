package page.newprospectwizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VigilancePage extends BaseNewProspectWizard  {

    private By vigilanceDate = By.name("data[date]");
    private By presenceList = By.className("formio-component-presence_list");
    private By vigilanceComment = By.name("data[Vigilance_commentaire]");

    private By interrogationDate = By.name("data[date_interrogation_cip]");
    private By detectionCip = By.className("formio-component-detection_cip");
    private By incidentCenterComment = By.name("data[centrale_commentaire]");

    public VigilancePage(WebDriver driver) {
        super(driver);
    }

    public IdentificationPage saveVigilance() throws InterruptedException {
        Thread.sleep(20000);

        this.setVigilance();
        this.setCentralIncident();
        this.jsDriver.executeScript("arguments[0].click();", driver.findElement(this.nextButton));

        return new IdentificationPage(driver);
    }

    private void setVigilance() throws InterruptedException {
        this.formIoUtil.setDateInput(driver.findElement(vigilanceDate),"28/03/2023");
        this.formIoUtil.clickOnChoiceItem(this.driver, presenceList, "outil indisponible");
        this.driver.findElement(vigilanceComment).sendKeys("test");
    }

    private void setCentralIncident() throws InterruptedException {
        this.formIoUtil.setDateInput(driver.findElement(interrogationDate),"28/03/2023");
        this.formIoUtil.clickOnChoiceItem(this.driver, detectionCip, "outil indisponible");
        this.driver.findElement(incidentCenterComment).sendKeys("test");
    }
}
