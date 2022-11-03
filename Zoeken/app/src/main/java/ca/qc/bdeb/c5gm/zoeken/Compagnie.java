package ca.qc.bdeb.c5gm.zoeken;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Comparator;

public class Compagnie implements Parcelable {

    private int imgResource;
    private String nom;
    private String adresse;
    private String ville;
    private String code_postal;

    public Compagnie( String nom, String adresse, String ville, String code_postal) {
//        this.imgResource = imgResource;
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
    }

    protected Compagnie(Parcel in) {
        imgResource = in.readInt();
        nom = in.readString();
        adresse = in.readString();
        ville = in.readString();
        code_postal = in.readString();
    }

    public static final Creator<Compagnie> CREATOR = new Creator<Compagnie>() {
        @Override
        public Compagnie createFromParcel(Parcel in) {
            return new Compagnie(in);
        }

        @Override
        public Compagnie[] newArray(int size) {
            return new Compagnie[size];
        }
    };

    public String getNom() {
        return nom;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imgResource);
        parcel.writeString(nom);
        parcel.writeString(adresse);
        parcel.writeString(ville);
        parcel.writeString(code_postal);
    }
}
