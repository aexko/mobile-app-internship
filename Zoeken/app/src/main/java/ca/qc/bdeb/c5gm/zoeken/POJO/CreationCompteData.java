package ca.qc.bdeb.c5gm.zoeken.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Classe CreationCompteData
 */
public class CreationCompteData {
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("prenom")
    @Expose
    private String prenom;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mot_de_passe")
    @Expose
    private String motDePasse;
    @SerializedName("mot_de_passe_confirmation")
    @Expose
    private String motDePasseConfirmation;
    private final static long serialVersionUID = -3798612850575773101L;

    /**
     * Constructeur de la classe CreationCompteData
     * @param nom
     * @param prenom
     * @param email
     * @param motDePasse
     * @param motDePasseConfirmation
     */
    public CreationCompteData(String nom, String prenom, String email, String motDePasse, String motDePasseConfirmation) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.motDePasseConfirmation = motDePasseConfirmation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getMotDePasseConfirmation() {
        return motDePasseConfirmation;
    }

    public void setMotDePasseConfirmation(String motDePasseConfirmation) {
        this.motDePasseConfirmation = motDePasseConfirmation;
    }
}
