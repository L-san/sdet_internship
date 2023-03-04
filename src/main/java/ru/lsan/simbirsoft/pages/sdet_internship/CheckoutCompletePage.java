package ru.lsan.simbirsoft.pages.sdet_internship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private final By completeHeader = By.className("complete-header");
    private final WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCompleteHeaderText() {
        return driver.findElement(completeHeader).getText();
    }

}
