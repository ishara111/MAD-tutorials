package com.example.assignment_2_part_b;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ShowImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.switch_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {  //action menu
        if (item.getItemId()==R.id.switch_view_Btn)
        {
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Checkout_fragment(checkoutList))
                  //  .addToBackStack(null).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}