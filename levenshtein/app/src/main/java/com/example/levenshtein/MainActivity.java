package com.example.levenshtein;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {
String girilenDeger,gelenKelime,gidenKelime;
SearchWorks searchWorks;
Button gonderButton;
EditText bunuMuDemekIstediniz,girilenUrun;
TreeMap<Double,String> userMap;
String[] parcalanmisKelimeler;
double ratio;
int stringDistance;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchWorks = new SearchWorks();
        gonderButton = findViewById(R.id.gonderButton);
        bunuMuDemekIstediniz = findViewById(R.id.bunuMuDemekIstediniz);
        girilenUrun = findViewById(R.id.girilenUrun);

        gonderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bunuMuDemekIstediniz.setText("");
                 gidenKelime = girilenUrun.getText().toString();
                System.out.println("Giden"+gidenKelime);
               gelenKelime = searchWorks.editSearchText(gidenKelime);
                System.out.println("aaaaaaaaaa"+gelenKelime);
                bunuMuDemekIstediniz.setText(gelenKelime);
                gelenKelime="";
            }
        });
    }



}