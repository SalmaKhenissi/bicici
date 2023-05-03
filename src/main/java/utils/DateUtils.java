package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class DateUtils {

    private final String SCROLL_ARG = "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})";

    private WebDriver driver;
    private JavascriptExecutor jsDriver;

    private By calendarLocator = By.xpath("//div[contains(@class, 'flatpickr-calendar animate open')]");
    private By dayLocator = By.className("flatpickr-day");
    private By monthLocator = By.className("flatpickr-monthDropdown-months");
    private By yearLocator = By.className("cur-year");

    public DateUtils(WebDriver driver) {
        this.driver = driver;
        this.jsDriver = (JavascriptExecutor) driver;
    }

    public void setDateInput(By locator, String date) {
        WebElement inputElement = this.driver.findElement(locator).findElement(By.xpath("following-sibling::*"));
        inputElement.clear();
        inputElement.sendKeys(date);
    }

    public void selectDate(By locator, String date) {
        WebElement element = this.driver.findElement(locator).findElement(By.xpath("following-sibling::*"));
        this.jsDriver.executeScript(SCROLL_ARG, element);
        element.click();

        WebElement calendarElement = this.driver.findElement(calendarLocator);
        String[] dateArray = date.split("/");

        this.selectYearOption(calendarElement, dateArray[2]);
        this.selectMonthOption(calendarElement, dateArray[1]);
        this.selectDayOption(calendarElement, dateArray[0]);
    }

    private void selectDayOption(WebElement calendarElement, String dayValue) {
        List<WebElement> dayElements = calendarElement.findElements(dayLocator);
        dayValue = dayValue.charAt(0) == '0' ? dayValue.substring(1) : dayValue;
        for (WebElement dayElement : dayElements) {
            if (dayElement.getText().equals(dayValue)) {
                dayElement.click();
                break;
            }
        }
    }

    private void selectMonthOption(WebElement calendarElement, String monthValue) {
        String month;
        switch (monthValue) {
            case "01" -> month = "0";
            case "02" -> month = "1";
            case "03" -> month = "2";
            case "04" -> month = "3";
            case "05" -> month = "4";
            case "06" -> month = "5";
            case "07" -> month = "6";
            case "08" -> month = "7";
            case "09" -> month = "8";
            case "10" -> month = "9";
            case "11" -> month = "10";
            case "12" -> month = "11";
            default -> throw new IllegalStateException("Unexpected value: " + monthValue);
        }

        Select objSelect = new Select(calendarElement.findElement(monthLocator));
        objSelect.selectByValue(month);
    }

    private void selectYearOption(WebElement calendarElement, String yearValue) {
        WebElement yearElement = calendarElement.findElement(yearLocator);
        yearElement.clear();
        yearElement.sendKeys(yearValue);
    }
}
