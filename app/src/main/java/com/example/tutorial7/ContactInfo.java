package com.example.tutorial7;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ContactInfo extends AppCompatActivity {

    private static final int REQUEST_CONTACT = 2;
    private static final int REQUEST_READ_CONTACT_PERMISSION = 3;
    int contactId;
    Button getContact,getInfo;
    TextView id,name,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        getContact = findViewById(R.id.getContactInfo_btn);
        getInfo = findViewById(R.id.info_btn);
        id = findViewById(R.id.id_text);
        name = findViewById(R.id.name_text);
        email = findViewById(R.id.email_text);
        phone = findViewById(R.id.number_text);

        getContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_PICK);
                intent.setData(ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent,REQUEST_CONTACT);
            }
        });

        getInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(ContactInfo.this, Manifest.permission.READ_CONTACTS)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ContactInfo.this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_READ_CONTACT_PERMISSION);
                }
                else {
                    getInfoClicked();
                    getInfo.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
    private void getInfoClicked(){

        String result="";
        Uri emailUri = Email.CONTENT_URI;
        String[] queryFields = new String[] {
                Email.ADDRESS
        };

        String whereClause = Email.CONTACT_ID + "=?";
        String [] whereValues = new String[]{
                String.valueOf(this.contactId)
        };
        Cursor c = getContentResolver().query(
                emailUri, queryFields, whereClause,whereValues, null);
        try{
            c.moveToFirst();
            do{
                String emailAddress = c.getString(0);
                result = result+emailAddress+" ";
            }
            while (c.moveToNext());

        }
        finally {
            c.close();
        }

        email.setText(result);
        email.setVisibility(View.VISIBLE);

        String num ="";
        Uri numUri = Phone.CONTENT_URI;
        String[] queryNumFields = new String[] {
                Phone.NUMBER
        };

        String numwhereClause = Phone.CONTACT_ID + "=?";
        String [] numwhereValues = new String[]{
                String.valueOf(this.contactId)
        };
        Cursor nc = getContentResolver().query(
                numUri, queryNumFields, numwhereClause,numwhereValues, null);
        try{
            nc.moveToFirst();
            do{
                String number = nc.getString(0);
                num = num+number+" ";
            }
            while (nc.moveToNext());

        }
        finally {
            nc.close();
        }
        phone.setText(num);
        phone.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            String[] queryFields = new String[]{
                    ContactsContract.Contacts._ID,
                    ContactsContract.Contacts.DISPLAY_NAME
            };
            Cursor c = getContentResolver().query(
                    contactUri, queryFields, null, null, null);
            try {
                if (c.getCount() > 0) {
                    c.moveToFirst();
                    this.contactId = c.getInt(0);         // ID first
                    String contactName = c.getString(1); // Name second
                    name.setVisibility(View.VISIBLE);
                    id.setVisibility(View.VISIBLE);
                    name.setText(contactName);
                    id.setText("ID: " + String.valueOf(this.contactId));
                    getInfo.setVisibility(View.VISIBLE);
                }
            } finally {
                c.close();
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_READ_CONTACT_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(ContactInfo.this, "Contact Reading Permission Granted", Toast.LENGTH_SHORT).show();
                getInfoClicked();
            }
        }
    }
}