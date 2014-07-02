package no.kantega.sensors.dash7;

import org.junit.Test;

/**
 * Created by helaar on 01.07.2014.
 */
public class SensorTest {

    @Test
    public void testFromString() {

        Sensor s = Sensor.fromString("ts=1403681542365.2&sn=2&rt=0&lb=59&lig=3970&__cmd=SET_OBJ&uid=001BC50C7100001D&gwts=1403681542398.3");

        System.out.println(s);
    }

    @Test
    public void testLed() {
        SensorGateway.setLed("001BC50C7100001C", 0, "1");
    }

}
