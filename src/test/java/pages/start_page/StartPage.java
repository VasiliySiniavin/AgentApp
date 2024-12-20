package pages.start_page;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class StartPage {

    SelenideElement formAuth = $x("//app-login-form/ui-form");
    SelenideElement logo = $x("//div/img");
    SelenideElement loginText = $x("//*[@id=\"username\"]/div/ui-field-title");
    SelenideElement login = $x("//*[@id=\"username\"]/label/input");
    SelenideElement passwordText = $x("//*[@id=\"password\"]/div/ui-field-title");
    SelenideElement password = $(By.id("password"));
    SelenideElement errorText = $x("//ui-field-error");
    SelenideElement passwordUnmask = $x("//label/button");
    SelenideElement enterButton = $x("//div/button");
    SelenideElement forgotPassword = $x("//div/a");

    @Step("Проверка отображения формы авторизации")
    public boolean getFromAuthorization() {
        return formAuth.shouldBe(Condition.visible).isDisplayed();
    }
    @Step("Проверка заголовка страницы")
    public String getTitlePage() {
        return title();
    }
    @Step("Проверка отображения Логотипа")
    public boolean getLogo() {
        return logo.shouldBe(Condition.visible).isDisplayed();
    }
    @Step("Проверка текста поля Логин")
    public boolean getLoginText() {
        return loginText.shouldBe(Condition.visible).isDisplayed();
    }
    @Step("Проверка наличия поля Пароль")
    public boolean getLogin() {
        return login.shouldBe(Condition.visible).isDisplayed();
    }
    @Step("Установить значение в поле Логин")
    public void setLogin(String strLogin) {
        login.click();
        login.setValue(strLogin).pressEnter();
    }
    @Step("Проверка текста поля Пароль")
    public boolean getPasswordText() {
        return passwordText.shouldBe(Condition.visible).isDisplayed();
    }
    @Step("Проверка наличия поля Пароль")
    public boolean getPassword() {
        return password.shouldBe(Condition.visible).isDisplayed();
    }
    @Step("Установить значение в поле Пароль")
    public void setPassword(String strPassword) {
        login.setValue(strPassword).pressEnter();
    }
    @Step("Получить текст ошибки")
    public String getErrorText() {
        return errorText.shouldBe(Condition.visible).getText();
    }
    @Step("Нажать на кнопку 'Пароль'")
    public void getPasswordUnmask() {
        passwordUnmask.shouldBe(Condition.visible).click();
    }
    @Step("Проверка наличия кнопки 'Войти'")
    public boolean getEnterButton() {
        return enterButton.exists();
    }
    @Step("Нажать на кнопку 'Войти'")
    public void clickEnterButton() {
        enterButton.shouldBe(Condition.enabled).click();
    }
    @Step("Проверка наличия гиперссылки 'Забыли пароль?'")
    public boolean getForgotPassword() {
        return forgotPassword.shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Ввод авторизационных данных и нажатие на кнопку 'Войти'")
    public void enterAuthorizationData(String strLogin, String strPassword) {
        this.setLogin(strLogin);
        this.setPassword(strPassword);
        this.clickEnterButton();

    }
}

