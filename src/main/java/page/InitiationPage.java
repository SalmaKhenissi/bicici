package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.addProspectWizard.VigilancePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FormIoUtil;

import java.time.Duration;

public class InitiationPage {

    private WebDriver driver;
    private FormIoUtil formIoUtil;

//    private By initiationButton = By.name("data[submit1]");
    private By initiationButton = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/button[1]");

    private By officeCode = By.className("test-officeCode");
    private By operatorCode = By.className("test-operatorCode");
    private By identityOption = By.className("test-option");
    private By identityInput = By.xpath("//*[@name = 'data[numeroDeCni_input]']");

    public InitiationPage(WebDriver driver) {
        this.driver = driver;
        this.formIoUtil = new FormIoUtil();
    }

    public VigilancePage clickToInitiateProspect() throws InterruptedException {
        Thread.sleep(5000);

        this.formIoUtil.clickOnChoiceItem(this.driver, officeCode, "06393");
        this.formIoUtil.clickOnChoiceItem(this.driver, operatorCode, "CA59");
        this.formIoUtil.clickOnChoiceItem(this.driver, identityOption, "numeroDeCni");
        this.driver.findElement(identityInput).sendKeys("123456789");

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(initiationButton));
        driver.findElement(initiationButton).click();

        return new VigilancePage(this.driver);
    }
}
