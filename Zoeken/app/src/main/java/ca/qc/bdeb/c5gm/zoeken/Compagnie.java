package ca.qc.bdeb.c5gm.zoeken;

import android.os.Parcel;
import android.os.Parcelable;

public class Compagnie implements Parcelable {


    private String nomCompagnie;
    private String nomContact;
    private String email;
    private String telephone;
    private String siteWeb;
    private String adresse;
    private String ville;
    private String codePostal;
    private String dateContact;


    public Compagnie(String nomCompagnie, String nomContact, String email, String telephone, String siteWeb, String adresse, String ville, String codePostal, String dateContact) {
        this.nomCompagnie = nomCompagnie;
        this.nomContact = nomContact;
        this.email = email;
        this.telephone = telephone;
        this.siteWeb = siteWeb;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.dateContact = dateContact;
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

    protected Compagnie(Parcel in) {
        nomCompagnie = in.readString();
        nomContact = in.readString();
        email = in.readString();
        telephone = in.readString();
        siteWeb = in.readString();
        adresse = in.readString();
        ville = in.readString();
        codePostal = in.readString();
        dateContact = in.readString();
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
        dest.writeString(nomCompagnie);
        dest.writeString(nomContact);
        dest.writeString(email);
        dest.writeString(telephone);
        dest.writeString(siteWeb);
        dest.writeString(adresse);
        dest.writeString(ville);
        dest.writeString(codePostal);
        dest.writeString(dateContact);
    }

    public String getNomCompagnie() {
        return nomCompagnie;
    }

    public String getNomContact() {
        return nomContact;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getDateContact() {
        return dateContact;
    }
}
