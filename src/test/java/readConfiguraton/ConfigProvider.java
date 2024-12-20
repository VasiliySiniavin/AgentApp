package readConfiguraton;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.load( "local.conf");
    }

    String BROWSER = readConfig().getString("browser");
    String SIZE = readConfig().getString("browserSize");
    String URL = readConfig().getString("url");
    String LOGIN = readConfig().getString("UserParameters.admin.login");
    String PASSWORD = readConfig().getString("UserParameters.admin.password");
}
