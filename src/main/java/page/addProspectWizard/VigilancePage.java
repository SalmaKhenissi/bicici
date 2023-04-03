package page.addProspectWizard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FormIoUtil;

public class VigilancePage  {

    private WebDriver driver;
    private FormIoUtil formIoUtil;

    private By vigilanceDate = By.xpath("//*[@name = 'data[date]']");
    private By presenceList = By.className("formio-component-presence_list");
    private By vigilanceComment = By.xpath("//*[@name = 'data[Vigilance_commentaire]']");

    private By interrogationDate = By.xpath("//*[@name = 'data[date_interrogation_cip]']");
    private By detectionCip = By.className("formio-component-detection_cip");
    private By incidentCenterComment = By.xpath("//*[@name = 'data[centrale_commentaire]']");

    private By nextButton = By.className("btn-wizard-nav-next");

    public VigilancePage(WebDriver driver) {
        this.driver = driver;
        this.formIoUtil = new FormIoUtil();
    }

    public IdentificationPage saveVigilance() throws InterruptedException {

        Thread.sleep(10000);

        this.setVigilance();
        this.setCentralIncident();

        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
        WebElement nextButtonElement = driver.findElement(nextButton);
        jsDriver.executeScript("arguments[0].click();", nextButtonElement);

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
