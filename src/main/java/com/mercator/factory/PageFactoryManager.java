package com.mercator.factory;

import com.mercator.pages.LoginPage;
import com.mercator.pages.OrderSummaryPage;
import com.mercator.pages.ProductsInformationPage;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsInformationPage productsInformationPage;
    private OrderSummaryPage orderSummaryPage;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);  // Initialize LoginPage
        }
        return loginPage;
    }

    public ProductsInformationPage getProductsInformationPage() {
        if (productsInformationPage == null) {
            productsInformationPage = new ProductsInformationPage(driver);  // Initialize ProductsInformationPage
        }
        return productsInformationPage;
    }

    public OrderSummaryPage getOrderSummaryPage() {
        if (orderSummaryPage == null) {
            orderSummaryPage = new OrderSummaryPage(driver);  // Initialize OrderSummaryPage
        }
        return orderSummaryPage;
    }

}
