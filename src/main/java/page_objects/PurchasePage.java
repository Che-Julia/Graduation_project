package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PurchasePage {
    public PurchasePage() {
        open("http://localhost:8080/");
    }


    @Step("Нажимаем купить")
    public PurchasePage clickButton(String buttonName) {
        $x("//span[text()='" + buttonName + "']/ancestor::button").click();
        return this;
    }

    @Step("Проверяем появление уведомления об успехе")
    public PurchasePage checkSuccess() {
        $x("//div[contains(@class,'notification_status_ok')]/div[@class='notification__title']")
                .shouldHave(Condition.text("Успешно"));
        $x("//div[contains(@class,'notification_status_ok')]/div[@class='notification__content']")
                .shouldHave(Condition.text("Операция одобрена Банком."));
        return this;
    }

    @Step("Проверяем появление уведомления об отклонении операции")
    public PurchasePage checkDeclined() {
        $x("//div[contains(@class,'notification_status_error')]/div[@class='notification__title']")
                .shouldHave(Condition.text("Ошибка"));
        $x("//div[contains(@class,'notification_status_error')]/div[@class='notification__content']")
                .shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции."));
        return this;
    }

    @Step("Проверяем появление уведомления об ошибке в поле Владелец")
    public PurchasePage checkFieldHaveText(String fieldName, String text) {
        $x("//span[@class='input__top' and text()='" + fieldName +
                "']/following-sibling::span[@class='input__sub']")
                .shouldHave(Condition.text(text));
        return this;
    }


    @Step("Вводим в {key} значение {value}")
    public PurchasePage enterValue(String key, String value) {
        SelenideElement input = $x("//span[text()='" + key + "']/following-sibling::span/input");
        input.click();
        input.sendKeys(value);
        return this;
    }
}
