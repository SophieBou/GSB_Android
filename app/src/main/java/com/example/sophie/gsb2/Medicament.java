package com.example.sophie.gsb2;

/**
 * Created by sophie on 11/04/2017.
 */

public class Medicament {

    private String _id;
    private String nom;
    private String composition;
    private String prix;
    private String effets;
    private String contreindic;

    public Medicament(String _id, String nom, String composition,String prix,String effets, String contreindic ) {
        this._id = _id;
        this.nom = nom;
        this.composition = composition;
        this.prix = prix;
        this.effets = effets;
        this.contreindic = contreindic;
    }


    public String getId() {
        return this._id;
    }

    public void setIdV(String _id) {
        this._id = _id;
    }

    public String getnom() {
        return this.nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }
    public String getcomposition() {
        return this.composition;
    }

    public void setcomposition(String composition) {
        this.composition = composition;
    }
    public String getprix() {
        return this.prix;
    }

    public void setprix(String prix) {
        this.prix = prix;
    }

    public String geteffets() {
        return effets;
    }

    public void seteffets(String effets) {
        this.effets = effets;
    }
    public String getcontreindic() {
        return contreindic;
    }

    public void setcontreindic(String contreindic) {
        this.contreindic = contreindic;
    }
    public String toString(){
        return "id="+_id+" nom="+nom+" composition="+composition+" prix="+prix+" effets="+effets+" contreindic="+contreindic;
    }

}
