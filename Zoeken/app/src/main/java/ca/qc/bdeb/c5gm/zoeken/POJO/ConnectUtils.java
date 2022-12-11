package ca.qc.bdeb.c5gm.zoeken.POJO;

public class ConnectUtils {
    static String authToken;
    static String authID;

    public ConnectUtils(String authID, String authToken) {
        this.authID = authID;
        this.authToken = authToken;
    }
}
