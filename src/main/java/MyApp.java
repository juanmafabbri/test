//import org.apache.commons.text.StringSubstitutor;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class MyApp {

    static Logger logger = LogManager.getLogger(MyApp.class);

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        logger.info("Hello, World! {}", 10);

        System.out.println("more text");
        //final StringSubstitutor interpolator = StringSubstitutor.createInterpolator();
        //String out = interpolator.replace("${script:javascript:java.lang.Runtime.getRuntime().exec('touch /tmp/foo')}");
    }
} 