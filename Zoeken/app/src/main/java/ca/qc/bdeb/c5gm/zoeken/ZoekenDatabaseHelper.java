package ca.qc.bdeb.c5gm.zoeken;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;




public class ZoekenDatabaseHelper extends SQLiteOpenHelper {

    // informations de la base de donnees
    private static final String BD_NOM = "Zoeken.db";
    private static final int BD_VERSION = 1;

    // informations de la table COMPAGNIES
    private static final String NOM_TABLE = "compagnies";
    private static final String COLONNE_ID = "_id";
    private static final String COLONNE_NOM_COMPAGNIE = "nom_compagnie";
    private static final String COLONNE_NOM_COMPLET = "nom_complet";
    private static final String COLONNE_EMAIL = "email";
    private static final String COLONNE_TELEPHONE = "telephone";
    private static final String COLONNE_SITE_WEB = "site_web";
    private static final String COLONNE_ADRESSE = "adresse";
    private static final String COLONNE_VILLE = "ville";
    private static final String COLONNE_CODE_POSTAL = "code_postal";
    private static final String COLONNE_DATE_DE_CONTACT = "date_de_contact";

    private static final String REQUETE_SQL_CREATION_TABLE =
            "CREATE TABLE compagnies (" +
            COLONNE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
            COLONNE_NOM_COMPAGNIE + " TEXT NOT NULL," +
            COLONNE_NOM_COMPLET + " TEXT NOT NULL," +
            COLONNE_EMAIL + " TEXT NOT NULL," +
            COLONNE_TELEPHONE + " TEXT NOT NULL," +
            COLONNE_SITE_WEB + " TEXT NOT NULL," +
            COLONNE_ADRESSE + " TEXT NOT NULL," +
            COLONNE_VILLE + " TEXT NOT NULL," +
            COLONNE_CODE_POSTAL + " TEXT NOT NULL," +
            COLONNE_DATE_DE_CONTACT + " DATE NOT NULL" +
            ");";


    public ZoekenDatabaseHelper(@Nullable Context context) {
        super(context, BD_NOM, null, BD_VERSION);
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

}
