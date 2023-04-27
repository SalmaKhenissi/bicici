package frontOffice.process;

import dataprovider.InitiationDataProvider;
import dataprovider.LoginDataProvider;
import org.testng.Assert;
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
import java.util.Map;

public class InitiationTest extends BaseTest {

//    @Test(dataProviderClass = InitiationDataProvider.class, dataProvider = "initiationProvider")
//    public void testValidInitiationProspect(String[] loginData) throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//
//        ProspectListPage prospectListPage = loginPage.clickToLogin(loginData[0], loginData[1]);
//
//        VigilancePage vigilancePage = prospectListPage.clickToStartProcess().clickToInitiateProspect();
//
//        Assert.assertTrue(this.driver.getCurrentUrl().contains("customer-service-bo/customer-journeys/details"));
//        Assert.assertTrue(vigilancePage.isPageContainsCni());
//    }

    @Test(
            testName = "BCC-7",
            dataProviderClass = LoginDataProvider.class,
            dataProvider = "validLoginData",
            priority = 1
    )
    public void testAbandonButton(Map<String, String> loginData) {
        LoginPage loginPage = new LoginPage(driver);

        ProspectListPage prospectListPage = loginPage.clickToLogin(
                loginData.get("username"),
                loginData.get("password")
        );
        prospectListPage.waitToLoggIn();
        prospectListPage.clickToStartProcess().clickOnAbandonButton();

        Assert.assertTrue(this.driver.getCurrentUrl().contains("/customer-service-bo/prospect"));
    }

    @Test(
            testName = "BCC-387",
            dataProviderClass = LoginDataProvider.class,
            dataProvider = "validLoginData",
            priority = 2
    )
    public void testBackButton(Map<String, String> loginData) {
        LoginPage loginPage = new LoginPage(driver);

        ProspectListPage prospectListPage = loginPage.clickToLogin(loginData.get("username"), loginData.get("password"));
        prospectListPage.waitToLoggIn();
        prospectListPage.clickToStartProcess().clickOnBackButton();

        Assert.assertTrue(this.driver.getCurrentUrl().contains("/customer-service-bo/prospect"));
    }

}
