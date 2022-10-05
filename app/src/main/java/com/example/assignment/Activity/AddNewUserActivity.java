package com.example.assignment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.assignment.Helper.AppDatabase;
import com.example.assignment.Helper.User;
import com.example.assignment.R;


public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        final EditText fullNameInput =  findViewById(R.id.fullNameInput);
        final EditText emailInput =  findViewById(R.id.emailInput);
        final EditText addressInput =  findViewById(R.id.addressInput);
        final EditText phoneInput =  findViewById(R.id.phoneInput);
        Button saveButton =  findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(fullNameInput.getText().toString(), emailInput.getText().toString(),addressInput.getText().toString(),phoneInput.getText().toString());
            }
        });
    }

    private void saveNewUser(String fullName, String email, String address, String phone) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.fullName = fullName;
        user.email = email;
        user.address = address;
        user.phone = phone;
        db.userDao().insertUser(user);

        finish();

    }

}