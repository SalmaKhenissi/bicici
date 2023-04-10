package page.newprospectwizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankingInformationPage extends BaseNewProspectWizard {

    private By nationalId = By.name("data[idNational]");
    private By officeCode = By.className("formio-component-codeSiege");
    private By comment = By.name("data[commentaire]");

    private By accountType = By.className("formio-component-accountType1");
    private By accountCurrency = By.className("formio-component-deviseAccount1");
    private By accountOpeningReason = By.className("formio-component-motifAccount1");

    private By profileClient = By.className("formio-component-segmentClienteleVisAVisDg");

    private By forecastAmount = By.name("data[montantApport]");
    private By fundsOrigin = By.name("data[commentaire1]");
    private By contributionCurrency = By.className("formio-component-deviseApport");
    private By depositType = By.className("formio-component-typeDepot");

    public BankingInformationPage(WebDriver driver) {
        super(driver);
    }

    public FlowsPage saveBankingInfo() throws InterruptedException {
        this.setBankingRelationInfo();
        this.setNewAccountInfo();
        this.setProfileClient();
        this.setForecastFlows();
        this.jsDriver.executeScript("arguments[0].click();", driver.findElement(this.nextButton));

        return new FlowsPage(driver);
    }

    private void setBankingRelationInfo() throws InterruptedException {
        driver.findElement(nationalId).sendKeys("11111111111");
        this.formIoUtil.clickOnChoiceItem(driver, officeCode, "9563");
        driver.findElement(comment).sendKeys("test comment");
    }

    private void setNewAccountInfo() throws InterruptedException {
        this.formIoUtil.clickOnChoiceItem(driver, accountType, "compteOrdinaireAVue");
        this.formIoUtil.clickOnChoiceItem(driver, accountCurrency, "FRANC CFA (BCEAO)");
        this.formIoUtil.clickOnChoiceItem(driver, accountOpeningReason, "premier Compte Particulier");
    }

    private void setProfileClient() throws InterruptedException {
        this.formIoUtil.clickOnChoiceItem(driver, profileClient, "CJ11");
    }

    private void setForecastFlows() throws InterruptedException {
        driver.findElement(forecastAmount).sendKeys("11111111111");
        driver.findElement(fundsOrigin).sendKeys("11111111111");
        this.formIoUtil.clickOnChoiceItem(driver, contributionCurrency, "ARGENT");
        this.formIoUtil.clickOnChoiceItem(driver, depositType, "especes");
    }
}
