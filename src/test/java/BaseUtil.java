import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BaseUtil {

    public Map<String, String> restApiConfigMap;
    private String envName;
    public Map<String, String> readConfigData;
    private Object envUrl;
    private Map<String, String> readConfigUrls=new HashMap<>();

    protected void initializeGlobalVariables() {
        envName = System.getProperty("envName");
        if (!ValueValidation.isValueValid(envName)) {
            envName = readConfigData.get("envName");
        }
        envUrl = readConfigUrls.get(envName);
    }

    public static Properties loadMenuOptionsConfigFile(final String resource, final Properties props) {
        InputStream input = BaseUtil.class.getClassLoader().getResourceAsStream(resource);
        InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(input), StandardCharsets.UTF_8);
        try {
            props.load(inputStreamReader);
            return props;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                input.close();
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
