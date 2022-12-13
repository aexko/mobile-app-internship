package ca.qc.bdeb.c5gm.zoeken.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Classe LoginData
 */
public class LoginData {
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mot_de_passe")
    @Expose
    private String motDePasse;
    private final static long serialVersionUID = 715309548398645260L;

    /**
     * Constructeur de la classe LoginData
     * @param email
     * @param motDePasse
     */
    public LoginData(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    /**
     * getEmail
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * setEmail
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getMdp
     * @return
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * setMdp
     * @param motDePasse
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
