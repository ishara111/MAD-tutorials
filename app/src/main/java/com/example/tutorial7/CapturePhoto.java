//uses 3rd party library Glide for image loading: https://bumptech.github.io/glide/
package com.example.tutorial7;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.net.Uri;
import android.provider.MediaStore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;

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
            }
        });

        greyscale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(CapturePhoto.this)
                        .load("file:///data/data/com.example.tutorial7/files/photo.jpg")
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .into(photoView);

                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0);
                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(colorMatrix);
                photoView.setColorFilter(filter);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PHOTO && resultCode == RESULT_OK) {
            Bitmap photo = BitmapFactory.decodeFile(photoFile.toString());
            photoView.setImageBitmap(photo);
        }
        greyscale.setVisibility(View.VISIBLE);
    }
}