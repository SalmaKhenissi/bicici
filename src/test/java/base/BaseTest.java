package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import page.LoginPage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
    }

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.navigate().to("http://bicici-csa.qa.proxym-it.tn/customer-service-bo/prospect");
        driver.manage().window().maximize();
    }

//    @BeforeMethod
//    public void beforeMethod(String username, String password)
//    {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.clickToLogin(username, password);
//    }

    @AfterTest
    public void tearDown() {
//        driver.quit();
    }

    @AfterSuite
    public void ClearBrowserCache() {
        driver.manage().deleteAllCookies();
    }
}
