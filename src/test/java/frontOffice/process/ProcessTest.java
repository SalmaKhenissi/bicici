package frontOffice.process;

import base.BaseTest;
import dataprovider.InitiationDataProvider;
import page.LoginPage;
import page.ProspectListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Map;

public class ProcessTest extends BaseTest {

    @Test(testName = "BCC-processTest", dataProviderClass = InitiationDataProvider.class, dataProvider = "initiationProvider")
    public void testInitiation(Map<String, String> loginData) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        ProspectListPage prospectListPage = loginPage.clickToLogin(
                loginData.get("username"),
                loginData.get("password")
        );
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topbar-menu-button")));

        prospectListPage.clickToStartProcess()
                .clickToInitiateProspect()
                .saveVigilance()
                .saveIdentification()
                .saveContactDetails()
                .saveActivityDetails()
                .saveBankingInfo()
                .saveAnnualRevenuesOrigin()
                .saveForeignInfo();
    }

}
