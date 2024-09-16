package tests.start_page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.start_page.StartPage;


@Epic("Тестирование Cтартовой страницы")
public class StartPage_Test extends StartPage {

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
      //  System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver/chromedriver");
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://partner.agentapp.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        open(Configuration.baseUrl);
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
        setLogin("qa@qa.qa");
        Boolean actualResultPassword = getPassword();
        Assertions.assertTrue(actualResultPassword);
    }
}
