package no.kantega.sensors.dash7;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;

/**
 * Created by helaar on 30.06.2014.
 */
@ApplicationPath("sensors")
public class SensorsApplication extends ResourceConfig {


    public SensorsApplication() {
        System.out.println("Entering Sensors Application Config");
        LoggerFactory.getLogger(SensorsApplication.class).info("Initializing...");
        packages("no.kantega.sensors.dash7");
    }
}
