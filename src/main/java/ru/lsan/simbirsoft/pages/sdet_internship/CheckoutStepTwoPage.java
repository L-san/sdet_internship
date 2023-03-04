package ru.lsan.simbirsoft.pages.sdet_internship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage {

    private final By finishButton = By.id("finish");
    private final WebDriver driver;

    public CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutCompletePage clickFinishButton() {
        driver.findElement(finishButton).click();
        return new CheckoutCompletePage(driver);
    }

}
