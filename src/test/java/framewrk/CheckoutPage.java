package framewrk;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstarctpac.Abstractpackage;

public class CheckoutPage extends Abstractpackage {

    

    public CheckoutPage(WebDriver driver) {
        super(driver);
        
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;

    @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
    WebElement selectCountry;

    @FindBy(css = ".action__submit")
    WebElement submit;

    By results = By.cssSelector(".ta-results");

    public void selectCountry(String countryName) {
        Actions a = new Actions(driver);
        a.sendKeys(country, countryName).build().perform();
        waitForElementToAppear(results);
        selectCountry.click();
    }

    public ConfirmationPage submitOrder() throws InterruptedException {
        // Scroll button into view & use JavaScript click to prevent interception issues
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", submit);
        return new ConfirmationPage(driver);
    }
}