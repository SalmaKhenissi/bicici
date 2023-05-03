package page.newProspectWizard;

import org.openqa.selenium.WebElement;
import utils.AssertUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class VigilancePage extends BaseNewProspectWizard  {

    private AssertUtils assertUtils;

    private By cniElement = By.className("widget-details-item-value");

    private By vigilanceDate = By.name("data[date]");
    private By presenceList = By.className("formio-component-presence_list");
    private By vigilanceComment = By.name("data[Vigilance_commentaire]");

    private By interrogationDate = By.name("data[date_interrogation_cip]");
    private By detectionCip = By.className("formio-component-detection_cip");
    private By incidentCenterComment = By.name("data[centrale_commentaire]");

    public VigilancePage(WebDriver driver) {
        super(driver);
        this.assertUtils = new AssertUtils();
    }

    public IdentificationPage saveVigilance() throws InterruptedException {
        Thread.sleep(20000);

        this.setVigilance();
        this.setCentralIncident();
        this.jsDriver.executeScript("arguments[0].click();", this.getDriver().findElement(this.nextButton));

        return new IdentificationPage(this.getDriver());
    }

    private void setVigilance() throws InterruptedException {
        this.dateUtils.setDateInput(vigilanceDate,"28/03/2023");
        this.formIoUtil.searchAndSelect(presenceList, "outil indisponible");
        this.getDriver().findElement(vigilanceComment).sendKeys("test comment");
    }

    private void setCentralIncident() throws InterruptedException {
        this.dateUtils.setDateInput(interrogationDate,"28/03/2023");
        this.formIoUtil.searchAndSelect(detectionCip, "outil indisponible");
        this.getDriver().findElement(incidentCenterComment).sendKeys("test comment");
    }

    public boolean isPageContainsCni() {
        List<WebElement> elements = this .getDriver().findElements(cniElement);

        return this.assertUtils.isElementsContainsProvidedText(elements, "123456789");
    }
}
