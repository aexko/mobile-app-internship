package ca.qc.bdeb.c5gm.zoeken.Connexion;

// SOURCE: Docs du cours

public class ConnecterUtilisateur {
    static String authToken;
    static String authID;

    public ConnecterUtilisateur(String authID, String authToken) {
        this.authID = authID;
        this.authToken = authToken;
    }
}
