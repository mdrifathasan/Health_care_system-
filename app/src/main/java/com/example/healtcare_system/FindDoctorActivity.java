package com.example.healtcare_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
            }
        });

        CardView familyphysician = findViewById(R.id.cardFDFimilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent it  = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Family physicians");
                startActivity(it);
            }
        });
        CardView dietcian = findViewById(R.id.cardFDDietici);
        dietcian .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "dietcian");
                startActivity(it);

            }
        });
        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "dentist");
                startActivity(it);
            }
        });
        CardView surgeon = findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "surgeon");
                startActivity(it);
            }
        });
        CardView cardiologists = findViewById(R.id.cardFDCardiologist);
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "cardiologists");
                startActivity(it);
            }
        });

    }
}