package com.mercator.stepdefinitions;

import com.mercator.factory.PageFactoryManager;
import com.mercator.pages.LoginPage;
import com.mercator.pages.OrderSummaryPage;
import com.mercator.pages.ProductsInformationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsInformationPage productsInfoPage;
    private OrderSummaryPage orderSummaryPage;
    private  PageFactoryManager pageFactoryManager;
    private Double highestPrice;


    public LoginSteps(ExecutionHooks hooks) {
        this.driver = hooks.getDriver();
        this.pageFactoryManager = new PageFactoryManager(driver);
        this.loginPage = pageFactoryManager.getLoginPage();
        this.productsInfoPage = pageFactoryManager.getProductsInformationPage();
        this.orderSummaryPage = pageFactoryManager.getOrderSummaryPage();
    }

    @Given("User is on the SauceDemo login page")
    public void user_is_on_login_page() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);
    }

    @When("User enters valid credentials and logs in")
    public void user_enters_valid_credentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Then("User should see the available products information page")
    public void user_in_products_information_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @When("User added the highest priced item to the cart")
    public void user_added_highest_priced_item_to_cart() {
        highestPrice = productsInfoPage.addHighestPricedItemToCart();
    }

    @Then("User should see the highest priced item in the cart")
    public void user_sees_highest_priced_item_in_cart() throws InterruptedException {
        productsInfoPage.goToShoppingCart();
        Double priceInCart = orderSummaryPage.getCartedItemPrice();
        Assert.assertEquals("Product price in the cart is not matching with the expected highest Price", highestPrice, priceInCart);
    }
}
