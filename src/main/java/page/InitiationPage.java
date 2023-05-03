package page;

import utils.AssertUtils;
import utils.FormIoUtils;
import page.newProspectWizard.VigilancePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InitiationPage extends AbstractPage {

    private FormIoUtils formIoUtil;
    private AssertUtils assertUtils;

    private By officeCode = By.className("formio-component-user_identity_branch");
    private By operatorCode = By.className("formio-component-code_exploitant");
    private By identityOption = By.className("formio-component-dropDownOnHold");
    private By identityInput = By.name("data[numeroDeCni]");

    private By initiationButton = By.name("data[submit1]");
    private By abandonButton = By.name("data[abandon]");
    private By backButton = By.className("back-button");

    public InitiationPage(WebDriver driver) {
        super(driver);
        this.formIoUtil = new FormIoUtils(driver);
        this.assertUtils = new AssertUtils();
    }

    public VigilancePage clickToInitiateProspect() throws InterruptedException {
        Thread.sleep(5000);

        this.formIoUtil.clickOnChoiceItem(officeCode, "06393");
        Thread.sleep(1000);
        this.formIoUtil.clickOnChoiceItem(operatorCode, "CA59");
        this.formIoUtil.searchAndSelect(identityOption, "Numero de CNI");
        this.getDriver().findElement(identityInput).sendKeys("123456789");

        this.getWait().until(ExpectedConditions.elementToBeClickable(initiationButton));
        this.clickOnInitiationButton();

        Thread.sleep(5000);

        return new VigilancePage(this.getDriver());
    }

    public void clickOnInitiationButton() {
        this.getDriver().findElement(initiationButton).click();
    }

    public void clickOnAbandonButton() {
        this.getDriver().findElement(abandonButton).click();
    }

    public void clickOnBackButton() {
        this.getDriver().findElement(backButton).click();
    }
}
