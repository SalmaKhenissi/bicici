package page.newprospectwizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IdentificationPage extends BaseNewProspectWizard {

    private By clientCategory = By.className("formio-component-categorie_client");

    private By civility = By.className("formio-component-gender");
    private By nationalityCountry = By.className("formio-component-nationalite");
    private By gender = By.className("formio-component-sexe");
    private By doubleNationalityCountry = By.className("formio-component-double_nationalite");
    private By lastName = By.name("data[user_identity_last_name]");
    private By firstName = By.name("data[user_identity_first_name]");
    private By matriculationCountry = By.className("formio-component-pays_immatriculation");
    private By isResident = By.className("formio-component-residentUs");

    private By KYCCountry = By.className("formio-component-paysDeRealisationDuKyc1");
    private By EERMotif = By.className("formio-component-motifEER");
    private By EERMode = By.className("formio-component-modaliteEER");

    private By birthdate = By.name("data[birthDate]");
    private By motherName = By.name("data[prenom_mere]");
    private By birthPlace = By.name("data[lieu_naissance1]");
    private By birthCountry = By.className("formio-component-pays_naissance");
    private By CNINumber = By.name("data[numeroDeCni]");

    private By familyStatus = By.className("formio-component-situation_famille");
    private By matrimonialRegime = By.className("formio-component-regime_matrimonial");


    private By childrenNumber = By.name("data[nombre_enfants]");
    private By childGender = By.className("formio-component-enfant_sexe");
    private By childCSP = By.className("formio-component-csp");

    private By personsInChargeNumber = By.name("data[nombre_personne_charge]");
    private By personsInChargeCivility = By.className("formio-component-civilite_personne_charge");
    private By personsInChargeGender = By.className("formio-component-pc_sexe");
    private By personsInChargeCSP = By.className("formio-component-pc_csp");

    private By legalCapacityType = By.name("data[type_capacite_juridique]");
    private By legalCapacityDate = By.name("data[credit_date_effet]");

    private By creditConsent = By.name("data[consentement_credit_bureau]");
    private By collectionDate = By.name("data[date_receuil]");
    private By taxpayerAccount = By.name("data[compte_contribuable]");

    public IdentificationPage(WebDriver driver) {
        super(driver);
    }

    public ContactDetailsPage saveIdentification() throws InterruptedException {
        this.setClientCategory();
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.setCivilStatus();
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.setOriginInfo();
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.setBirthInfo();
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.setFamilyStatus();
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.setInChargeInfo();
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.setLegalCapacity();
        this.jsDriver.executeScript("window.scrollBy(0,350)", "");
        this.setCreditInfo();
        this.jsDriver.executeScript("arguments[0].click();", this.getDriver().findElement(this.nextButton));

        return new ContactDetailsPage(this.getDriver());
    }

    private void setClientCategory() throws InterruptedException {
        this.formIoUtil.clickOnChoiceItem(this.getDriver(), clientCategory,"110");
    }

    private void setCivilStatus() throws InterruptedException  {
        this.formIoUtil.clickOnChoiceItem(this.getDriver(), civility, "monsieur");
        this.formIoUtil.searchAndSelect(this.getDriver().findElement(nationalityCountry), "Tunisie");
        this.formIoUtil.clickOnChoiceItem(this.getDriver(), gender, "MALE");
        this.formIoUtil.searchAndSelect(this.getDriver().findElement(doubleNationalityCountry), "BRESIL");
        this.getDriver().findElement(lastName).sendKeys("lastname");
        this.getDriver().findElement(firstName).sendKeys("firstName");
        this.formIoUtil.searchAndSelect(this.getDriver().findElement(matriculationCountry), "Tunisie");
        this.formIoUtil.clickOnRadioButton(this.getDriver().findElement(isResident), "false" , this.jsDriver);
    }

    private void setOriginInfo() throws InterruptedException {
        this.formIoUtil.searchAndSelect(this.getDriver().findElement(KYCCountry), "Tunisie");
        this.formIoUtil.clickOnChoiceItem(this.getDriver(), EERMotif, "SPONTANEE");
        this.formIoUtil.clickOnChoiceItem(this.getDriver(), EERMode, "AGENCE");
    }

    private void setBirthInfo() throws InterruptedException {
//        this.formIoUtil.setDateInput(this.getDriver().findElement(birthdate),"28/03/2023");
        this.getDriver().findElement(motherName).sendKeys("mère");
        this.getDriver().findElement(birthPlace).sendKeys("birthplace");
        this.formIoUtil.searchAndSelect(this.getDriver().findElement(birthCountry), "Tunisie");
    }

    private void setFamilyStatus() throws InterruptedException {
        this.formIoUtil.clickOnChoiceItem(this.getDriver(), familyStatus, "CELIBATAIRE");
    }

    private void setInChargeInfo() {
        this.getDriver().findElement(childrenNumber).sendKeys("0");
        this.getDriver().findElement(personsInChargeNumber).sendKeys("0");
    }

    private void setLegalCapacity() {
        this.formIoUtil.clickOnSelectOption(this.getDriver().findElement(legalCapacityType), "Majeur incapable");
//        this.formIoUtil.setDateInput(this.getDriver().findElement(legalCapacityDate),"28/03/2023");
    }

    private void setCreditInfo() {
        this.formIoUtil.clickOnSelectOption(this.getDriver().findElement(creditConsent), "accordClient");
        this.formIoUtil.setDateInput(this.getDriver().findElement(collectionDate),"28/03/2023");
        this.getDriver().findElement(taxpayerAccount).sendKeys("123");
    }
}
