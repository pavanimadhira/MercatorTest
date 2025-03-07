package com.mercator.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderSummaryPage extends BasePage {

    @FindBy(className = "inventory_item_price")
    private WebElement cartedItemPrice;

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

   /* public String getItemPriceInTheCart() {
        return cartedItemPrice.getText();
    }*/

    public Double getCartedItemPrice() throws InterruptedException {
            String priceText = cartedItemPrice.getText().replace("$", "");
            return Double.parseDouble(priceText);
    }
}
