package com.example.assignment.Adaptor;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.Helper.User;
import com.example.assignment.R;

import java.util.List;


public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private Context context;
    private List<User> userList;
    public UserListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.MyViewHolder holder, int position) {
        holder.tvFullName.setText(this.userList.get(position).fullName);
        holder.tvEmail.setText(this.userList.get(position).email);
        holder.tvAddress.setText(this.userList.get(position).address);
        holder.tvPhone.setText(this.userList.get(position).phone);
    }

    @Override
    public int getItemCount() {
        return  this.userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvFullName;
        TextView tvEmail;
        TextView tvAddress;
        TextView tvPhone;

        public MyViewHolder(View view) {
            super(view);
            tvFullName = view.findViewById(R.id.tvFullName);
            tvEmail = view.findViewById(R.id.tvEmail);
            tvAddress = view.findViewById(R.id.tvAddress);
            tvPhone = view.findViewById(R.id.tvPhone);

        }
    }
}

