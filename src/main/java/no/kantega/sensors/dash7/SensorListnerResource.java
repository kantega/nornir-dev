package no.kantega.sensors.dash7;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;

/**
 * Created by helaar on 30.06.2014.
 */
@Path("listener/")
public class SensorListnerResource {

    private static final int TEMP_MAX_TRESHOLD = 26;
    private static final int TEMP_MIN_TRESHOLD = 25;

    private static int counter = 0;



    @POST
    public void handleEvent(String event)  {

        Sensor s = Sensor.fromString(event);

        if( s.getTemperature() != null) {
            System.out.println(String.format("Temperature changed to %d on %s ", s.getTemperature(), s.getUid() ));
            if (s.getTemperature() > TEMP_MAX_TRESHOLD)
                s.redLed(true);
            else
                s.redLed(false);

            if (s.getTemperature() < TEMP_MIN_TRESHOLD)
                s.greenLed(true);
            else
                s.greenLed(false);
        }

        SensorFileWriter.write(s);
    }
}
