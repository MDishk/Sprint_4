package PageObject;

import org.openqa.selenium.By;
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

    //Локаторы для полей и кнопок на странице "Для кого самокат"
    private final By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationsInput = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By stationsList = By.xpath(".//ul[@class = 'select-search__options']");
    private final By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By fartherButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локаторы для полей и кнопок на странице "Про аренду"
    private final By calendarInput = By.xpath(".//div[@class = 'react-datepicker__input-container']/input");
    private final By rentalPeriodInput = By.xpath(".//div[@class = 'Dropdown-control']");
    private final By rentalPeriodMenu = By.xpath(".//div[@class = 'Dropdown-menu']");
    private final By scootersColour = By.xpath(".//label[@for = 'black']");
    private final By orderButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Заказать')]");
    private final By createdOrderButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Да')]");
    private final By createdOrderWindow = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']");
    public boolean isOrderWindowDisplayed() {
        return driver.findElement(createdOrderWindow).isDisplayed();
    }
    //Ввод имени
    public OrderPages enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    //Ввод фамилии
    public OrderPages enterSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
        return this;
    }

    //Ввод адреса
    public OrderPages enterAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
        return this;
    }

    //Выбор случайной станции метро
    public OrderPages chooseMetroStation() {
        driver.findElement(metroStationsInput).click();
        List<WebElement> metroStationsList = driver.findElements(stationsList);
        metroStationsList.get(new Random().nextInt(metroStationsList.size())).click();
        return this;
    }

    //Ввод телефона
    public OrderPages enterPhone(String number) {
        driver.findElement(phoneInput).sendKeys(number);
        return this;
    }

    //Клик по кнопке "Далее"
    public OrderPages clickFartherButton() {
        driver.findElement(fartherButton).click();
        return this;
    }

    //Автоматический выбор даты
    private static String getFutureDate() {
        LocalDate date = LocalDate.now().plusDays(2);
        return String.valueOf(date.getDayOfMonth());
    }

    //Выбор даты заказа самоката в календаре
    public OrderPages clickCalendarAndChooseDate() {
        driver.findElement(calendarInput).click();
        String futureDate = getFutureDate();
        driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='" + futureDate + "']")).click();
        return this;
    }

    //Выбор случайного срока аренды
    public OrderPages chooseRentalPeriod() {
        driver.findElement(rentalPeriodInput).click();
        List<WebElement> periodMenu = driver.findElements(rentalPeriodMenu);
        periodMenu.get(new Random().nextInt(periodMenu.size())).click();
        return this;
    }

    //Выбор чёрного цвета самоката
    public OrderPages chooseScootersColour() {
        driver.findElement(scootersColour).click();
        return this;
    }

    //Оформление заказа с помощью кнопок "Заказать" и "Да"
    public OrderPages createdScooterOrder() {
        driver.findElement(orderButton).click();
        driver.findElement(createdOrderButton).click();
        return this;
    }
}