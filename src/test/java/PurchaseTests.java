import com.codeborne.selenide.Configuration;
import database.SqlHelper;
import database.model.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page_objects.PurchasePage;

public class PurchaseTests {

    @BeforeAll
    public static void setUp() {
        Configuration.timeout = 20_000;
    }

    @Test
    void paymentByActiveCardValidData() {
        new PurchasePage()
                .clickButton("Купить")
                .enterValue("Номер карты", "4444 4444 4444 4441")
                .enterValue("Месяц", "11")
                .enterValue("Год", "25")
                .enterValue("CVC/CVV", "123")
                .enterValue("Владелец", "test")
                .clickButton("Продолжить")
                .checkSuccess();
        SqlHelper.checkPaymentStatus(Status.APPROVED);
    }

    @Test
    void paymentCreditWithActiveCardValidData() {
        new PurchasePage()
                .clickButton("Купить в кредит")
                .enterValue("Номер карты", "4444 4444 4444 4441")
                .enterValue("Месяц", "11")
                .enterValue("Год", "23")
                .enterValue("CVC/CVV", "333")
                .enterValue("Владелец", "test")
                .clickButton("Продолжить")
                .checkSuccess();
        SqlHelper.checkCreditStatus(Status.APPROVED);
    }

    @Test
    void paymentWithInactiveCardValidData() {
        new PurchasePage()
                .clickButton("Купить")
                .enterValue("Номер карты", "4444 4444 4444 4442")
                .enterValue("Месяц", "11")
                .enterValue("Год", "24")
                .enterValue("CVC/CVV", "111")
                .enterValue("Владелец", "test")
                .clickButton("Продолжить")
                .checkDeclined();
        SqlHelper.checkPaymentStatus(Status.DECLINED);
    }

    @Test
    void paymentCreditWithInactiveCardValidData() {
        new PurchasePage()
                .clickButton("Купить в кредит")
                .enterValue("Номер карты", "4444 4444 4444 4442")
                .enterValue("Месяц", "10")
                .enterValue("Год", "26")
                .enterValue("CVC/CVV", "222")
                .enterValue("Владелец", "test")
                .clickButton("Продолжить")
                .checkDeclined();
        SqlHelper.checkCreditStatus(Status.DECLINED);
    }

    @Test
    void paymentByActiveCardIncorrectValuesInNameField() {
        new PurchasePage()
                .clickButton("Купить")
                .enterValue("Номер карты", "4444 4444 4444 4441")
                .enterValue("Месяц", "11")
                .enterValue("Год", "25")
                .enterValue("CVC/CVV", "123")
                .enterValue("Владелец", "")
                .clickButton("Продолжить")
                .checkFieldHaveText("Владелец", "Поле обязательно для заполнения");
    }

    @Test
    void paymentByActiveCardIncorrectValuesInYearField() {
        new PurchasePage()
                .clickButton("Купить")
                .enterValue("Номер карты", "4444 4444 4444 4441")
                .enterValue("Месяц", "11")
                .enterValue("Год", "11")
                .enterValue("CVC/CVV", "123")
                .enterValue("Владелец", "test")
                .clickButton("Продолжить")
                .checkFieldHaveText("Год", "Истёк срок действия карты");
    }

    @Test
    void paymentWithAnInactiveCardInvalidValuesInMonthField() {
        new PurchasePage()
                .clickButton("Купить")
                .enterValue("Номер карты", "4444 4444 4444 4442")
                .enterValue("Месяц", "")
                .enterValue("Год", "26")
                .enterValue("CVC/CVV", "222")
                .enterValue("Владелец", "test")
                .clickButton("Продолжить")
                .checkFieldHaveText("Месяц", "Неверный формат");
    }

    @Test
    void paymentOnCreditWithAnInactiveCardInvalidValuesInCodeField() {
        new PurchasePage()
                .clickButton("Купить")
                .enterValue("Номер карты", "4444 4444 4444 4442")
                .enterValue("Месяц", "11")
                .enterValue("Год", "24")
                .enterValue("CVC/CVV", "11")
                .enterValue("Владелец", "test")
                .clickButton("Продолжить")
                .checkFieldHaveText("CVC/CVV", "Неверный формат");
    }

    @AfterEach
    public void afterEach() {
        SqlHelper.clearAllData();
    }
}
