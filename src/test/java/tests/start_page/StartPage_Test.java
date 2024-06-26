package tests.start_page;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.*;
import pages.start_page.StartPage;

import java.util.Arrays;
import java.util.HashMap;


@Epic("Тестирование Cтартовой страницы")
public class StartPage_Test extends StartPage {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
       // Configuration.headless = true;
        Configuration.baseUrl = "https://partner.agentapp.ru/";
        Configuration.timeout = 10000;
        Configuration.browserCapabilities.setCapability("goog:chromeOptions", new HashMap<String, Object>() {{
            put("args", Arrays.asList("--disable-dev-shm-usage", "--no-sandbox", "--disable-gpu", "--remote-allow-origins=*"));
        }});
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
}
