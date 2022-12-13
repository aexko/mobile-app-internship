package ca.qc.bdeb.c5gm.zoeken.POJO;


// SOURCE: Docs du cours

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Classe ComptePOJO
 */
public class ComptePOJO {

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
    @SerializedName("stageTrouve")
    @Expose
    private Boolean stageTrouve;
    @SerializedName("typeCompte")
    @Expose
    private TypeCompte typeCompte;
    @SerializedName("entreprises")
    @Expose
    private List<Entreprise> entreprises = null;
    private final static long serialVersionUID = -8308703459862838231L;

    /**
     * Constructeur de ComptePOJO
     * @param nom
     */
    public ComptePOJO(String nom) {
        this.nom = nom;
    }

    /**
     * Tous les getter et setter de ComptePOJO
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

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStageTrouve() {
        return stageTrouve;
    }

    public List<Entreprise> getEntreprises() {
        return entreprises;
    }

    /**
     * Enums pour le types de compte
     */
    public enum TypeCompte {
        ETUDIANT,
        ADMINISTRATEUR,
        PROFESSEUR,
    }


}