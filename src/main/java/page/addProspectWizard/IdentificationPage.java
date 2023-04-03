package page.addProspectWizard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.FormIoUtil;

public class IdentificationPage {

    private WebDriver driver;
    private JavascriptExecutor jsDriver;
    private FormIoUtil formIoUtil;

    private By clientCategory = By.className("test-clientCategory");

    private By civility = By.className("test-civility");
    private By nationalityCountry = By.className("test-NationalityCountry");
    private By gender = By.className("test-gender");
    private By doubleNationalityCountry = By.className("test-doubleNationalityCountry");
    private By lastName = By.xpath("//*[@name = 'data[user_identity_last_name]']");
    private By firstName = By.xpath("//*[@name = 'data[user_identity_first_name]']");
    private By matriculationCountry = By.className("test-matriculationCountry");
    private By isResident = By.className("test-isResident");

    private By KYCCountry = By.className("test-KYCCountry");
    private By EERMotif = By.className("test-EERMotif");
    private By EERMode = By.className("test-EERMode");

    private By birthdate = By.xpath("//*[@name = 'data[birthDate]']");
    private By motherName = By.xpath("//*[@name = 'data[prenom_mere]']");
    private By birthPlace = By.xpath("//*[@name = 'data[lieu_naissance1]']");
    private By birthCountry = By.className("test-birthCountry");
    private By CNINumber = By.className("test-CNINumber");

    private By familyStatus = By.className("test-familyStatus");


    private By childrenNumber = By.xpath("//*[@name = 'data[nombre_enfants]']");
    private By personsInChargeNumber = By.xpath("//*[@name = 'data[nombre_personne_charge]']");

    private By legalCapacityType = By.xpath("//*[@name = 'data[type_capacite_juridique]']");
    private By legalCapacityDate = By.xpath("//*[@name = 'data[credit_date_effet]']");

    private By creditConsent = By.xpath("//*[@name = 'data[consentement_credit_bureau]']");
    private By collectionDate = By.xpath("//*[@name = 'data[date_receuil]']");
    private By taxpayerAccount = By.xpath("//*[@name = 'data[compte_contribuable]']");

    public IdentificationPage(WebDriver driver) {
        this.driver = driver;
        this.formIoUtil = new FormIoUtil();
        this.jsDriver = (JavascriptExecutor) driver;
    }

    public void saveIdentification() throws InterruptedException {
        this.setClientCategory();
        this.setCivilStatus();
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.setOriginInfo();
        this.setBirthInfo();
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.setFamilyStatus();
        this.setInChargeInfo();
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.setLegalCapacity();
        this.setCreditInfo();
    }

    private void setClientCategory() throws InterruptedException {
        this.formIoUtil.clickOnChoiceItem(driver, clientCategory,"110");
    }

    private void setCivilStatus() throws InterruptedException  {
        this.formIoUtil.clickOnChoiceItem(driver, civility, "monsieur");
        this.formIoUtil.clickOnChoiceItem(driver, nationalityCountry, "AE");
        this.formIoUtil.clickOnChoiceItem(driver, gender, "MALE");
        this.formIoUtil.clickOnChoiceItem(driver, doubleNationalityCountry, "AD");
        driver.findElement(lastName).sendKeys("test lastname");
        driver.findElement(firstName).sendKeys("test firstName");
        this.formIoUtil.clickOnChoiceItem(driver, matriculationCountry, "AF");
    }

    private void setOriginInfo() throws InterruptedException {
        this.formIoUtil.clickOnChoiceItem(driver, KYCCountry, "AF");
        this.formIoUtil.clickOnChoiceItem(driver, EERMotif, "SPONTANEE");
        this.formIoUtil.clickOnChoiceItem(driver, EERMode, "AGENCE");
    }

    private void setBirthInfo() throws InterruptedException {
        this.formIoUtil.setDateInput(driver.findElement(birthdate),"28/03/2023");
        driver.findElement(motherName).sendKeys("test mère");
        driver.findElement(birthPlace).sendKeys("test birthplace");
        this.formIoUtil.clickOnChoiceItem(driver, birthCountry, "AF");
    }

    private void setFamilyStatus() throws InterruptedException {
        this.formIoUtil.clickOnChoiceItem(driver, familyStatus, "CELIBATAIRE");
    }

    private void setInChargeInfo() {
        driver.findElement(childrenNumber).sendKeys("0");
        driver.findElement(personsInChargeNumber).sendKeys("0");
    }

    private void setLegalCapacity() {
        this.formIoUtil.clickOnSelectOption(driver.findElement(legalCapacityType), "Majeur incapable");
        this.formIoUtil.setDateInput(driver.findElement(legalCapacityDate),"28/03/2023");
    }

    private void setCreditInfo() {
        this.formIoUtil.clickOnSelectOption(driver.findElement(creditConsent), "accordClient");
        this.formIoUtil.setDateInput(driver.findElement(collectionDate),"28/03/2023");
        driver.findElement(taxpayerAccount).sendKeys("test 123");
    }
}
