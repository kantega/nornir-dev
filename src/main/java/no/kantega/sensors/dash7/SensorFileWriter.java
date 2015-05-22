package no.kantega.sensors.dash7;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * Created by helaar on 02.07.2014.
 */
public class SensorFileWriter {

    private static final Logger jsonLogger = LoggerFactory.getLogger("SENSORDATA");
    private static final Logger LOG = LoggerFactory.getLogger(SensorFileWriter.class);

    public static void write(Sensor s) {


        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonLogger.info(mapper.writeValueAsString(s));
        } catch (IOException e) {
            LOG.error("Failed to transform Sensor class to json", e);
        }

    }

    public static void write(TemperatureEvent s) {


        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonLogger.info(mapper.writeValueAsString(s));
        } catch (IOException e) {
            LOG.error("Failed to transform Sensor class to json", e);
        }

    }




}
