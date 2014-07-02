package no.kantega.sensors.dash7;

import java.util.StringTokenizer;

/**
 * Created by helaar on 01.07.2014.
 */
public class Sensor {
    //ts - timestamp
    //sn
    //rt
    //lb
    //__cmd
    private String uid;
    private Integer temperature;
    private Integer humidity;
    private Integer pressure;
    private Integer light;
    private Integer x;
    private Integer y;
    private Integer z;
    private boolean leftButton;
    private boolean rightButton;
    private String sensorTimestamp;
    private final long localTimestamp = System.currentTimeMillis();

    public static Sensor fromString(String string)
    {
        StringTokenizer tok = new StringTokenizer(string, "&");

        Sensor s = new Sensor();
        while(tok.hasMoreTokens()) {

            String t = tok.nextToken();
            String n = t.substring(0,t.indexOf("="));
            String v = t.substring(t.indexOf("=")+1);
            if( "uid".compareTo(n) == 0) {
                s.uid = v;
            } else if( "x".compareTo(n) == 0) {
                s.x = Integer.parseInt(v);
            } else if( "y".compareTo(n) == 0) {
                s.y = Integer.parseInt(v);
            } else if( "x".compareTo(n) == 0) {
                s.z = Integer.parseInt(v);
            } else if( "tmp".compareTo(n) == 0) {
                s.temperature = Integer.parseInt(v);
            } else if( "hum".compareTo(n) == 0) {
                s.humidity = Integer.parseInt(v);
            } else if( "lig".compareTo(n) == 0) {
                s.light = Integer.parseInt(v);
            } else if( "btn1".compareTo(n) == 0) {
                s.leftButton = v.length() > 0;
            } else if( "btn2".compareTo(n) == 0) {
                s.rightButton = v.length() > 0;
            } else if( "pre".compareTo(n) == 0) {
                s.pressure = Integer.parseInt(v);
            } else if( "ts".compareTo(n) == 0) {
                s.sensorTimestamp = v;
            }
        }

        return s;
    }

    public String getUid() {
        return uid;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getLight() {
        return light;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

    public boolean isLeftButton() {
        return leftButton;
    }

    public boolean isRightButton() {
        return rightButton;
    }

    public void redLed(boolean b) {
        SensorGateway.setLed(uid, SensorGateway.RED, (b?SensorGateway.ON:SensorGateway.OFF) );
    }
    public void greenLed(boolean b) {
        SensorGateway.setLed(uid, SensorGateway.GREEN, (b ? SensorGateway.ON : SensorGateway.OFF));
    }

    public String getSensorTimestamp() {
        return sensorTimestamp;
    }

    public long getLocalTimestamp() {
        return localTimestamp;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "uid='" + uid + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", light=" + light +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", leftButton=" + leftButton +
                ", rightButton=" + rightButton +
                ", sensorTimestamp=" + sensorTimestamp +
                ", localTimestamp=" + localTimestamp +
                '}';
    }
}
