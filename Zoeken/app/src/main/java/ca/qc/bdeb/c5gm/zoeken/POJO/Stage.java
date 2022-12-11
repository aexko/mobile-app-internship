package ca.qc.bdeb.c5gm.zoeken.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Stage {
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
    private String typeCompte;
    @SerializedName("entreprises")
    @Expose
    private List<Object> entreprises = null;
    private final static long serialVersionUID = -7030779357688058456L;

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

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public List<Object> getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(List<Object> entreprises) {
        this.entreprises = entreprises;
    }

}
