package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProspectListPage {

    private WebDriver driver;
    private By startIcon = By.className("icon-plus-square");

    public ProspectListPage(WebDriver driver) {
        this.driver = driver;
    }

    public InitiationPage clickToStartProcess() {
        driver.findElement(startIcon).findElement(By.xpath("parent::*")).click();

        return new InitiationPage(driver);
    }
}
