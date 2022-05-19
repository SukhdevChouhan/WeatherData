import org.apache.log4j.Logger;

public class ValueValidation {
    private static final Logger logger = Logger.getLogger(ValueValidation.class);


    public static boolean isValueNull(String value){
        if (null == value || value.trim().equalsIgnoreCase("null")){
            return true;
        }
        return false;
    }

    public static boolean isValueValid(String value){
        if (null == value || value.trim().equalsIgnoreCase("null") || value.trim().equals("")){
            return false;
        }
        return true;
    }
}
