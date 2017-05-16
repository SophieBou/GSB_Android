package com.example.sophie.gsb2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sophie on 11/04/2017.
 */

public class MedicamentDAO {

    private static String base = "BDMedicaments";
    private static int version = 1;
    private Mybase accesBD;

    public MedicamentDAO(Context ct){
        accesBD = new Mybase(ct,  null, version);

    }

        /*public void addArticle1(Article unArticle){
            SQLiteDatabase bd = accesBD.getWritableDatabase();

            String req = "insert into article((REF,DES,PU,QTE))"
                    + " values('"+unArticle.getReference()+"',"+unArticle.getDesignation()
                    +unArticle.getPrixUnitHT()+unArticle.getQuantite()+");";
            Log.d("log",req);
            bd.execSQL(req);
            bd.close();
        }*/

    public long addMedicaments(Medicament unMedicament){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("_id", unMedicament.getId());
        value.put("nom", unMedicament.getnom());
        value.put("composition", unMedicament.getcomposition());
        value.put("prix",unMedicament.getprix());
        value.put("effets",unMedicament.geteffets());
        value.put("contreindic",unMedicament.getcontreindic());
        ret = bd.insert("medicament", null, value);


        return ret;
    }



    public ArrayList<Medicament> getMedicamets(String ref){
        Cursor curseur;
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        String req = "select * from medicament where nom like '"+ref+"';";

        curseur = bd.rawQuery(req,null);
        return cursorToArticleArrayList(curseur);
    }


    private ArrayList<Medicament> cursorToArticleArrayList(Cursor curseur){
        ArrayList<Medicament> listeMed = new ArrayList<Medicament>();
        String _id;
         String nom;
         String composition;
         String prix;
         String effets;
         String contreindic;

        if (curseur.moveToFirst()) {

            while (!curseur.isAfterLast()) {
                _id = curseur.getString(curseur.getColumnIndex("_id"));
                nom = curseur.getString(curseur.getColumnIndex("nom"));
                composition = curseur.getString(curseur.getColumnIndex("composition"));
                effets = curseur.getString(curseur.getColumnIndex("effets"));
                contreindic = curseur.getString(curseur.getColumnIndex("contreindic"));
                prix = curseur.getString(curseur.getColumnIndex("prix"));


                listeMed.add(new Medicament(_id, nom, composition, prix, effets, contreindic));
                curseur.moveToNext();
            }
        }

        return listeMed;
    }


}
