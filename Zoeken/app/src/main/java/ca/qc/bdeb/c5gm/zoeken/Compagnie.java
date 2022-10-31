package ca.qc.bdeb.c5gm.zoeken;

import java.util.ArrayList;

public class Compagnie implements Comparable<Compagnie> {

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

    @Override
    public int compareTo(Compagnie autreCompagnie) {
        return this.nom.compareTo(autreCompagnie.nom);
    }
}
