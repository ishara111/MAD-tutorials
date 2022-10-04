package com.example.tutorial7;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class CapturePhoto extends AppCompatActivity {

    private static final int REQUEST_PHOTO = 3;
    File photoFile;
    Button takePhoto;
    Button greyscale;
    ImageView photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_photo);

        takePhoto = findViewById(R.id.takePhoto_btn);
        greyscale = findViewById(R.id.greyscale_btn);
        photoView = findViewById(R.id.photoView);

        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                photoFile = new File(getFilesDir(),"photo.jpg");
                Uri cameraUri = FileProvider.getUriForFile(getApplicationContext(), BuildConfig.APPLICATION_ID+".fileprovider",photoFile);
                Intent photoIntent = new Intent();
                photoIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                photoIntent.putExtra(MediaStore.EXTRA_OUTPUT,cameraUri);

                PackageManager pm = getPackageManager();
                for(ResolveInfo a : pm.queryIntentActivities(
                        photoIntent, PackageManager.MATCH_DEFAULT_ONLY)) {

                    grantUriPermission(a.activityInfo.packageName, cameraUri,
                            Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                }

                startActivityForResult(photoIntent, REQUEST_PHOTO);

                greyscale.setVisibility(View.VISIBLE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_PHOTO && resultCode == RESULT_OK){
            Bitmap photo = BitmapFactory.decodeFile(photoFile.toString());
            photoView.setImageBitmap(photo);
        }
    }
}