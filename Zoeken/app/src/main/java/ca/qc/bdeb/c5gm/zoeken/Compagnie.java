package ca.qc.bdeb.c5gm.zoeken;

import java.util.ArrayList;
import java.util.Comparator;

public class Compagnie {



    private ArrayList<Compagnie> listeCompagnies;

    private int id;
    private String nom;
    private String nom_contact;
    private String email;
    private String telephone;
    private String site_web;
    private String adresse;
    private String ville;
    private String code_postal;
    private String date_contact;

    public Compagnie(int id, String nom, String nom_contact,
                     String email, String telephone, String site_web, String adresse, String ville,
                     String code_postal, String date_contact) {
        this.id = id;
        this.nom = nom;
        this.nom_contact = nom_contact;
        this.email = email;
        this.telephone = telephone;
        this.site_web = site_web;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
        this.date_contact = date_contact;
    }



    public static Comparator<Compagnie> triAZCompagnies = new Comparator<Compagnie>() {
        @Override
        public int compare(Compagnie compagnie1, Compagnie compagnie2) {
            return compagnie1.getNom().compareTo(compagnie2.getNom());
        }
    };

    public ArrayList<Compagnie> getListeCompagnies() {
        return listeCompagnies;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getNom_contact() {
        return nom_contact;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSite_web() {
        return site_web;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public String getDate_contact() {
        return date_contact;
    }

    public static Comparator<Compagnie> getTriAZCompagnies() {
        return triAZCompagnies;
    }

}
