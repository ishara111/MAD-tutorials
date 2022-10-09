package com.example.assignment_2_part_a.users;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2_part_a.R;
import com.example.assignment_2_part_a.user_details.UserDetailsFragment;

public class UsersViewHolder extends RecyclerView.ViewHolder{
    TextView username;
    User user;
    public UsersViewHolder(@NonNull View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.username);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                UserDetailsFragment userDetailsFragment = new UserDetailsFragment();
                Bundle args = new Bundle();
                args.putString("id",String.valueOf(user.id));
                args.putString("name",user.name);
                args.putString("username",user.username);
                args.putString("email",user.email);
                args.putString("address",user.address.suite+", "+user.address.street+",\n"+user.address.city+", "+user.address.zipcode);
                args.putString("geo",user.address.geo.lat+", "+user.address.geo.lng);
                args.putString("phone",user.phone);
                args.putString("website",user.website);
                args.putString("companyName",user.company.companyName);
                args.putString("catchPhrase",user.company.catchPhrase);
                args.putString("bs",user.company.bs);
                userDetailsFragment.setArguments(args);
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, userDetailsFragment).addToBackStack(null).commit();
            }
        });
    }
}
