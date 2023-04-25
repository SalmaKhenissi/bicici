package page;

import org.openqa.selenium.JavascriptExecutor;
import utils.FormIoUtil;
import page.newprospectwizard.VigilancePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InitiationPage {

    private WebDriver driver;
    private JavascriptExecutor jsDriver;
    private FormIoUtil formIoUtil;

    private By officeCode = By.className("formio-component-user_identity_branch");
    private By operatorCode = By.className("formio-component-code_exploitant");
    private By identityOption = By.className("formio-component-dropDownOnHold");
    private By identityInput = By.name("data[numeroDeCni]");
    private By initiationButton = By.name("data[submit1]");

    public InitiationPage(WebDriver driver) {
        this.driver = driver;
        this.formIoUtil = new FormIoUtil();
        this.jsDriver = (JavascriptExecutor) driver;
    }

    public VigilancePage clickToInitiateProspect() throws InterruptedException {
        Thread.sleep(5000);

        this.formIoUtil.clickOnChoiceOption(this.driver.findElement(officeCode), "06393");
        this.formIoUtil.clickOnChoiceOption(this.driver.findElement(operatorCode), "CA59");
        this.formIoUtil.searchAndSelect(this.driver.findElement(identityOption), "Numero de CNI");
        this.driver.findElement(identityInput).sendKeys("123456789");

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(initiationButton));
        driver.findElement(initiationButton).click();

        return new VigilancePage(this.driver);
    }
}
