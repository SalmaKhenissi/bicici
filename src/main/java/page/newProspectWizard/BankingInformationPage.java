package page.newProspectWizard;

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
        this.jsDriver.executeScript("arguments[0].click();", this.getDriver().findElement(this.nextButton));

        return new FlowsPage(this.getDriver());
    }

    private void setBankingRelationInfo() throws InterruptedException {
        this.getDriver().findElement(nationalId).sendKeys("11111111111");
        this.formIoUtil.searchAndSelect(officeCode, "9563 - BOUAKE");
        this.getDriver().findElement(comment).sendKeys("test comment");
    }

    private void setNewAccountInfo() throws InterruptedException {
        this.formIoUtil.clickOnChoiceItem(accountType, "compteOrdinaireAVue");
        this.formIoUtil.searchAndSelect(accountCurrency, "FRANC CFA (BCEAO)");
        this.formIoUtil.searchAndSelect(accountOpeningReason, "Premier Compte de Particulier");
    }

    private void setProfileClient() throws InterruptedException {
        this.formIoUtil.searchAndSelect(profileClient, "GRANDES ENTREPRISES GE");
    }

    private void setForecastFlows() throws InterruptedException {
        this.getDriver().findElement(forecastAmount).sendKeys("11111111111");
        this.getDriver().findElement(fundsOrigin).sendKeys("11111111111");
        this.formIoUtil.searchAndSelect(contributionCurrency, "ARGENT");
        this.formIoUtil.searchAndSelect(depositType, "ESPECES");
    }
}
