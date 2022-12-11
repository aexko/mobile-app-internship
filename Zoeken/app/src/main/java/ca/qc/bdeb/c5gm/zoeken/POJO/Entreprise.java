package ca.qc.bdeb.c5gm.zoeken.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entreprise {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("telephone")
    @Expose
    private String telephone;
    @SerializedName("siteWeb")
    @Expose
    private String siteWeb;
    @SerializedName("adresse")
    @Expose
    private String adresse;
    @SerializedName("ville")
    @Expose
    private String ville;
    @SerializedName("province")
    @Expose
    private String province;
    @SerializedName("codePostal")
    @Expose
    private String codePostal;
    @SerializedName("dateContact")
    @Expose
    private String dateContact;
    @SerializedName("estFavorite")
    @Expose
    private Boolean estFavorite;
    private final static long serialVersionUID = -8437459210334057704L;

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getDateContact() {
        return dateContact;
    }

    public void setDateContact(String dateContact) {
        this.dateContact = dateContact;
    }

    public Boolean getEstFavorite() {
        return estFavorite;
    }

    public void setEstFavorite(Boolean estFavorite) {
        this.estFavorite = estFavorite;
    }

}
