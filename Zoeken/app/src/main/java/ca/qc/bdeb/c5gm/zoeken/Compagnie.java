package ca.qc.bdeb.c5gm.zoeken;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Comparator;

public class Compagnie implements Parcelable {

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

    private String nom_compagnie;
    private String nom_contact;
    private String email;
    private String telephone;
    private String site_web;
    private String adresse;
    private String ville;
    private String code_postal;
    private String date_contact;


    public Compagnie(String nom_compagnie, String nom_contact, String email, String telephone, String site_web, String adresse, String ville, String code_postal, String date_contact) {
        this.nom_compagnie = nom_compagnie;
        this.nom_contact = nom_contact;
        this.email = email;
        this.telephone = telephone;
        this.site_web = site_web;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
        this.date_contact = date_contact;
    }

    public void ajouterCompagnie(String nom_compagnie, String nom_contact, String email, String telephone, String site_web, String adresse, String ville, String code_postal, String date_contact){
        Compagnie nouvelleCompagnie = new Compagnie(
                nom_compagnie.toString().trim(),
                nom_contact.toString().trim(),
                email.toString().trim(),
                telephone.toString().trim(),
                site_web.toString().trim(),
                adresse.toString().trim(),
                ville.toString().trim(),
                code_postal.toString().trim(),
                date_contact.toString().trim());

    }

    protected Compagnie(Parcel in) {
        nom_compagnie = in.readString();
        nom_contact = in.readString();
        email = in.readString();
        telephone = in.readString();
        site_web = in.readString();
        adresse = in.readString();
        ville = in.readString();
        code_postal = in.readString();
        date_contact = in.readString();
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom_compagnie);
        dest.writeString(nom_contact);
        dest.writeString(email);
        dest.writeString(telephone);
        dest.writeString(site_web);
        dest.writeString(adresse);
        dest.writeString(ville);
        dest.writeString(code_postal);
        dest.writeString(date_contact);
    }
}
