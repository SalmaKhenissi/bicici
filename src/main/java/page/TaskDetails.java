package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskDetails extends AbstractPage {

    private By discardButton = By.xpath("//*[@title = 'Libérer la Tâche']");
    private By reassignButton = By.xpath("//*[@title = 'Réaffecter']");
    private By abandonButton = By.xpath("//*[@title = 'Abandonner']");
    private By saveDraftButton = By.xpath("//*[@title = 'Enregistrer Brouillon']");
    private By browseButton = By.xpath("//*[@title = 'Parcours']");

    public TaskDetails(WebDriver driver) {
        super(driver);
    }

    public void discardTask() {
        this.clickOnButton(discardButton);
    }

    public void reassignTask() {
        this.clickOnButton(reassignButton);
    }

    public void abandonTask() {
        this.clickOnButton(abandonButton);
    }

    public void saveDraftTask() {
        this.clickOnButton(saveDraftButton);
    }

    public void browseTask() {
        this.clickOnButton(browseButton);
    }

    public void clickOnButton(By button) {
        this.getDriver().findElement(button).click();
    }
}
