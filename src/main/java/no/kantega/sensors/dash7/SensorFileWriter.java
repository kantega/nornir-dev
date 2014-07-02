package no.kantega.sensors.dash7;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by helaar on 02.07.2014.
 */
public class SensorFileWriter {

    private final static String FILENAME = System.getProperty("sensor.outfile", "sensor.log");

    private static SensorFileWriter instance = new SensorFileWriter();

    public static SensorFileWriter getInstance() {
        return instance;
    }

    public void write(Sensor s) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        FileOutputStream stream = new FileOutputStream(FILENAME, true);
        mapper.writeValue(stream, s);

        stream.flush(); stream.close();

    }

}
