package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProspectListPage extends AbstractPage {

    private By menuButton = By.id("topbar-menu-button");
    private By startIcon = By.className("icon-plus-square");

    public ProspectListPage(WebDriver driver) {
        super(driver);
    }

    public InitiationPage clickToStartProcess() {
        this.getDriver().findElement(startIcon).findElement(By.xpath("parent::*")).click();

        return new InitiationPage(this.getDriver());
    }

    public void waitToLoggIn() {
        this.getWait().until(ExpectedConditions.visibilityOfElementLocated(menuButton));
    }
}
