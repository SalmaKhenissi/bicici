package page.newProspectWizard;

import utils.DateUtils;
import utils.FormIoUtils;
import page.TaskDetails;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseNewProspectWizard extends TaskDetails {

    protected JavascriptExecutor jsDriver ;
    protected FormIoUtils formIoUtil;
    protected DateUtils dateUtils;

    protected By nextButton = By.className("btn-wizard-nav-next");
    protected By previousButton = By.className("btn-wizard-nav-previous");
    protected By cancelButton = By.className("btn-wizard-nav-cancel");
    protected By submitButton = By.className("btn-wizard-nav-submit");

    public BaseNewProspectWizard(WebDriver driver) {
        super(driver);
        this.jsDriver = (JavascriptExecutor) driver;
        this.formIoUtil = new FormIoUtils(driver);
        this.dateUtils = new DateUtils(driver);
    }

    public void getNextStep() {
        this.clickOnButton(nextButton);
    }

    public void getPreviousStep() {
        this.clickOnButton(previousButton);
    }

    public void cancel() {
        this.clickOnButton(cancelButton);
    }

    public void save() {
        this.clickOnButton(submitButton);
    }

    public void clickOnButton(By button) {
        this.jsDriver.executeScript("arguments[0].click();", this.getDriver().findElement(button));
    }
}
