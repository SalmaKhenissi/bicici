package page.newProspectWizard;

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
    private By fiscalEntryDate= By.name("data[fiscalEntryDate]");
    private By fiscalExitDate = By.name("data[fiscalEndDate]");
    private By fiscalAccommodation= By.className("formio-component-logement");
    private By isPostAddress = By.className("formio-component-adresseCourrierIdentique");

    private By postLine1 = By.name("data[courrierLine1]");
    private By postLine2 = By.name("data[courrierLine2]");
    private By postLine3 = By.name("data[courrierLine3]");
    private By postLine4 = By.name("data[courrierLine4]");
    private By postPostalCode = By.name("data[courrierCode]");
    private By postLocality = By.name("data[courrierLocal]");
    private By postCountry = By.className("formio-component-courrierCountry");
    private By postBox= By.name("data[courrierCode1]");
    private By postEntryDate = By.name("data[courrierEntryDate]");

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
        this.dateUtils.selectDate(fiscalEntryDate, "02/04/2023");
        this.dateUtils.selectDate(fiscalExitDate, "23/04/2023");
        this.formIoUtil.searchAndSelect(fiscalCountry, "ANDORRE");
        this.formIoUtil.searchAndSelect(fiscalAccommodation, "locataire");
        this.formIoUtil.clickOnRadioButton(isPostAddress, "false");
    }

    private void setPostAddress() throws InterruptedException {
        Thread.sleep(2000);
        this.getDriver().findElement(postLine1).sendKeys("test line1");
        this.getDriver().findElement(postLine2).sendKeys("test line2");
        this.getDriver().findElement(postLine3).sendKeys("test");
        this.getDriver().findElement(postLine4).sendKeys("test line4");
        this.getDriver().findElement(postPostalCode).sendKeys("1234");
        this.getDriver().findElement(postLocality).sendKeys("test");
        this.formIoUtil.searchAndSelect(postCountry, "EMIRAT ARABE");
        this.getDriver().findElement(postBox).sendKeys("123");
        this.dateUtils.selectDate(postEntryDate, "03/04/2023");
    }

    private void setPhones() {
        this.getDriver().findElement(homePhone1).sendKeys("1234");
        this.getDriver().findElement(homePhone2).sendKeys("1234");
        this.formIoUtil.clickOnSingleRadioButton(isHome2Privileged);
        this.getDriver().findElement(mobilePhone1).sendKeys("1234");
        this.formIoUtil.clickOnSingleRadioButton(isMobile1Privileged);
        this.getDriver().findElement(mobilePhone2).sendKeys("1234");
        this.getDriver().findElement(proPhone1).sendKeys("1234");
        this.formIoUtil.clickOnSingleRadioButton(isPro1Privileged);
        this.getDriver().findElement(proPhone2).sendKeys("1234");
    }

    private void setEmail() {
        this.getDriver().findElement(mailPart1).sendKeys("part1");
        this.formIoUtil.clickOnSingleRadioButton(ismail1Privileged);
        this.getDriver().findElement(mailPart2).sendKeys("part2.com");
        this.formIoUtil.clickOnSingleRadioButton(isMail2Privileged);
    }
}
