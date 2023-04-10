package page.newprospectwizard;

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

    public void setForeignInfo() {
        this.formIoUtil.clickOnRadioButton(driver.findElement(hasUSPhone), "false");
        this.formIoUtil.clickOnRadioButton(driver.findElement(hasAgentUSAddress), "false");
        this.formIoUtil.clickOnRadioButton(driver.findElement(hasUSCoveredAddress), "false");
        this.formIoUtil.clickOnRadioButton(driver.findElement(hasAgencyAddress), "false");
        this.formIoUtil.clickOnRadioButton(driver.findElement(hasUSEmbassyAddress), "false");
        this.formIoUtil.clickOnRadioButton(driver.findElement(hasUSGreenCard), "false");
        this.formIoUtil.clickOnRadioButton(driver.findElement(hasUSBirthplace), "false");
    }
}
