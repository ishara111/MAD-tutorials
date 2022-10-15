package com.example.assignment_2_part_b.single_image;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2_part_b.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class SingleImageViewHolder extends RecyclerView.ViewHolder{
    ImageView image;
    FirebaseStorage storage;
    StorageReference storageReference;
    Bitmap bitmap;
    public SingleImageViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.singleImg);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();



        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] data = baos.toByteArray();

                StorageReference ref = storageReference.child("images/" + UUID.randomUUID().toString());
                ref.putBytes(data)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                Snackbar.make(activity.findViewById(android.R.id.content),
                                        "Uploaded", Snackbar.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(activity.findViewById(android.R.id.content),
                                        "Error uploading", Snackbar.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
