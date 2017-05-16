package com.example.sophie.gsb2;

/**
 * Created by sophie on 12/04/2017.
 */

public class Famille {

    private String _id;
    private String libelle;


    public Famille(String _id, String libelle ) {
        this._id = _id;
        this.libelle = libelle;

    }
    public String getId() {

        return this._id;
    }

    public void setIdV(String _id) {

        this._id = _id;
    }

    public String getlibelle() {

        return this.libelle;
    }

    public void setlibelle(String libelle) {

        this.libelle = libelle;
    }

    public String toString(){
        return "id="+_id+" libelle="+libelle;
    }

}
