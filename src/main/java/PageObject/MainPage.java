package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private static WebDriver driver;

    //Конструктор, с помощью которого можно передавать драйвер
    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
    }

    //Ссылка на сайт: константа и метод-открывашка браузера по ссылке
    public static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    //Локаторы элементов на главной странице
    private final By cookiesButton = By.xpath(".//button[@id = 'rcc-confirm-button']");
    private final By orderUpButton = By.xpath(".//div[contains(@class, 'Header_Nav')]/button[contains(@class, 'Button_Button')]");
    private final By orderMiddleButton = By.xpath(".//div[@class = 'Home_FinishButton__1_cWm']/button");

    private static final String[] dropdownQuestions = new String[]{
            ".//div[@id = 'accordion__heading-0']",
            ".//div[@id = 'accordion__heading-1']",
            ".//div[@id = 'accordion__heading-2']",
            ".//div[@id = 'accordion__heading-3']",
            ".//div[@id = 'accordion__heading-4']",
            ".//div[@id = 'accordion__heading-5']",
            ".//div[@id = 'accordion__heading-6']",
            ".//div[@id = 'accordion__heading-7']"
    };

    private static final String[] dropdownAnswers = new String[]{
            ".//div[@id = 'accordion__panel-0']",
            ".//div[@id = 'accordion__panel-1']",
            ".//div[@id = 'accordion__panel-2']",
            ".//div[@id = 'accordion__panel-3']",
            ".//div[@id = 'accordion__panel-4']",
            ".//div[@id = 'accordion__panel-5']",
            ".//div[@id = 'accordion__panel-6']",
            ".//div[@id = 'accordion__panel-7']"
    };

    public static final String HOW_MUCH_ANSWERED = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String MANY_SCOOTERS_ANSWERED = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String RENT_TIME_ANSWERED = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String TODAY_RENT_ANSWERED = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String EXTEND_ORDER_ANSWERED = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String CHARGE_FOR_SCOOTER_ANSWERED = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String CANCEL_ORDER_ANSWERED = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String LIVE_MKAD_ANSWERED = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //Открывашка главной страницы сайта
    public void openMainPage() {
        driver.get(MAIN_PAGE_URL);
    }

    //Согласие с куками
    public void agreeWithCookies() {
        driver.findElement(cookiesButton).click();
    }

    //Клик по кнопкам заказа сверху и посередине
    public void clickOrderUpButton() {
        driver.findElement(orderUpButton).click();
    }
    public void clickOrderMiddleButton() {
        driver.findElement(orderMiddleButton).click();
    }
    //Прокрутка до кнопки "Заказать" посередине страницы
    public void scrollPageToOrderButton() {
        WebElement middleOrderButton = driver.findElement(orderMiddleButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", middleOrderButton);
    }

    //Прокрутка до FAQ
    public void scrollPage() {
        WebElement firstQuestionFAQ = driver.findElement(By.xpath(dropdownQuestions[0]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", firstQuestionFAQ);
    }

    //Клик по кнопкам с вопросами
    public void clickQuestionsFAQ(String questionLocator) {
        driver.findElement(By.xpath(questionLocator)).click();
    }
}
