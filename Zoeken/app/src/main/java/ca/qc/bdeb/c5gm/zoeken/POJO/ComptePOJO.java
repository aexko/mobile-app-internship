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

    public ComptePOJO(String nom) {
        this.nom = nom;
    }

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

    public Boolean getStageTrouve() {
        return stageTrouve;
    }

    public void setStageTrouve(Boolean stageTrouve) {
        this.stageTrouve = stageTrouve;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public List<Entreprise> getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(List<Entreprise> entreprises) {
        this.entreprises = entreprises;
    }

    public enum TypeCompte {
        ETUDIANT,
        ADMINISTRATEUR,
        PROFESSEUR,
    }


}