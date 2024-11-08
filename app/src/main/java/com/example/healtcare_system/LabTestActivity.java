package com.example.healtcare_system;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    public String[][] packages ={

            {"packages 1 : Full Body CheckUp","","","","999"},
            {"packages 2 : Blood Glucose Fasting","","","","299"},
            {"packages 3 : COVID 19 Antibody","","","","899"},
            {"packages 4 : Thyroid Check","","","","499"},
            {"packages 5 : Immunity Check","","","","699"}

    };
    public String[] package_Details ={

           " Blood Glucose Fasting\n" +
                   "Complete Hemogram\n" +
                   "HbA1c\n"+
                   "Iron Studies\n"+
                   "Kidny Function Test\n"+
                   "LDH Lactate Dehydrogenase,Surum\n"+
                   "Lipid Profile\n"+
                   "Liver Function Test\n",

            "Blood Glucose Fasting",
            "COVID 19 Antibody",
            "Thyroid Profile-Total(T3,T4 & TSH Ultra-sensitive)",
            "Complete Homogram\n"+
                    "CRP ( C Reactive Protein) Quantitative, Serum\n"+
                    "Iron Studies\n"+
                    "Kidny Function Test\n"+
                    "Vitamin D Total_25 Hydroxy\n"+
                    "Liver Function Test\n"+
                    "Lipid Profile\n"



    };
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnAddToCart,btnBack;
    ListView listView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab_test);


        btnAddToCart = findViewById(R.id.ButtonLTAddToCart);
        btnBack = findViewById(R.id.ButtonLTBack);
        listView = findViewById(R.id.listViewLT);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });
        list = new ArrayList<>();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost" + packages[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.id.multi_line,
                new String[]{"Line_1", "Line_2", "Line_3", "Line_4", "Line_5"},
                new int[]{R.id.Line_a, R.id.Line_b, R.id.Line_c, R.id.Line_d, R.id.Line_e});
        listView.setAdapter(sa);
    }
}