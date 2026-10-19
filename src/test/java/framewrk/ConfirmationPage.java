package framewrk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstarctpac.Abstractpackage;

public class ConfirmationPage extends Abstractpackage {

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".hero-primary")
    WebElement confirmationMessage;

    public String getConfirmationMessage() {
        waitForElementToAppear(By.cssSelector(".hero-primary"));
        return confirmationMessage.getText();
    }
}