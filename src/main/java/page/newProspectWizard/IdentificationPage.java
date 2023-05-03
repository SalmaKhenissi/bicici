package page.newProspectWizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IdentificationPage extends BaseNewProspectWizard {

    private final String SCROLL_ARG = "window.scrollBy(0,350)";

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
        this.jsDriver.executeScript(SCROLL_ARG);
        this.setCivilStatus();
        this.jsDriver.executeScript(SCROLL_ARG);
        this.setOriginInfo();
        this.jsDriver.executeScript(SCROLL_ARG);
        this.setBirthInfo();
        this.jsDriver.executeScript(SCROLL_ARG);
        this.setFamilyStatus();
        this.jsDriver.executeScript(SCROLL_ARG);
        this.setInChargeInfo();
        this.jsDriver.executeScript(SCROLL_ARG);
        this.setLegalCapacity();
        this.jsDriver.executeScript(SCROLL_ARG);
        this.setCreditInfo();
        this.jsDriver.executeScript("arguments[0].click();", this.getDriver().findElement(this.nextButton));

        return new ContactDetailsPage(this.getDriver());
    }

    private void setClientCategory() throws InterruptedException {
        this.formIoUtil.searchAndSelect(clientCategory,"TRESOR PUBLIC");
    }

    private void setCivilStatus() throws InterruptedException  {
        this.formIoUtil.clickOnChoiceItem(civility, "monsieur");
        this.formIoUtil.searchAndSelect(nationalityCountry, "Tunisie");
        this.formIoUtil.clickOnChoiceItem(gender, "MALE");
        this.formIoUtil.searchAndSelect(doubleNationalityCountry, "BRESIL");
        this.getDriver().findElement(lastName).sendKeys("lastname");
        this.getDriver().findElement(firstName).sendKeys("firstName");
        this.formIoUtil.searchAndSelect(matriculationCountry, "Tunisie");
        this.formIoUtil.clickOnRadioButton(isResident, "true");
    }

    private void setOriginInfo() throws InterruptedException {
        this.formIoUtil.searchAndSelect(KYCCountry, "Tunisie");
        this.formIoUtil.searchAndSelect(EERMotif, "SPONTANEE");
        this.formIoUtil.searchAndSelect(EERMode, "AGENCE");
    }

    private void setBirthInfo() throws InterruptedException {
        this.dateUtils.selectDate(birthdate,"28/03/2004");
        this.getDriver().findElement(motherName).sendKeys("mère");
        this.getDriver().findElement(birthPlace).sendKeys("birthplace");
        this.formIoUtil.searchAndSelect(birthCountry, "Tunisie");
    }

    private void setFamilyStatus() throws InterruptedException {
        this.formIoUtil.clickOnChoiceItem(familyStatus, "CELIBATAIRE");
    }

    private void setInChargeInfo() {
        this.getDriver().findElement(childrenNumber).sendKeys("0");
        this.getDriver().findElement(personsInChargeNumber).sendKeys("0");
    }

    private void setLegalCapacity() {
        this.formIoUtil.clickOnSelectOption(legalCapacityType, "Majeur incapable");
//        this.formIoUtil.setDateInput(this.getDriver().findElement(legalCapacityDate),"28/03/2023");
    }

    private void setCreditInfo() {
        this.formIoUtil.clickOnSelectOption(creditConsent, "accordClient");
        this.dateUtils.setDateInput(collectionDate,"28/03/2023");
        this.getDriver().findElement(taxpayerAccount).sendKeys("123");
    }
}
