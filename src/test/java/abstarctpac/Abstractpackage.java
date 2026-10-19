package abstarctpac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framewrk.CartPage;

public class Abstractpackage {

    protected WebDriver driver;          // protected: child classes can use it
    protected WebDriverWait wait;        // one shared wait

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    public Abstractpackage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToAppear(By findBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToDisappear(By elementBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    public CartPage goToCartPage() {
        wait.until(ExpectedConditions.elementToBeClickable(cartHeader)).click();
        return new CartPage(driver);
    }
}