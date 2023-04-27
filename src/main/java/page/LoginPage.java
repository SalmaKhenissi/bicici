package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage{

    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("kc-login");

    private By errorMsg = By.id("input-error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProspectListPage clickToLogin(String username, String password) {
        this.getDriver().findElement(usernameInput).sendKeys(username);
        this.getDriver().findElement(passwordInput).sendKeys(password);
        this.clickOnLoginButton();

        return new ProspectListPage(this.getDriver());
    }

    public void clickOnLoginButton() {
        this.getDriver().findElement(loginButton).click();
    }

    public boolean hasErrorMsg() {
        return !this.getDriver().findElements(errorMsg).isEmpty();
    }
}
