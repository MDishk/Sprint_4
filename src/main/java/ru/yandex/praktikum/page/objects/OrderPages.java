package ru.yandex.praktikum.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class OrderPages {
    private static WebDriver driver;

    public OrderPages(WebDriver driver) {
        OrderPages.driver = driver;
    }

    //Локатор для поля с именем
    private final By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор для поля с фамилией
    private final By surnameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор для поля с адресом
    private final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор для поля со станцией метро
    private final By metroStationsInput = By.xpath(".//input[@placeholder='* Станция метро']");
    //Локатор для списка со станциями метро
    private final By stationsList = By.xpath(".//ul[@class = 'select-search__options']");
    //Локатор для поля с номером телефона
    private final By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор для кнопки "Далее"
    private final By fartherButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локатор для поля с датой доставки самоката
    private final By calendarInput = By.xpath(".//div[@class = 'react-datepicker__input-container']/input");
    //Локатор для поля со сроком аренды самоката
    private final By rentalPeriodInput = By.xpath(".//div[@class = 'Dropdown-control']");
    //Локатор для списка с выбором срока аренды
    private final By rentalPeriodMenu = By.xpath(".//div[@class = 'Dropdown-menu']");
    //Локатор для чекбокса с цветом самоката
    private final By scootersColour = By.xpath(".//label[@for = 'black']");
    //Локатор для кнопки "Заказать"
    private final By orderButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Заказать')]");
    //Локатор для кнопки "Да", которая подтверждает оформление заказа
    private final By createdOrderButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Да')]");
    //Локатор для окна с оформленным заказом
    private final By createdOrderWindow = By.xpath(".//div[contains(@class, 'Order_ModalHeader__3FDaJ') and (text() = 'Заказ оформлен')]");

    //Ввод имени
    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    //Ввод фамилии
    public void enterSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }

    //Ввод адреса
    public void enterAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    //Выбор случайной станции метро
    public void chooseMetroStation() {
        driver.findElement(metroStationsInput).click();
        List<WebElement> metroStationsList = driver.findElements(stationsList);
        metroStationsList.get(new Random().nextInt(metroStationsList.size())).click();
    }

    //Ввод телефона
    public void enterPhone(String number) {
        driver.findElement(phoneInput).sendKeys(number);
    }

    //Клик по кнопке "Далее"
    public void clickFartherButton() {
        driver.findElement(fartherButton).click();
    }

    //Общий метод для заполнения всех полей на странице "Для кого самокат"
    public OrderPages enterInfoAboutCustomer(String name, String surname, String address, String number) {
        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        chooseMetroStation();
        enterPhone(number);
        clickFartherButton();
        return this;
    }

    //Настройка автоматического выбора даты
    private static String getFutureDate() {
        LocalDate date = LocalDate.now().plusDays(2);
        return String.valueOf(date.getDayOfMonth());
    }

    //Автоматический выбор даты в будущем: +2 дня к актуальной дате
    public void clickCalendarAndChooseDate() {
        driver.findElement(calendarInput).sendKeys(getFutureDate());
        driver.findElement(calendarInput).sendKeys(Keys.ENTER);
    }

    //Выбор случайного срока аренды
    public void chooseRentalPeriod() {
        driver.findElement(rentalPeriodInput).click();
        List<WebElement> periodMenu = driver.findElements(rentalPeriodMenu);
        periodMenu.get(new Random().nextInt(periodMenu.size())).click();
    }

    //Выбор чёрного цвета самоката
    public void chooseScootersColour() {
        driver.findElement(scootersColour).click();
    }

    //Оформление заказа с помощью кнопок "Заказать" и "Да"
    public void createdScooterOrder() {
        driver.findElement(orderButton).click();
        driver.findElement(createdOrderButton).click();
    }
    //Общий метод для заполнения страницы "Про аренду"
    public OrderPages enterInfoAboutRent() {
        clickCalendarAndChooseDate();
        chooseRentalPeriod();
        chooseScootersColour();
        return this;
    }

    //Проверка на отображение окна со сформированным заказом
    public boolean isOrderWindowDisplayed() {
        return driver.findElement(createdOrderWindow).isDisplayed();
    }
}