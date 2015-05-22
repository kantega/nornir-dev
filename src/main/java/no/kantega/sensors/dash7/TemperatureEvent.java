package no.kantega.sensors.dash7;

import java.util.StringTokenizer;

/**
 * Created by helaar on 22.05.2015.
 */
public class TemperatureEvent {
    private String uid;
    private Integer temperature;
    private String sensorTimestamp;

    public static TemperatureEvent fromString(String string)
    {
        StringTokenizer tok = new StringTokenizer(string, "&");

        TemperatureEvent e = new TemperatureEvent();
        while(tok.hasMoreTokens()) {

            String t = tok.nextToken();
            String n = t.substring(0,t.indexOf("="));
            String v = t.substring(t.indexOf("=")+1);
            if( "uid".compareTo(n) == 0) {
                e.uid = v;
            } else if( "tmp".compareTo(n) == 0) {
                e.temperature = Integer.parseInt(v);
            } else if( "ts".compareTo(n) == 0) {
                e.sensorTimestamp = v;
            }
        }

        if( e.temperature == null)
            return null;
        else
            return e;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getSensorTimestamp() {
        return sensorTimestamp;
    }

    public void setSensorTimestamp(String sensorTimestamp) {
        this.sensorTimestamp = sensorTimestamp;
    }

    @Override
    public String toString() {
        return "TemperatureEvent{" +
                "uid='" + uid + '\'' +
                ", temperature=" + temperature +
                ", sensorTimestamp='" + sensorTimestamp + '\'' +
                '}';
    }
}
