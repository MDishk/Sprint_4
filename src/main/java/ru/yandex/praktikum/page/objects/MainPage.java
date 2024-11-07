package ru.yandex.praktikum.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {

    private final WebDriver driver;
    WebDriverWait wait;

    //Конструктор, с помощью которого можно передавать драйвер
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Ссылка на сайт: константа и метод-открывашка браузера по ссылке
    public static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    //Локатор для кнопки согласия с куками
    private final By cookiesButton = By.xpath(".//button[@id = 'rcc-confirm-button']");
    //Локатор для кнопки "Заказать" вверху страницы
    private final By orderUpButton = By.xpath(".//div[contains(@class, 'Header_Nav')]/button[contains(@class, 'Button_Button')]");
    //Локатор для кнопки "Заказать" посередине страницы
    private final By orderMiddleButton = By.xpath(".//div[@class = 'Home_FinishButton__1_cWm']/button");
    //Локатор для блока FAQ
    private final By blockOfFAQ = By.xpath(".//div[@class = 'accordion']");

    //Массив локаторов кнопок с вопросами в FAQ
    private final By[] questionButtonsArray = {
            By.xpath(".//div[@id = 'accordion__heading-0']"),
            By.xpath(".//div[@id = 'accordion__heading-1']"),
            By.xpath(".//div[@id = 'accordion__heading-2']"),
            By.xpath(".//div[@id = 'accordion__heading-3']"),
            By.xpath(".//div[@id = 'accordion__heading-4']"),
            By.xpath(".//div[@id = 'accordion__heading-5']"),
            By.xpath(".//div[@id = 'accordion__heading-6']"),
            By.xpath(".//div[@id = 'accordion__heading-7']")
    };

    //Массив локаторов строк с ответами в FAQ
    private final By[] answersArray = {
            By.xpath(".//div[@id = 'accordion__panel-0']/p"),
            By.xpath(".//div[@id = 'accordion__panel-1']/p"),
            By.xpath(".//div[@id = 'accordion__panel-2']/p"),
            By.xpath(".//div[@id = 'accordion__panel-3']/p"),
            By.xpath(".//div[@id = 'accordion__panel-4']/p"),
            By.xpath(".//div[@id = 'accordion__panel-5']/p"),
            By.xpath(".//div[@id = 'accordion__panel-6']/p"),
            By.xpath(".//div[@id = 'accordion__panel-7']/p")
    };

    //Константы с текстами вопросов
    public static final String HOW_MUCH_QUESTION = "Сколько это стоит? И как оплатить?";
    public static final String MANY_SCOOTERS_QUESTION = "Хочу сразу несколько самокатов! Так можно?";
    public static final String RENT_TIME_QUESTION = "Как рассчитывается время аренды?";
    public static final String TODAY_RENT_QUESTION = "Можно ли заказать самокат прямо на сегодня?";
    public static final String EXTEND_ORDER_QUESTION = "Можно ли продлить заказ или вернуть самокат раньше?";
    public static final String CHARGE_FOR_SCOOTER_QUESTION = "Вы привозите зарядку вместе с самокатом?";
    public static final String CANCEL_ORDER_QUESTION = "Можно ли отменить заказ?";
    public static final String LIVE_MKAD_QUESTION = "Я жизу за МКАДом, привезёте?";

    //Константы с текстами ответов
    public static final String HOW_MUCH_ANSWER = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String MANY_SCOOTERS_ANSWER = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String RENT_TIME_ANSWER = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String TODAY_RENT_ANSWER = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String EXTEND_ORDER_ANSWER = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String CHARGE_FOR_SCOOTER_ANSWER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String CANCEL_ORDER_ANSWER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String LIVE_MKAD_ANSWER = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //Открывашка главной страницы сайта
    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    //Согласие с куками
    public MainPage agreeWithCookies() {
        driver.findElement(cookiesButton).click();
        return this;
    }

    //Клик по кнопке заказа сверху
    public MainPage clickOrderUpButton() {
        driver.findElement(orderUpButton).click();
        return this;
    }

    //Клик по кнопке заказа посередине
    public MainPage clickOrderMiddleButton() {
        driver.findElement(orderMiddleButton).click();
        return this;
    }

    //Прокрутка до кнопки "Заказать" посередине страницы
    public MainPage scrollPageToOrderButton() {
        WebElement middleOrderButton = driver.findElement(orderMiddleButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", middleOrderButton);
        return this;
    }

    //Прокрутка до FAQ
    public MainPage scrollPageToFAQ() {
        WebElement firstQuestionFAQ = driver.findElement(blockOfFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", firstQuestionFAQ);
        return this;
    }

    //Клик по кнопкам с вопросами
    public MainPage clickQuestionsFAQ(int questionIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionButtonsArray[questionIndex]));
        driver.findElement(questionButtonsArray[questionIndex]).click();
        return this;
    }

    //Получение текста вопросов
    public String getQuestionText(int questionIndex) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionButtonsArray[questionIndex]));
        return driver.findElement(questionButtonsArray[questionIndex]).getText();
    }

    //Получение текста ответов
    public String getAnswerText(int answerIndex) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(answersArray[answerIndex]));
        return driver.findElement(answersArray[answerIndex]).getText();
    }
}