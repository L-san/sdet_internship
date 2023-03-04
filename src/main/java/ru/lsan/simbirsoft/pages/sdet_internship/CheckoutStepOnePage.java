package ru.lsan.simbirsoft.pages.sdet_internship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage {

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final WebDriver driver;

    public CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
    }

    public void setLastName(String name) {
        driver.findElement(lastName).sendKeys(name);
    }

    public void setZipCode(String zip) {
        driver.findElement(zipCode).sendKeys(zip);
    }

    public CheckoutStepTwoPage clickContinueButton() {
        driver.findElement(continueButton).click();
        return new CheckoutStepTwoPage(driver);
    }

    public CheckoutStepTwoPage setInfoAndContinue(String firstName, String lastName, String zipCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setZipCode(zipCode);
        return clickContinueButton();
    }

}
