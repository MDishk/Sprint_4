import PageObject.MainPage;
import PageObject.OrderPages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ScooterOrderingTest {
    private WebDriver driver;

    @Before
    public void StartUp() {
       //Драйвер для Хрома
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        //Драйвер для Фаерфокса
//        FirefoxOptions options = new FirefoxOptions();
//        driver = new FirefoxDriver(options);

        //Полное окно браузера и неявные ожидания
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //Открывашка главной страницы сайта и согласие с куками
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.agreeWithCookies();
    }

    //Закрывашка браузера
    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void scooterOrderingUpButton() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderUpButton();

//        mainPage.scrollPageToOrderButton();
//        mainPage.clickOrderMiddleButton();

        new OrderPages(driver)
                .enterName("Сатору")
                .enterSurname("Годжо")
                .enterAddress("Киото")
                .chooseMetroStation()
                .enterPhone("+79999999999")
                .clickFartherButton()
                .clickCalendarAndChooseDate()
                .chooseRentalPeriod()
                .chooseScootersColour()
                .createdScooterOrder();

        boolean isDisplayed = new OrderPages(driver).isOrderWindowDisplayed();
        assertTrue("Заказ не удалось оформить", isDisplayed);
    }

    @Test
    public void scooterOrderingMiddleButton() {

        MainPage mainPage = new MainPage(driver);
        mainPage.scrollPageToOrderButton();
        mainPage.clickOrderMiddleButton();

        new OrderPages(driver)
                .enterName("Ичиго")
                .enterSurname("Куросаки")
                .enterAddress("Каракура")
                .chooseMetroStation()
                .enterPhone("+78888888888")
                .clickFartherButton()
                .clickCalendarAndChooseDate()
                .chooseRentalPeriod()
                .chooseScootersColour()
                .createdScooterOrder();

        boolean isDisplayed = new OrderPages(driver).isOrderWindowDisplayed();
        assertTrue("Заказ не удалось оформить", isDisplayed);
    }
}