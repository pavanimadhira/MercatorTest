package com.mercator.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsInformationPage extends  BasePage {
    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPriceList;

    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    private String highestPricedItem;

    public ProductsInformationPage(WebDriver driver) {
        super(driver);
    }

    public Double addHighestPricedItemToCart() {
        double highestPrice = 0;
        int productIndex = 0;
       if(productPriceList.size() >= 1) {
           for (int i = 0; i < productPriceList.size(); i++) {
               double price = Double.parseDouble(productPriceList.get(i).getText().replace("$", ""));
               if (price > highestPrice) {
                   highestPrice = price;
                   productIndex = i;
               }
           }
           highestPricedItem = productPriceList.get(productIndex).getText();
           addToCartButtons.get(productIndex).click();
       }
        return highestPrice;
    }

    public void goToShoppingCart() {
        cartIcon.click();
    }
}
