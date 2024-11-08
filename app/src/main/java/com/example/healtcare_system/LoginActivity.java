package com.example.healtcare_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername,edPassword;
    Button btn;
    TextView TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        TV = findViewById(R.id.textViewNewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginUser();

                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                /*startActivity(new Intent(loginActivity.this,HomeActivity.class));
                String Username = edUsername.getText().toString();
                String Password = edPassword.getText().toString();
                Database db = new Database(getApplicationContext(),"Healthcare",null,1);
                if(Username.length()==0 || Password.length()==0){
                    Toast.makeText(getApplicationContext(), "Plese fill All Details ", Toast.LENGTH_SHORT).show();
                }else {
                    if(db.login(Username,Password)==1){

                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("Username",Username);
                        editor.apply();
                        startActivity(new Intent(loginActivity.this,HomeActivity.class));
                    }else {
                        Toast.makeText(getApplicationContext(), "InValid Username And Password", Toast.LENGTH_SHORT).show();

                    }



                }*/
            }
        });

        TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
        private void loginUser() {
            String username = edUsername.getText().toString();
            String password = edPassword.getText().toString();
            // Add your login logic here
            // For example, start a new activity if login is successful
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));



    }

    public void onClick(Button mockLoginButton) {
    }

    public void login(String username, String password) {
    }
}