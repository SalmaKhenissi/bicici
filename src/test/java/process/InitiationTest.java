package process;

import dataprovider.InitiationDataProvider;
import page.InitiationPage;
import page.LoginPage;
import page.ProspectListPage;
import page.newprospectwizard.*;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class InitiationTest extends BaseTest {

    @Test(dataProviderClass = InitiationDataProvider.class, dataProvider = "initiation-provider")
    public void testInitiationProspect(String[] loginData) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        ProspectListPage prospectListPage = loginPage.clickToLogin(loginData[0], loginData[1]);
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topbar-menu-button")));

        InitiationPage initiationPage = prospectListPage.clickToStartProcess();
    }

    @Test
    public void testInitiation() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        ProspectListPage prospectListPage = loginPage.clickToLogin("bkdev", "Pr0xym-1T");
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topbar-menu-button")));

        InitiationPage initiationPage = prospectListPage.clickToStartProcess();
        VigilancePage vigilancePage = initiationPage.clickToInitiateProspect();
//        driver.navigate().to("http://bicici-csa.qa.proxym-it.tn/customer-service-bo/customer-journeys/details?taskid=676038eb-d2c6-11ed-a8e3-5ad37bf8f35b");
//        VigilancePage vigilancePage = new VigilancePage(driver);

        var footer = driver.findElement(By.className("footer-left"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", footer);

        IdentificationPage identificationPage = vigilancePage.saveVigilance();
        ContactDetailsPage contactDetailsPage = identificationPage.saveIdentification();
        ActivityPage activityPage = contactDetailsPage.saveContactDetails();
        BankingInformationPage bankingInformationPage = activityPage.saveActivityDetails();
        FlowsPage flowPage = bankingInformationPage.saveBankingInfo();
        ForeignAccountPage foreignAccountPage = flowPage.saveAnnualRevenuesOrigin();

    }

}
