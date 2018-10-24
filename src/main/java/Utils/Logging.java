package Utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logging {

    private static boolean root = false;
    public static Logger getLogger(Class clas) {
        if(root)
            return Logger.getLogger(clas);
        PropertyConfigurator.configure(new ResourceProvider().getResource("logs/log4j.properties"));
        root = true;
        return Logger.getLogger(clas);
    }
}
