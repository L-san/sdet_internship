package ru.lsan.simbirsoft.sdet_internship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.lsan.simbirsoft.pages.sdet_internship.*;

public class TestCases {

    private static String DRIVER_PATH = "C:\\chromedriver"; //вставьте здесь путь к своему chromedriver.exe
    private static String PAGE_LINK = "https://www.saucedemo.com/";
    private static WebDriver driver;

    @BeforeAll
    static void setDriverPath() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
    }

    @BeforeEach
    void getPage() {
        driver.get(PAGE_LINK);
    }

    @AfterAll
    static void quitDriver() {
        driver.quit();
    }

    /**
     * Кейс 1. Проверка успешной покупки
     **/

    @Test
    public void purchaseTest() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        inventoryPage.clickAddToCartButton();
        CartPage cartPage = inventoryPage.clickShoppingCartButton();

        CheckoutStepOnePage checkoutStepOnePage = cartPage.clickCheckoutButton();
        CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.setInfoAndContinue("test", "test", "test");

        CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.clickFinishButton();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";

        String expectedMsg = "Thank you for your order!";
        String actualMsg = checkoutCompletePage.getCompleteHeaderText();

        Assertions.assertEquals(expectedUrl, actualUrl);
        Assertions.assertEquals(expectedMsg, actualMsg);
    }

    /**
     * Кейс 2. Проверка сообщения об ошибке при
     * попытке ввода логина на несуществующего
     * пользователя
     **/

    @Test
    public void wrongCredentialsFormLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test", "test");

        String expectedMsg = "Epic sadface: Username and password do not match any user in this service";
        String actualMsg = loginPage.getErrorMessage();

        Assertions.assertEquals(expectedMsg, actualMsg);
    }

}
