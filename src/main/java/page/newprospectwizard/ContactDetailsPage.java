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
        this.jsDriver.executeScript("arguments[0].click();", this.getDriver().findElement(this.nextButton));

        return new ActivityPage(this.getDriver());
    }

    private void setFiscalAddress() throws InterruptedException {
        this.getDriver().findElement(fiscalLine1).sendKeys("test fiscal line1");
        this.getDriver().findElement(fiscalLine2).sendKeys("test fiscal line2");
        this.getDriver().findElement(fiscalLine3).sendKeys("test fiscal line3");
        this.getDriver().findElement(fiscalLine4).sendKeys("test fiscal line4");
        this.getDriver().findElement(fiscalPostalCode).sendKeys("1234");
        this.getDriver().findElement(fiscalLocality).sendKeys("test");
        this.formIoUtil.clickOnChoiceItem(this.getDriver(), postCountry, "AD", this.jsDriver);
        this.formIoUtil.clickOnChoiceItem(this.getDriver(), fiscalAccommodation, "locataire");
    }

    private void setPostAddress() throws InterruptedException {
        this.getDriver().findElement(postLine1).sendKeys("test line1");
        this.getDriver().findElement(postLine2).sendKeys("test line2");
//        this.getDriver().findElement(postLine3).sendKeys("test line3");
        this.getDriver().findElement(postLine4).sendKeys("test line4");
        this.getDriver().findElement(postPostalCode).sendKeys("1234");
        this.getDriver().findElement(postLocality).sendKeys("test");
//        this.formIoUtil.clickOnChoiceItem(this.getDriver(), fiscalCountry, "AD", this.jsDriver);
        this.getDriver().findElement(postBox).sendKeys("123");
    }

    private void setPhones() {
        this.getDriver().findElement(homePhone1).sendKeys("1234");
        this.formIoUtil.clickOnRadioButton(this.getDriver().findElement(isHome1Privileged), this.jsDriver);
        this.getDriver().findElement(homePhone2).sendKeys("1234");
        this.formIoUtil.clickOnRadioButton(this.getDriver().findElement(isHome2Privileged), this.jsDriver);
        this.getDriver().findElement(mobilePhone1).sendKeys("1234");
        this.formIoUtil.clickOnRadioButton(this.getDriver().findElement(isMobile1Privileged), this.jsDriver);
        this.getDriver().findElement(mobilePhone2).sendKeys("1234");
        this.formIoUtil.clickOnRadioButton(this.getDriver().findElement(isMobile2Privileged), this.jsDriver);
        this.getDriver().findElement(proPhone1).sendKeys("1234");
        this.formIoUtil.clickOnRadioButton(this.getDriver().findElement(isPro1Privileged), this.jsDriver);
        this.getDriver().findElement(proPhone2).sendKeys("1234");
        this.formIoUtil.clickOnRadioButton(this.getDriver().findElement(isPro2Privileged), this.jsDriver);
    }

    private void setEmail() {
        this.getDriver().findElement(mailPart1).sendKeys("part1");
        this.formIoUtil.clickOnRadioButton(this.getDriver().findElement(ismail1Privileged), this.jsDriver);
        this.getDriver().findElement(mailPart2).sendKeys("part2.com");
        this.formIoUtil.clickOnRadioButton(this.getDriver().findElement(isMail2Privileged), this.jsDriver);
    }
}
