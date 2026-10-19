package framewrk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstarctpac.Abstractpackage;
import utils.ConfigReader;

public class LandingPage extends Abstractpackage {

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement userEmaile;

    @FindBy(xpath = "//input[@id='userPassword']")
    WebElement passwordele;

    @FindBy(id = "login")
    WebElement submit;

    public Productcart application(String email, String password) {
        userEmaile.sendKeys(email);
        passwordele.sendKeys(password);
        submit.click();
        return new Productcart(driver);
    }

    public void goTo() {
        driver.get(ConfigReader.get("url"));
    }
}