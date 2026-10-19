package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import framewrk.CartPage;
import framewrk.CheckoutPage;
import framewrk.ConfirmationPage;
import framewrk.LandingPage;
import framewrk.Productcart;
import framewrk.Productcartmjds;
import utils.ConfigReader;

public class SubmitOrderTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void submitOrder() throws InterruptedException {

        String productName = "ADIDAS ORIGINAL";

        // 1. Open the site and log in
        LandingPage landing = new LandingPage(driver);
        landing.goTo();
        Productcart catalogue = landing.application(
                ConfigReader.get("email"), ConfigReader.get("password"));

        // 2. Add the product
        catalogue.addProductToCart(productName);

        // 3. Go to the cart and check the product is there
        CartPage cart = catalogue.goToCartPage();
        Assert.assertTrue(cart.VerifyProductDisplay(productName));

        // 4. Checkout
        CheckoutPage checkout = cart.goToheckout();
        checkout.selectCountry("india");

        // 5. Place the order and check the message
        ConfirmationPage confirmation = checkout.submitOrder();
        String message = confirmation.getConfirmationMessage();
        Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }
}