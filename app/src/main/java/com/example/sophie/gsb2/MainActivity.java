package com.example.sophie.gsb2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Mybase db = new Mybase(getApplicationContext(),null,6);
MedicamentDAO medacc = new MedicamentDAO(this);
          Medicament m1 = new Medicament("ggdvdb","ggg","ggg","fff","ggg","ffff");
         Medicament m12 = new Medicament("ggsdfsdbdbdbdbdgg","ggsdsfg","gsdfgg","ffvgvgff","gsdfsdgg","fdsdsdfff");
          medacc.addMedicaments(m1);
         medacc.addMedicaments(m12);

         for (Medicament unMed:
               medacc.getMedicamets("%")    ) {
           Toast.makeText(this, unMed.getcomposition(), Toast.LENGTH_SHORT).show();
         }


        Button BtnM = (Button) findViewById(R.id.button3);
        Button  BtnF = (Button) findViewById(R.id.button4);

        BtnF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent i = new Intent(MainActivity.this, FamillleActivity.class);
                startActivity(i);
            }
        });

        BtnM.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent i = new Intent(MainActivity.this, medicamentListActivity.class);
                startActivity(i);
            }
        });




    }
}
