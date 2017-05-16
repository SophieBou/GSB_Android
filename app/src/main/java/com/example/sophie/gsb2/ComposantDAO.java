package com.example.sophie.gsb2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by sophie on 12/04/2017.
 */

public class ComposantDAO {

    private Mybase accesBD;
    private static int version = 1;
    public ComposantDAO(Context ct){
        accesBD = new Mybase(ct,  null, version);

    }


    public ArrayList<Composant> getComposants(String ref){
        Cursor curseur;
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        String req = "select * from composant where libelle like '"+ref+"';";

        curseur = bd.rawQuery(req,null);
        return cursorToArticleArrayList(curseur);
    }


    private ArrayList<Composant> cursorToArticleArrayList(Cursor curseur){
        ArrayList<Composant> listeCmp = new ArrayList<Composant>();
        String _id;
        String libelle;


        if (curseur.moveToFirst()) {

            while (!curseur.isAfterLast()) {
                _id = curseur.getString(curseur.getColumnIndex("_id"));
                libelle = curseur.getString(curseur.getColumnIndex("libelle"));
                listeCmp.add(new Composant(_id, libelle));
                curseur.moveToNext();
            }
        }

        return listeCmp;
    }
}
