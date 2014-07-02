package no.kantega.sensors.dash7;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by helaar on 30.06.2014.
 */
@ApplicationPath("sensors")
public class SensorsApplication extends ResourceConfig {


    public SensorsApplication() {
        System.out.println("Entering BAPI Application Config");
        packages("no.kantega.sensors.dash7");
    }
}
