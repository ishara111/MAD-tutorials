package com.example.assignment_2_part_b;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.assignment_2_part_b.multiple_images.MultipleImageFragment;
import com.example.assignment_2_part_b.search_page.SearchPageFragment;
import com.example.assignment_2_part_b.single_image.SingleImageFragment;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public boolean singleView = true;

    public ArrayList<Bitmap> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = new ArrayList<Bitmap>();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new SearchPageFragment()).addToBackStack(null).commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.switch_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@androidx.annotation.NonNull MenuItem item) {  //action menu
        if (item.getItemId()==R.id.switch_view_Btn)
        {
            if (singleView)
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SingleImageFragment(images)).commit();
            }
            else{
                if(images.size()!=1)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new MultipleImageFragment(images)).commit();
                }
                else
                {
                    Snackbar.make(this.findViewById(android.R.id.content),
                            "Cannot change view only 1 search result", Snackbar.LENGTH_SHORT).show();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }
}