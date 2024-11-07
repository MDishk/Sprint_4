import ru.yandex.praktikum.page.objects.OrderPages;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.yandex.praktikum.page.objects.MainPage;

public class BaseClassTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected OrderPages orderPages;

    public void initChrome() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    public void initFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
    }

    @Before
    public void startUp() {
        initChrome();

        //Полное окно браузера
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        orderPages = new OrderPages(driver);

        //Открывашка главной страницы сайта и согласие с куками
        mainPage.openMainPage()
                .agreeWithCookies();
    }

    @After
    public void teardown() {
        // Закрывашка браузера
        driver.quit();
    }
}
