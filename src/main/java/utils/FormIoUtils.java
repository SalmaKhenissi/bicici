package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class FormIoUtils {

    private final String INPUT = "input";
    private final String SCROLL_ARG = "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})";
    private final String JS_CLICK = "arguments[0].click();";

    private WebDriver driver;
    private JavascriptExecutor jsDriver;

    public FormIoUtils(WebDriver driver) {
        this.driver = driver;
        this.jsDriver = (JavascriptExecutor) driver;
    }

    public void clickOnChoiceItem(By locator, String item) throws InterruptedException {
        WebElement element = this.driver.findElement(locator);
        WebElement selectElement = element.findElement(By.className("form-control"));
        this.jsDriver.executeScript(SCROLL_ARG, selectElement);
        selectElement.click();
        Thread.sleep(1000);

        WebElement optionElement = element.findElement(By.className("choices__list"))
                .findElement(By.xpath("//*[@data-value = '"+item+"']"));
        Thread.sleep(1000);

        this.jsDriver.executeScript(SCROLL_ARG, optionElement);
        optionElement.click();
        Thread.sleep(1000);
    }

    public void clickOnSelectOption(By locator, String option) {
        Select objSelect = new Select(this.driver.findElement(locator));
        objSelect.selectByValue(option);
    }

    public void searchAndSelect(By locator, String value) throws InterruptedException {
        WebElement element = this.driver.findElement(locator);
        WebElement selectElement = element.findElement(By.className("form-control"));
        this.jsDriver.executeScript(SCROLL_ARG, selectElement);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectElement));
        selectElement.click();
        Thread.sleep(1000);

        element.findElement(By.tagName("input")).sendKeys(value);
        Thread.sleep(1000);

        WebElement optionElement = element.findElement(By.xpath("div[1]/div[2]/div[1]/div[1]"));
        this.jsDriver.executeScript(SCROLL_ARG, optionElement);
        optionElement.click();
        Thread.sleep(1000);
    }

    public void clickOnSingleRadioButton(By locator) {
        WebElement element = this.driver.findElement(locator);

        this.jsDriver.executeScript(JS_CLICK, element.findElement(By.tagName(INPUT)));
    }

    public void clickOnRadioButton(By locator, String choiceValue) {
        WebElement element = this.driver.findElement(locator);
        List<WebElement> choices = element.findElements(By.tagName(INPUT));
        for (WebElement choice : choices) {
            if (choice.getAttribute("value").equals(choiceValue)) {
//                choice.click();
                this.jsDriver.executeScript(JS_CLICK, choice);
            }
        }
    }
}
