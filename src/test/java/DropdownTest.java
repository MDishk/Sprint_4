import PageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static PageObject.MainPage.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class DropdownTest {

    private WebDriver driver;

    private final String questionLocator;
    private final String answerLocator;
    private final String answerText;

    public DropdownTest(String questionLocator, String answerLocator, String answerText) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.answerText = answerText;
    }

    @Parameterized.Parameters
    public static Object[][] expectedAnswersParamList() {
        return new Object[][]{
                {".//div[@id = 'accordion__heading-0']", ".//div[@id = 'accordion__panel-0']", HOW_MUCH_ANSWERED},
                {".//div[@id = 'accordion__heading-1']", ".//div[@id = 'accordion__panel-1']", MANY_SCOOTERS_ANSWERED},
                {".//div[@id = 'accordion__heading-2']", ".//div[@id = 'accordion__panel-2']", RENT_TIME_ANSWERED},
                {".//div[@id = 'accordion__heading-3']", ".//div[@id = 'accordion__panel-3']", TODAY_RENT_ANSWERED},
                {".//div[@id = 'accordion__heading-4']", ".//div[@id = 'accordion__panel-4']", EXTEND_ORDER_ANSWERED},
                {".//div[@id = 'accordion__heading-5']", ".//div[@id = 'accordion__panel-5']", CHARGE_FOR_SCOOTER_ANSWERED},
                {".//div[@id = 'accordion__heading-6']", ".//div[@id = 'accordion__panel-6']", CANCEL_ORDER_ANSWERED},
                {".//div[@id = 'accordion__heading-7']", ".//div[@id = 'accordion__panel-7']", LIVE_MKAD_ANSWERED}
        };
    }

    @Before
    public void StartUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        //Полное окно браузера и неявные ожидания
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

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
    public void checkDropdownText() {

        MainPage mainPage = new MainPage(driver);
        mainPage.scrollPage();
        mainPage.clickQuestionsFAQ(questionLocator);

        String actualAnswerText = driver.findElement(By.xpath(answerLocator)).getText();
        System.out.println("В выпадающем ответе корректный текст: " + answerText);
        assertEquals("В выпадающем ответе должен быть другой текст", answerText, actualAnswerText);
    }
}