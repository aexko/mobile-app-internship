package ca.qc.bdeb.c5gm.zoeken;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

// SOURCE: https://www.youtube.com/playlist?list=PLSrm9z4zp4mGK0g_0_jxYGgg3os9tqRUQ

public class ZoekenDatabaseHelper extends SQLiteOpenHelper {

    // informations de la base de donnees
    private static final String BD_NOM = "Zoeken.db";
    private static final int BD_VERSION = 1;

    // informations de la table COMPAGNIES
    private static final String NOM_TABLE = "compagnies";
    private static final String COLONNE_ID = "_id";
    private static final String COLONNE_NOM_COMPAGNIE = "nom_compagnie";
    private static final String COLONNE_NOM_CONTACT = "nom_complet";
    private static final String COLONNE_EMAIL = "email";
    private static final String COLONNE_TELEPHONE = "telephone";
    private static final String COLONNE_SITE_WEB = "site_web";
    private static final String COLONNE_ADRESSE = "adresse";
    private static final String COLONNE_VILLE = "ville";
    private static final String COLONNE_CODE_POSTAL = "code_postal";
    private static final String COLONNE_DATE_CONTACT = "date_de_contact";
    private static final String COLONNE_IMG = "img";

    private static final String REQUETE_SQL_CREATION_TABLE =
            "CREATE TABLE compagnies (" +
                    COLONNE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    COLONNE_NOM_COMPAGNIE + " TEXT NOT NULL," +
                    COLONNE_NOM_CONTACT + " TEXT NOT NULL," +
                    COLONNE_EMAIL + " TEXT NOT NULL," +
                    COLONNE_TELEPHONE + " TEXT NOT NULL," +
                    COLONNE_SITE_WEB + " TEXT NOT NULL," +
                    COLONNE_ADRESSE + " TEXT NOT NULL," +
                    COLONNE_VILLE + " TEXT NOT NULL," +
                    COLONNE_CODE_POSTAL + " TEXT NOT NULL," +
                    COLONNE_DATE_CONTACT + " DATE NOT NULL," +
                    COLONNE_IMG + " IMAGE" +
                    ");";

    private static final String REQUETE_SQL_LECTURE_BD =
            "SELECT * FROM " + NOM_TABLE + " ORDER BY nom_compagnie";

    private final Context context;


    public ZoekenDatabaseHelper(@Nullable Context context) {
        super(context, BD_NOM, null, BD_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(REQUETE_SQL_CREATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NOM_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void ajouterCompagnie(String nom_compagnie, String nom_contact, String email,
                                 String telephone, String site_web, String adresse, String ville,
                                 String code_postal, String date_contact) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLONNE_NOM_COMPAGNIE, nom_compagnie);
        contentValues.put(COLONNE_NOM_CONTACT, nom_contact);
        contentValues.put(COLONNE_EMAIL, email);
        contentValues.put(COLONNE_TELEPHONE, telephone);
        contentValues.put(COLONNE_SITE_WEB, site_web);
        contentValues.put(COLONNE_ADRESSE, adresse);
        contentValues.put(COLONNE_VILLE, ville);
        contentValues.put(COLONNE_CODE_POSTAL, code_postal);
        contentValues.put(COLONNE_DATE_CONTACT, date_contact);
        contentValues.put(COLONNE_DATE_CONTACT, date_contact);

        long resultat = sqLiteDatabase.insert(NOM_TABLE, null, contentValues);
        if (resultat == -1) {
            Toast.makeText(context, "Échec de l'ajout, veuillez réessayer.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Met a jour la BD
     *
     * @param id_compagnie  id de l'entreprise
     * @param nom_compagnie nom de l'entreprise
     * @param nom_contact   contact de l'entreprise
     * @param email         email de l'entreprise
     * @param telephone     telephone de l'entreprise
     * @param site_web      site web de l'entreprise
     * @param adresse       adresse de l'entreprise
     * @param ville         ville de l'entreprise
     * @param code_postal   code postal de l'entreprise
     * @param date_contact  date de contact de l'entreprise
     */
    void mettreAJourBd(String id_compagnie, String nom_compagnie, String nom_contact, String email,
                       String telephone, String site_web, String adresse, String ville,
                       String code_postal, String date_contact) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLONNE_NOM_COMPAGNIE, nom_compagnie);
        contentValues.put(COLONNE_NOM_CONTACT, nom_contact);
        contentValues.put(COLONNE_EMAIL, email);
        contentValues.put(COLONNE_TELEPHONE, telephone);
        contentValues.put(COLONNE_SITE_WEB, site_web);
        contentValues.put(COLONNE_ADRESSE, adresse);
        contentValues.put(COLONNE_VILLE, ville);
        contentValues.put(COLONNE_CODE_POSTAL, code_postal);
        contentValues.put(COLONNE_DATE_CONTACT, date_contact);

        long resultat = sqLiteDatabase.update(NOM_TABLE, contentValues, "_id=?",
                new String[]{id_compagnie});

        if (resultat == -1) {
            Toast.makeText(context, "Échec de la mise à jour, veuillez réessayer.",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Compagnie mise à jour avec succès",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Permet la lecture de la BD
     *
     * @return un curseur, mais il est mieux de retourner une liste a la place
     */
    Cursor lireBd() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = null;
        if (sqLiteDatabase != null) {
            cursor = sqLiteDatabase.rawQuery(REQUETE_SQL_LECTURE_BD, null);
        }
        return cursor;
    }

    /**
     * Permet la suppression d'une entreprise dans la BD
     *
     * @param id_compagnie id de l'entreprise
     */
    void supprimerCompagnie(String id_compagnie) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long resultat = sqLiteDatabase.delete(NOM_TABLE, "_id=?",
                new String[]{id_compagnie});
        if (resultat == -1) {
            Toast.makeText(context, "Échec de la suppression de la compagnie, " +
                    "veuillez réessayer.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Compagnie supprimée avec succès !",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
