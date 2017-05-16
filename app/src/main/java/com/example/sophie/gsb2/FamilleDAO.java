package com.example.sophie.gsb2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by sophie on 12/04/2017.
 */

public class FamilleDAO {

private static int version = 1;
    private Mybase accesBD;

    public FamilleDAO(Context ct){
        accesBD = new Mybase(ct,  null,version);

    }


    public ArrayList<Famille> getFamilles(String ref){
        Cursor curseur;
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        String req = "select * from famille where libelle like '"+ref+"';";

        curseur = bd.rawQuery(req,null);
        return cursorToArticleArrayList(curseur);
    }


    private ArrayList<Famille> cursorToArticleArrayList(Cursor curseur){
        ArrayList<Famille> listefAM = new ArrayList<Famille>();
        String _id;
        String libelle;


        if (curseur.moveToFirst()) {

            while (!curseur.isAfterLast()) {
                _id = curseur.getString(curseur.getColumnIndex("_id"));
                libelle = curseur.getString(curseur.getColumnIndex("libelle"));
                listefAM.add(new Famille(_id, libelle));
                curseur.moveToNext();
            }
        }

        return listefAM;
    }
}
