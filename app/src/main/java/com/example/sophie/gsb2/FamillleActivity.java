package com.example.sophie.gsb2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class FamillleActivity extends AppCompatActivity {
    private  ListView listViewFam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famillle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        listViewFam = (ListView) findViewById(R.id.ListviewFamille);
        FamilleDAO FamAcces = new FamilleDAO(this);

        ArrayList<Famille> listeDesFamilles;
        listeDesFamilles = FamAcces.getFamilles("%");
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();

        //On déclare la HashMap qui contiendra les informations pour un item
         HashMap<String, String> map;


          for (Famille uneFamilles : listeDesFamilles
         ) {
            map = new HashMap<String, String>();


               map.put("libelle", uneFamilles.getlibelle());

           listItem.add(map);
          }

        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (list_entree) dans la vue listeArticles
         SimpleAdapter Adapt = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.list_adapter,

             new String[] {"libelle"}, new int[] { R.id.libelle });

        //On attribue à notre listView l'adapter que l'on vient de créer

         listViewFam.setAdapter(Adapt);

    }

}
