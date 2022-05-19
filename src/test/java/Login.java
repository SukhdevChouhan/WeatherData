import org.apache.log4j.Logger;
import org.sample.weather.ReadResources;

public class Login extends BaseUtil{
    private static final Logger logger = Logger.getLogger(Login.class);
    public ReadResources readResources = new ReadResources();
    public void launchUrl(final String testCaseModule, String... arg){
        logger.info("**********************Initializing the test case for :: [" + testCaseModule
                + "]*******************************");
        readConfigData = readResources.getValuesFromXml("Configuration.xml", "WeatherData");
        initializeGlobalVariables();
    }
}
