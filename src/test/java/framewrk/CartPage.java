package framewrk;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstarctpac.Abstractpackage;

public class CartPage extends Abstractpackage {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartProducts;

    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    public Boolean VerifyProductDisplay(String productName) {
        waitForElementToAppear(By.cssSelector(".cartSection h3"));
        Boolean match = cartProducts.stream()
                .anyMatch(cartProd -> cartProd.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage goToheckout() {
        checkoutEle.click();
        return new CheckoutPage(driver);
    }

	
}