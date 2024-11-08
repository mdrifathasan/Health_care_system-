package com.example.healtcare_system;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class BookAppintmentActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4;
    TextView tv1,tv2;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton, btnBook, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_appintment);


        tv1 = findViewById(R.id.textViewAppTitle);
        tv2 = findViewById(R.id.textView5);
        ed1 = findViewById(R.id.editTextAppFullName);
        ed2 = findViewById(R.id.editTextTextAppAddress);
        ed3 = findViewById(R.id.editTextTextAppContactNumber);
        ed4 = findViewById(R.id.editTextAppFees);
        dateButton = findViewById(R.id.buttonAppDate);
        timeButton = findViewById(R.id.buttonApptime);
        btnBook = findViewById(R.id.buttonAppBookAppointment);
        btnBack = findViewById(R.id.buttonAppBack);

        // Disable editing for the EditText fields
        //ed1.setKeyListener(null);
        //ed2.setKeyListener(null);
       // ed3.setKeyListener(null);
       // ed4.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("title"); // Retrieve the title of the doctor category
        String title2 = it.getStringExtra("title2");
        String doctorName = it.getStringExtra("doctor_name"); // Retrieve the doctor's name
        String hospitalAddress = it.getStringExtra("hospital_address"); // Retrieve the hospital address
        String Contact =it.getStringExtra("Contact_Number");
        String fees = it.getStringExtra("fees"); // Retrieve the fees

        tv1.setText(title);
        tv2.setText(title2);
        ed1.setText(doctorName);
        ed2.setText(hospitalAddress);
        ed3.setText(Contact);
        ed4.setText("Cons Fees: " + fees + "/-");
        // Initialize DatePicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePickerDialog.show();
            }
        });

        // Initialize TimePicker
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });

        // Back button listener
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookAppintmentActivity.this, FindDoctorActivity.class));
            }
        });

        // Book button listener
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the booking logic here
                // Example: Show a confirmation dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(BookAppintmentActivity.this);
                builder.setTitle("Appointment Booked");
                builder.setMessage("Your appointment has been successfully booked.");
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000); // +1 day
    }

    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                String time = hour + ":" + String.format("%02d", minute);
                timeButton.setText(time);
            }
        };

        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hour, minute, true);



        Button bookAppointmentButton = findViewById(R.id.buttonAppBookAppointment);
        bookAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start BookAppointmentActivity
                Intent intent = new Intent(BookAppintmentActivity.this, BookAppintmentActivity.class);
                startActivity(intent);
            }
        });
    }
}