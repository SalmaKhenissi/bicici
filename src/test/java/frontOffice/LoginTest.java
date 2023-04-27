package frontOffice;

import dataprovider.LoginDataProvider;
import page.LoginPage;
import page.ProspectListPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;

public class LoginTest extends BaseTest {

    @Test(testName = "BCC-78", dataProviderClass = LoginDataProvider.class, dataProvider = "loginData", priority = 1)
    public void testValidLoginData(Map<String, String> loginData) {
        LoginPage loginPage = new LoginPage(driver);
        ProspectListPage prospectListPage = loginPage.clickToLogin(
                loginData.get("username"),
                loginData.get("password")
        );
        prospectListPage.waitToLoggIn();

        Assert.assertTrue(this.driver.getCurrentUrl().contains("/customer-service-bo/prospect"));
    }

    @Test(testName = "BCC-79", priority = 2)
    public void testEmptyLoginData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.hasErrorMsg());
    }

    @Test(testName = "BCC-80", dataProviderClass = LoginDataProvider.class, dataProvider = "loginData", priority = 3)
    public void testInvalidUsername(Map<String, String> loginData) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickToLogin(loginData.get("username"), loginData.get("password"));

        Assert.assertTrue(loginPage.hasErrorMsg());
    }

    @Test(testName = "BCC-81", dataProviderClass = LoginDataProvider.class, dataProvider = "loginData", priority = 4)
    public void testInvalidPassword(Map<String, String> loginData) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickToLogin(loginData.get("username"), loginData.get("password"));

        Assert.assertTrue(loginPage.hasErrorMsg());
    }
}
