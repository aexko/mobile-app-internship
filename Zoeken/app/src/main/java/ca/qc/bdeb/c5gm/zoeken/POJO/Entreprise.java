package ca.qc.bdeb.c5gm.zoeken.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

/**
 * Classe Entreprise
 */
public class Entreprise {

    /**
     * Constructeur de la classe entreprise
     * @param id id de l'entreprise
     * @param nom nom de l'entreprise
     * @param contact contact de l'entreprise
     * @param email email de l'entreprise
     * @param telephone telephone de l'entreprise
     * @param siteWeb site web de l'entreprise
     * @param adresse adresse de l'entreprise
     * @param ville ville de l'entreprise
     * @param province province de l'entreprise
     * @param codePostal code postal de l'entreprise
     * @param dateContact date de contact de l'entreprise
     * @param estFavorite favori ou non de l'utilisateur
     */
    public Entreprise(UUID id, String nom, String contact, String email, String telephone, String siteWeb, String adresse, String ville, String province, String codePostal, String dateContact, Boolean estFavorite) {
        this.id = id;
        this.nom = nom;
        this.contact = contact;
        this.email = email;
        this.telephone = telephone;
        this.siteWeb = siteWeb;
        this.adresse = adresse;
        this.ville = ville;
        this.province = province;
        this.codePostal = codePostal;
        this.dateContact = dateContact;
        this.estFavorite = estFavorite;
    }

    @SerializedName("id")
    @Expose
    private UUID id;
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


    /**
     * Tous les getter et setter de Entreprise
     */
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
