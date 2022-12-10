package ca.qc.bdeb.c5gm.zoeken.Connexion;

// SOURCE: Docs du cours

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Compte {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("nom")
    @Expose
    public String nom;
    @SerializedName("prenom")
    @Expose
    public String prenom;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("est_actif")
    @Expose
    public Boolean estActif;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    public String deletedAt;
    @SerializedName("type_compte")
    @Expose
    public String typeCompte;
    @SerializedName("access_token")
    @Expose
    public String accessToken;
    @SerializedName("token_type")
    @Expose
    public String tokenType;
    @SerializedName("expires_at")
    @Expose
    public String expiresAt;

    public Compte withId(String id) {
        this.id = id;
        return this;
    }

    public Compte withNom(String nom) {
        this.nom = nom;
        return this;
    }

    public Compte withPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public Compte withEmail(String email) {
        this.email = email;
        return this;
    }

    public Compte withEstActif(Boolean estActif) {
        this.estActif = estActif;
        return this;
    }

    public Compte withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Compte withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Compte withDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    public Compte withTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
        return this;
    }

    public Compte withAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Compte withTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public Compte withExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

}