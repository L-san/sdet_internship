package ru.lsan.simbirsoft.pages.sdet_internship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.className("error-message-container");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String name) {
        driver.findElement(username).sendKeys(name);
    }

    public void setPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public InventoryPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new InventoryPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public InventoryPage login(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

}
