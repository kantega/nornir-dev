package no.kantega.sensors.dash7;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

/**
 * Created by helaar on 01.07.2014.
 */
public class SensorGateway {

    private static final String TARGET_URL_FORMAT ="http://192.168.1.3/cgi-bin/luci/dash7/api/wf?uid=%s&file_id=%s&offset=%d&file_data=%s&file_len=%d&fwd=2";
    // "file_id=209&offset=0&file_len=1&fwd=2&uid=001BC50C7100000D&file_data=1"

    public final static String LED_ID = "0xd1";
    public final static int RED = 0;
    public final static int GREEN = 1;
    public final static String ON = "1";
    public final static String OFF = "0";

    public static boolean setLed(String uid, int led, String value) {
        return sendToSensor(uid, LED_ID, led, value);

    }


    public static boolean sendToSensor(String uid, String fileId, int offset, String value ) {

        System.out.println("Changing color " + uid + ": "+ fileId + ", " + offset + ", " + value);
        Client gwClient = ClientBuilder.newClient();
        String target = String.format(TARGET_URL_FORMAT,uid,fileId, offset, value, value.length());
        Invocation.Builder request = gwClient.target(target).request();
        request.header("Synx-Cat", "1");

        Response resp = request.method("POST");
        return (resp.getStatus() == 204 || resp.getStatus() == 200);
    }

}
