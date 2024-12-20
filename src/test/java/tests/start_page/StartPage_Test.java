package tests.start_page;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.*;
import pages.start_page.StartPage;
import readConfiguraton.ConfigProvider;


@Epic("Тестирование Cтартовой страницы")
public class StartPage_Test extends StartPage {

    @BeforeAll
    public static void globalSetUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .includeSelenideSteps(true)
        );
        // System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver/chromedriver");
        Configuration.browserSize = ConfigProvider.BROWSER;
        Configuration.browserSize = ConfigProvider.SIZE;
        open(ConfigProvider.URL);
    }

    @Feature("Заголовок и логотип")
    @Test
    @Description("Позитивный. Проверка заголовка страницы, логотипа")
    public void testCheckTitilePage() {
        String actualResult = getTitlePage();
        String expectedResult = "AgentApp";
        Assertions.assertEquals(expectedResult, actualResult);
        Assertions.assertTrue(getLogo());
    }

    @Feature("Заголовок и логотип")
    @Test
    @Description("Позитивный. Проверка наличия поля email, кнопки Войти, ссылки 'Забыли пароль?")
    public void testCheckEnterButton() {
        Boolean actualResultEmail = getLogin();
        Boolean actualResultEnterButton = getEnterButton();
        Boolean actualResultForgotPass = getForgotPassword();
        Assertions.assertTrue(actualResultEmail);
        Assertions.assertTrue(actualResultEnterButton);
        Assertions.assertTrue(actualResultForgotPass);
    }

    @Feature("Заголовок и логотип")
    @Test
    @Description("Позитивный. Проверка появления поля Пароль после успешного ввода Email ")
    public void testCheckPassworFiled() {
        setLogin(ConfigProvider.LOGIN);
        Boolean actualResultPassword = getPassword();
        Assertions.assertTrue(actualResultPassword);
    }
}
