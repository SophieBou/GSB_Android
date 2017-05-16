package com.example.sophie.gsb2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sophie on 11/04/2017.
 */

public class Mybase  extends SQLiteOpenHelper {

    private static final String MED_DEPOTLEGALE = "_id";
    private static final String MED_NOMCOMMERCIAL = "nom";
    private static final String MED_COMPOSITION = "composition";
    private static final String MED_PRIXECHANTILLION ="prix";
    private static final String MED_EFFETS = "effets";
    private static final String MED_CONTREINDIC = "contreindic" ;
    private static final String Table_Name_MED = "medicament" ;


    private static final String Table_Name_FAM = "famille" ;
    private static final String FAM_CODE = "_id";
    private static final String FAM_LIBELLE = "libelle" ;

    private static final String Table_Name_CMP = "composant" ;
    private static final String CMP_CODE = "_id";
    private static final String CMP_LIBELLE = "libelle" ;


    private static final String Create_Table_Medicaments =  "CREATE TABLE " + Table_Name_MED + " (" +
            MED_DEPOTLEGALE + " TEXT PRIMARY KEY, " +
            MED_NOMCOMMERCIAL + " TEXT, " +
            MED_COMPOSITION + " TEXT, " +
            MED_EFFETS + " TEXT, " +
            MED_CONTREINDIC + " TEXT, " +
            MED_PRIXECHANTILLION  + " TEXT);";


    private static final String Create_Table_Famille =  "CREATE TABLE " + Table_Name_FAM + " (" +
            FAM_CODE + " TEXT PRIMARY KEY, " +
            FAM_LIBELLE  + " TEXT);";

    private static final String Create_Table_Composant =  "CREATE TABLE " + Table_Name_CMP + " (" +
            CMP_CODE + " TEXT PRIMARY KEY, " +
            CMP_LIBELLE  + " TEXT);";


    public Mybase(Context context, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "BDMedicaments", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_Table_Famille);
        db.execSQL(Create_Table_Medicaments);

        db.execSQL(Create_Table_Composant);

        ContentValues value = new ContentValues();
        value.put("_id", "Esquerradfgxv");
        value.put("nom", "Esquerra desdgdxv");
        value.put("composition", "11xv");
        value.put("prix","11");
        value.put("effets","Esquerra dexvs");
        value.put("contreindic","Esquerxvxra des");
        db.insert("medicament", null, value);

        ContentValues value2 = new ContentValues();
        value2.put("_id", "fam1");
        value2.put("libelle", "famille1");
        db.insert("famille", null, value2);

        ContentValues value3 = new ContentValues();
        value3.put("_id", "comp1");
        value3.put("libelle", "composant1");
        db.insert("composant", null, value3);

    }
    public static final String MED_DROP = "DROP TABLE IF EXISTS " + Table_Name_MED + ";";
    public static final String FAM_DROP = "DROP TABLE IF EXISTS " + Table_Name_FAM + ";";
    public static final String CMP_DROP = "DROP TABLE IF EXISTS " + Table_Name_CMP + ";";

    @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MED_DROP);
        db.execSQL(FAM_DROP);
        db.execSQL(CMP_DROP);
        onCreate(db);
    }
}
