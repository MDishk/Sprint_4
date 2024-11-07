import org.junit.Assert;
import org.junit.Test;

public class ScooterOrderingTest extends BaseClassTest {

    @Test
    public void scooterOrderingUpButtonTest() {

        mainPage.clickOrderUpButton();

        orderPages
                .enterInfoAboutCustomer("Сатору", "Годжо", "Киото", "+79999999999")
                .enterInfoAboutRent()
                .createdScooterOrder();

        Assert.assertTrue("Заказ не удалось оформить", orderPages.isOrderWindowDisplayed());
    }

    @Test
    public void scooterOrderingMiddleButtonTest() {

        mainPage
                .scrollPageToOrderButton()
                .clickOrderMiddleButton();

        orderPages
                .enterInfoAboutCustomer("Ичиго", "Куросаки", "Каракура", "+78888888888")
                .enterInfoAboutRent()
                .createdScooterOrder();

        Assert.assertTrue("Заказ не удалось оформить", orderPages.isOrderWindowDisplayed());
    }
}