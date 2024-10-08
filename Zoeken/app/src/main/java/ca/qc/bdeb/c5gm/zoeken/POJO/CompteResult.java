package ca.qc.bdeb.c5gm.zoeken.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Classe CompteResult
 */
public class CompteResult {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("prenom")
    @Expose
    private String prenom;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("type_compte")
    @Expose
    private ComptePOJO.TypeCompte typeCompte;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("expires_at")
    @Expose
    private String expiresAt;
    private final static long serialVersionUID = -4644635962262338195L;

    /**
     * Constructeur de CompteResult
     *
     * @param typeCompte  type de compte
     * @param id          id du compte
     * @param accessToken token du compte
     * @param nom         nom du compte
     * @param prenom      prenom du compte
     * @param email       email du compte
     * @param expiresAt   expiration du compte
     */
    public CompteResult(String id, String nom, String prenom, String email, ComptePOJO.TypeCompte typeCompte, String accessToken) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.typeCompte = typeCompte;
        this.accessToken = accessToken;
    }

    /**
     * Tous les getter et setter de CompteResult
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ComptePOJO.TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(ComptePOJO.TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }


}
