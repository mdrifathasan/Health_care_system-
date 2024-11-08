package com.example.healtcare_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Rifat ", "Hospital Address : Narsingdi ", "Exp : 5 Years", "Mobile Number : 01813330990 ", "1000"},
                    {"Doctor Name : Partho  ", "Hospital Address : Rajbari ", "Exp : 4 Years", "Mobile Number : 01813330123 ", "800"},
                    {"Doctor Name : Naba ", "Hospital Address : Naraongonj ", "Exp : 3 Years", "Mobile Number : 01813330124 ", "1200"},
                    {"Doctor Name : Mim ", "Hospital Address : Dhaka ", "Exp : 7 Years", "Mobile Number : 01813330125 ", "900"},
                    {"Doctor Name : Zakir ", "Hospital Address : Bhashil ", "Exp : 5 Years", "Mobile Number : 01717439618 ", "500"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Rifat ", "Hospital Address : Narsingdi ", "Exp : 5 Years", "Mobile Number : 01813330990 ", "1000"},
                    {"Doctor Name : Partho  ", "Hospital Address : Rajbari ", "Exp : 4 Years", "Mobile Number : 01813330123 ", "800"},
                    {"Doctor Name : Naba ", "Hospital Address : Naraongonj ", "Exp : 3 Years", "Mobile Number : 01813330124 ", "1200"},
                    {"Doctor Name : Mim ", "Hospital Address : Dhaka ", "Exp : 7 Years", "Mobile Number : 01813330125 ", "900"},
                    {"Doctor Name : Zakir ", "Hospital Address : Bhashil ", "Exp : 5 Years", "Mobile Number : 01717439618 ", "500"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Rifat ", "Hospital Address : Narsingdi ", "Exp : 5 Years", "Mobile Number : 01813330990 ", "1000"},
                    {"Doctor Name : Partho  ", "Hospital Address : Rajbari ", "Exp : 4 Years", "Mobile Number : 01813330123 ", "800"},
                    {"Doctor Name : Naba ", "Hospital Address : Naraongonj ", "Exp : 3 Years", "Mobile Number : 01813330124 ", "1200"},
                    {"Doctor Name : Mim ", "Hospital Address : Dhaka ", "Exp : 7 Years", "Mobile Number : 01813330125 ", "900"},
                    {"Doctor Name : Zakir ", "Hospital Address : Bhashil ", "Exp : 5 Years", "Mobile Number : 01717439618 ", "500"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Rifat ", "Hospital Address : Narsingdi ", "Exp : 5 Years", "Mobile Number : 01813330990 ", "1000"},
                    {"Doctor Name : Partho  ", "Hospital Address : Rajbari ", "Exp : 4 Years", "Mobile Number : 01813330123 ", "800"},
                    {"Doctor Name : Naba ", "Hospital Address : Naraongonj ", "Exp : 3 Years", "Mobile Number : 01813330124 ", "1200"},
                    {"Doctor Name : Mim ", "Hospital Address : Dhaka ", "Exp : 7 Years", "Mobile Number : 01813330125 ", "900"},
                    {"Doctor Name : Zakir ", "Hospital Address : Bhashil ", "Exp : 5 Years", "Mobile Number : 01717439618 ", "500"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Rifat ", "Hospital Address : Narsingdi ", "Exp : 5 Years", "Mobile Number : 01813330990 ", "1000"},
                    {"Doctor Name : Partho  ", "Hospital Address : Rajbari ", "Exp : 4 Years", "Mobile Number : 01813330123 ", "800"},
                    {"Doctor Name : Naba ", "Hospital Address : Naraongonj ", "Exp : 3 Years", "Mobile Number : 01813330124 ", "1200"},
                    {"Doctor Name : Mim ", "Hospital Address : Dhaka ", "Exp : 7 Years", "Mobile Number : 01813330125 ", "900"},
                    {"Doctor Name : Zakir ", "Hospital Address : Bhashil ", "Exp : 5 Years", "Mobile Number : 01717439618 ", "500"}
            };


    TextView tv;
    Button btn;
    String[][] doctorDetails = {}; // Rename to camelCase for consistency
    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list; // Change to ArrayList
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.ButtonLabTest);

        ListView listView = findViewById(R.id.listViewDD);


        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family_physicians") == 0)
            doctorDetails = doctor_details1;
        else
        if(title.compareTo("Dietician") == 0)
            doctorDetails = doctor_details2;
        else
        if(title.compareTo("Dentist") == 0)
            doctorDetails = doctor_details3;
        else
        if(title.compareTo("Surgeon") == 0)
            doctorDetails = doctor_details4;
        else
            doctorDetails = doctor_details5;





        // Initialize doctor details based on the received title...

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList<>();
        for(int i = 0; i < doctorDetails.length; i++) {
            item = new HashMap<>();
            item.put("Line_a", doctorDetails[i][0]);
            item.put("Line_b", doctorDetails[i][1]);
            item.put("Line_c", doctorDetails[i][2]);
            item.put("Line_d", doctorDetails[i][3]);
            item.put("Line_e", "Cons Fees: " + doctorDetails[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_line,
                new String[]{"Line_a", "Line_b", "Line_c", "Line_d", "Line_e"},
                new int[]{R.id.Line_a, R.id.Line_b, R.id.Line_c, R.id.Line_d, R.id.Line_e});






        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(DoctorDetailsActivity.this, BookAppintmentActivity.class);
                intent.putExtra("title", title); // Pass the title of the doctor category
                intent.putExtra("doctor_name", doctorDetails[i][0]); // Pass the doctor's name
                intent.putExtra("hospital_address", doctorDetails[i][1]); // Pass the hospital address
                it.putExtra("mobile_number", doctorDetails[i][3]);
                intent.putExtra("fees", doctorDetails[i][4]); // Pass the fees
                startActivity(intent);
            }
        });
    }
}