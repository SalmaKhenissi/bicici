package process;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.LoginPage;
import page.ProspectListPage;
import page.addProspectWizard.IdentificationPage;
import page.addProspectWizard.VigilancePage;
import base.BaseTest;
import org.testng.annotations.Test;
import page.InitiationPage;
import java.time.Duration;

public class InitiationTest extends BaseTest {

    @Test
    public void testInitiation() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        ProspectListPage prospectListPage = loginPage.clickToLogin("bkdev", "Pr0xym-1T");
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topbar-menu-button")));

        InitiationPage initiationPage = prospectListPage.clickToStartProcess();
        VigilancePage vigilancePage = initiationPage.clickToInitiateProspect();

        var footer = driver.findElement(By.className("footer-left"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "arguments[0].parentNode.removeChild(arguments[0])", footer);

        IdentificationPage identificationPage = vigilancePage.saveVigilance();
        identificationPage.saveIdentification();

    }

}
