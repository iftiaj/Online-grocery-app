package com.example.assignment.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.assignment.Adaptor.UserListAdapter;
import com.example.assignment.Helper.AppDatabase;
import com.example.assignment.Helper.User;
import com.example.assignment.R;

import java.util.List;

public class CustomerRegActivity extends AppCompatActivity {
    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_reg);

        Button addNewUserButton = findViewById(R.id.addNewUserButton);
        addNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(CustomerRegActivity.this, AddNewUserActivity.class), 100);
            }
        });

        initRecyclerView();
        loadUserList();

    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        userListAdapter = new UserListAdapter(this);
        recyclerView.setAdapter(userListAdapter);

    }
    private void loadUserList() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<User> userList =db.userDao().getAllUsers();
        userListAdapter.setUserList(userList);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100) {
            loadUserList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}