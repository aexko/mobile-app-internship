package ca.qc.bdeb.c5gm.zoeken;

import java.util.ArrayList;
import java.util.Comparator;

public class Compagnie {

    private ArrayList<Compagnie> listeCompagnies;

    private int id;
    private String nom;

    public Compagnie(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public ArrayList<Compagnie> getListeCompagnies() {
        return listeCompagnies;
    }

    public static Comparator<Compagnie> triAZCompagnies = new Comparator<Compagnie>() {
        @Override
        public int compare(Compagnie compagnie1, Compagnie compagnie2) {
            return compagnie1.getNom().compareTo(compagnie2.getNom()) ;
        }
    };

    public String getNom() {
        return nom;
    }
}
