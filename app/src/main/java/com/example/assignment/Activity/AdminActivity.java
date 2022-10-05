package com.example.assignment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment.R;

public class AdminActivity extends AppCompatActivity {

    private EditText userAdmin,adminPass;
    private Button adminLogin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        userAdmin =(EditText) findViewById(R.id.inputAdminUsername);
        adminPass =(EditText) findViewById(R.id.inputAdminPassword);

        adminLogin = (Button) findViewById(R.id.btnAdminLogin);

        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check();
            }
        });

    }

    public void check(){

        if(userAdmin.getText().toString().equals("admin") && adminPass.getText().toString().equals("1234")) {

            adminLogin = (Button) findViewById(R.id.btnAdminLogin);
            adminLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AdminActivity.this,AddNewUserActivity.class);
                    startActivity(intent);
                }
            });
        }
        else{
            Toast.makeText(this, "Wrong username or password! try again", Toast.LENGTH_SHORT).show();
        }
    }
}