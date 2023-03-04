package ru.lsan.simbirsoft.pages.sdet_internship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final By checkoutButton = By.id("checkout");
    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutStepOnePage clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
        return new CheckoutStepOnePage(driver);
    }

}
