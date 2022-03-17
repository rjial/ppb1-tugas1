package com.rijal.tugas01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView jenkel = findViewById(R.id.jenis_kelamin);
        jenkel.setText(getString(R.string.L));
        LocalDate dateLahir = LocalDate.of(2000,07,24);
        LocalDate dateSaiki = LocalDate.now();
//        int usiaa = 2022 - 2000;
        TextView usia = findViewById(R.id.usia);
        String usiaaa = String.valueOf(Period.between(dateLahir, dateSaiki).getYears()) + " Tahun";
        usia.setText(usiaaa);
        AlertDialog.Builder dialPesan = new AlertDialog.Builder(this);
        dialPesan.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        Button btnPesan = findViewById(R.id.btnPesan);
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPesan.setTitle(null);
                dialPesan.setMessage("Rizal Abdul Basith\n"+getString(R.string.L)+"\n"+usiaaa);
                dialPesan.show();
            }
        });
        Button btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPesan.setTitle("Pesan Tersimpan");
                dialPesan.setMessage("Rizal Abdul Basith\n"+getString(R.string.L)+"\n"+usiaaa);
                dialPesan.show();
            }
        });
        Button btnKeluar = findViewById(R.id.btnKeluar);
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}