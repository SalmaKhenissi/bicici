package frontOffice.process;

import base.BaseTest;
import dataprovider.InitiationDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ProspectListPage;
import page.newProspectWizard.VigilancePage;

public class VigilanceTest extends BaseTest {

    @Test(dataProviderClass = InitiationDataProvider.class, dataProvider = "initiation-provider")
    public void testValidInitiationProspect(String[] loginData) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        ProspectListPage prospectListPage = loginPage.clickToLogin(loginData[0], loginData[1]);

        VigilancePage vigilancePage = prospectListPage.clickToStartProcess().clickToInitiateProspect();

        Assert.assertTrue(this.driver.getCurrentUrl().contains("customer-service-bo/customer-journeys/details"));
        Assert.assertTrue(vigilancePage.isPageContainsCni());
    }
}
