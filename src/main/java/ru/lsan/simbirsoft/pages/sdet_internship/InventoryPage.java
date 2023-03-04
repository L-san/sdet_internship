package ru.lsan.simbirsoft.pages.sdet_internship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private final By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By shoppingCartButton = By.className("shopping_cart_link");
    private final WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public CartPage clickShoppingCartButton() {
        driver.findElement(shoppingCartButton).click();
        return new CartPage(driver);
    }

}
