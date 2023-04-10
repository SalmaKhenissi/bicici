package page.newprospectwizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage extends BaseNewProspectWizard {

    private By fiscalLine1 = By.name("data[fiscalLine1]");
    private By fiscalLine2 = By.name("data[fiscalLine2]");
    private By fiscalLine3 = By.name("data[fiscalLine3]");
    private By fiscalLine4 = By.name("data[fiscalLine4]");
    private By fiscalPostalCode = By.name("data[zipCode]");
    private By fiscalLocality = By.name("data[fiscalLocal]");
    private By fiscalCountry = By.className("formio-component-fiscalCountry");
    private By fiscalEntryDate= By.className("test-fiscalEntryDate");
    private By fiscalExitDate = By.className("test-fiscalExitDate");
    private By fiscalAccommodation= By.className("test-fiscalAccommodation");
    private By isPostAddress = By.className("formio-component-adresseCourrierIdentique");

    private By postLine1 = By.name("data[courrierLine1]");
    private By postLine2 = By.name("data[courrierLine2]");
    private By postLine3 = By.name("data[courrierLine3]");
    private By postLine4 = By.name("data[courrierLine4]");
    private By postPostalCode = By.name("data[courrierCode]");
    private By postLocality = By.name("data[courrierLocal]");
    private By postCountry = By.className("formio-component-courrierCountry");
    private By postBox= By.name("data[courrierCode1]");
    private By postEntryDate = By.className("test-postEntryDate");

    private By homePhone1 = By.name("data[teld1]");
    private By isHome1Privileged = By.className("formio-component-radio");
    private By homePhone2 = By.name("data[teld2]");
    private By isHome2Privileged = By.className("formio-component-radio2");
    private By mobilePhone1 = By.name("data[telp1]");
    private By isMobile1Privileged = By.className("formio-component-radio3");
    private By mobilePhone2 = By.name("data[telp2]");
    private By isMobile2Privileged = By.className("formio-component-radio4");
    private By proPhone1 = By.name("data[telpr1]");
    private By isPro1Privileged = By.className("formio-component-radio5");
    private By proPhone2 = By.name("data[telpr2]");
    private By isPro2Privileged = By.className("formio-component-radio6");
    private By mailPart1 = By.name("data[mailAvant]");
    private By ismail1Privileged = By.className("formio-component-radio7");
    private By mailPart2 = By.name("data[mailApr]");
    private By isMail2Privileged = By.className("formio-component-radio8");

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ActivityPage saveContactDetails() throws InterruptedException {
        this.setFiscalAddress();
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.setPostAddress();
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.setPhones();
        this.setEmail();
        this.jsDriver.executeScript("arguments[0].click();", driver.findElement(this.nextButton));

        return new ActivityPage(driver);
    }

    private void setFiscalAddress() throws InterruptedException {
        driver.findElement(fiscalLine1).sendKeys("test fiscal line1");
        driver.findElement(fiscalLine2).sendKeys("test fiscal line2");
        driver.findElement(fiscalLine3).sendKeys("test fiscal line3");
        driver.findElement(fiscalLine4).sendKeys("test fiscal line4");
        driver.findElement(fiscalPostalCode).sendKeys("1234");
        driver.findElement(fiscalLocality).sendKeys("test");
        this.formIoUtil.clickOnChoiceItem(driver, postCountry, "AD", this.jsDriver);
        this.formIoUtil.clickOnChoiceItem(driver, fiscalAccommodation, "locataire");
    }

    private void setPostAddress() throws InterruptedException {
        driver.findElement(postLine1).sendKeys("test line1");
        driver.findElement(postLine2).sendKeys("test line2");
//        driver.findElement(postLine3).sendKeys("test line3");
        driver.findElement(postLine4).sendKeys("test line4");
        driver.findElement(postPostalCode).sendKeys("1234");
        driver.findElement(postLocality).sendKeys("test");
//        this.formIoUtil.clickOnChoiceItem(driver, fiscalCountry, "AD", this.jsDriver);
        driver.findElement(postBox).sendKeys("123");
    }

    private void setPhones() {
        driver.findElement(homePhone1).sendKeys("1234");
        this.formIoUtil.clickOnRadioButton(driver.findElement(isHome1Privileged), this.jsDriver);
        driver.findElement(homePhone2).sendKeys("1234");
        this.formIoUtil.clickOnRadioButton(driver.findElement(isHome2Privileged), this.jsDriver);
        driver.findElement(mobilePhone1).sendKeys("1234");
        this.formIoUtil.clickOnRadioButton(driver.findElement(isMobile1Privileged), this.jsDriver);
        driver.findElement(mobilePhone2).sendKeys("1234");
        this.formIoUtil.clickOnRadioButton(driver.findElement(isMobile2Privileged), this.jsDriver);
        driver.findElement(proPhone1).sendKeys("1234");
        this.formIoUtil.clickOnRadioButton(driver.findElement(isPro1Privileged), this.jsDriver);
        driver.findElement(proPhone2).sendKeys("1234");
        this.formIoUtil.clickOnRadioButton(driver.findElement(isPro2Privileged), this.jsDriver);
    }

    private void setEmail() {
        driver.findElement(mailPart1).sendKeys("part1");
        this.formIoUtil.clickOnRadioButton(driver.findElement(ismail1Privileged), this.jsDriver);
        driver.findElement(mailPart2).sendKeys("part2.com");
        this.formIoUtil.clickOnRadioButton(driver.findElement(isMail2Privileged), this.jsDriver);
    }
}
