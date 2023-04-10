package page.newprospectwizard;

import page.TaskDetails;
import utils.FormIoUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseNewProspectWizard extends TaskDetails {

    protected JavascriptExecutor jsDriver ;
    protected FormIoUtil formIoUtil;

    protected By nextButton = By.className("btn-wizard-nav-next");
    protected By previousButton = By.className("btn-wizard-nav-previous");
    protected By cancelButton = By.className("btn-wizard-nav-cancel");
    protected By submitButton = By.className("btn-wizard-nav-submit");

    public BaseNewProspectWizard(WebDriver driver) {
        super(driver);
        this.jsDriver = (JavascriptExecutor) driver;
        this.formIoUtil = new FormIoUtil();
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
        this.jsDriver.executeScript("arguments[0].click();", super.driver.findElement(button));
    }
}
