package page.newProspectWizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForeignAccountPage extends BaseNewProspectWizard  {

    private By hasUSPhone = By.className("formio-component-telephoneUs");
    private By hasAgentUSAddress = By.className("formio-component-UnDesMandatairesAvecUneAdresseUS");
    private By hasUSCoveredAddress = By.className("formio-component-AdresseSousCouvertAuxUS");
    private By hasAgencyAddress = By.className("formio-component-AdresseCourrierAgence");
    private By hasUSEmbassyAddress= By.className("formio-component-AdresseAmbassadeUSConsulatUSetBaseMilitaireUShorsSolUS");
    private By hasUSGreenCard = By.className("formio-component-DetenteurGreenCardUS");
    private By hasUSBirthplace = By.className("formio-component-LieuDeNaissanceUS");

    public ForeignAccountPage(WebDriver driver) {
        super(driver);
    }

    public void saveForeignInfo() throws InterruptedException {
        this.formIoUtil.clickOnRadioButton(hasUSPhone, "false");
        Thread.sleep(2000);
        this.formIoUtil.clickOnRadioButton(hasAgentUSAddress, "false");
        Thread.sleep(2000);
        this.formIoUtil.clickOnRadioButton(hasUSCoveredAddress, "false");
        Thread.sleep(2000);
        this.formIoUtil.clickOnRadioButton(hasAgencyAddress, "false");
        this.formIoUtil.clickOnRadioButton(hasUSEmbassyAddress, "false");
        this.formIoUtil.clickOnRadioButton(hasUSGreenCard, "false");
        this.formIoUtil.clickOnRadioButton(hasUSBirthplace, "false");

        this.save();
    }
}
