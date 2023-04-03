package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormIoUtil {

    public void setDateInput(WebElement element, String data) {
        WebElement inputElement = element.findElement(By.xpath("following-sibling::*"));
        inputElement.clear();
        inputElement.sendKeys(data);
    }

    public void clickOnChoiceItem(WebDriver driver, By selector, String item) throws InterruptedException {
        WebElement element = driver.findElement(selector);
        element.findElement(By.className("form-control")).click();
        Thread.sleep(6000);

        WebElement optionElement = element.findElement(By.className("choices__list"))
                .findElement(By.xpath("//*[@data-value = '"+item+"']"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.elementToBeClickable(optionElement));

        optionElement.click();
    }

    public void clickOnSelectOption(WebElement element, String option) {
        Select objSelect = new Select(element);
        objSelect.selectByValue(option);
    }

    public void selectDate(WebElement element, String data) {
        // TO DO
        String[] dateArray = data.split("/");

        WebElement inputElement = element.findElement(By.xpath("following-sibling::*"));
        inputElement.click();
    }

    public void searchAndSelect(WebDriver driver, By selector, String value, String item) throws InterruptedException {
        WebElement element = driver.findElement(selector);
        element.findElement(By.className("form-control")).click();
        element.findElement(By.tagName("input")).sendKeys(value);

        Thread.sleep(2000);
        WebElement optionElement = element.findElement(By.className("choices__list"))
                .findElement(By.xpath("//*[@data-value = '"+item+"']"));

        Thread.sleep(2000);
        optionElement.click();
    }
}
