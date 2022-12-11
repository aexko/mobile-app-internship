package ca.qc.bdeb.c5gm.zoeken.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mot_de_passe")
    @Expose
    private String motDePasse;
    private final static long serialVersionUID = 715309548398645260L;

    public LoginData(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
