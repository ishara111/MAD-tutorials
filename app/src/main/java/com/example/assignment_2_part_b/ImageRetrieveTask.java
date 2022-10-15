package com.example.assignment_2_part_b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ImageRetrieveTask implements Callable<ArrayList<Bitmap>> {
    private Activity uiActivity;
    private String data;
    private RemoteUtilities remoteUtilities;
    private ArrayList<String> endpoints;
    private ArrayList<Bitmap> bitmaps;
    public ImageRetrieveTask(Activity uiActivity) {
        remoteUtilities = RemoteUtilities.getInstance(uiActivity);
        this.uiActivity=uiActivity;
        this.data = null;
        this.endpoints = new ArrayList<String>();
        this.bitmaps = new ArrayList<Bitmap>();
    }
    @Override
    public ArrayList<Bitmap> call() throws Exception {
        //Bitmap image = null;
        getEndpoint(this.data);
        if(endpoints.size()==0){
            uiActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(uiActivity,"No images found",Toast.LENGTH_LONG).show();
                }
            });
        }
        else {
            for (String endpoint:endpoints) {
                bitmaps.add(getImageFromUrl(endpoint));
            }
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }

        }
        return bitmaps;
    }

    private void getEndpoint(String data){
//        String imageUrl = null;
        try {
            JSONObject jBase = new JSONObject(data);
            JSONArray jHits = jBase.getJSONArray("hits");
            if(jHits.length()>0){
                for (int i = 0; i < 15; i++) {
                    JSONObject jHitsItem = jHits.getJSONObject(i);
                    endpoints.add(jHitsItem.getString("largeImageURL"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private Bitmap getImageFromUrl(String imageUrl){
        Bitmap image = null;
        Uri.Builder url = Uri.parse(imageUrl).buildUpon();
        String urlString = url.build().toString();
        HttpURLConnection connection = remoteUtilities.openConnection(urlString);
        if(connection!=null){
            if(remoteUtilities.isConnectionOkay(connection)==true){
                image = getBitmapFromConnection(connection);
                connection.disconnect();
            }
        }
        return image;
    }

    public Bitmap getBitmapFromConnection(HttpURLConnection conn){
        Bitmap data = null;
        try {
            InputStream inputStream = conn.getInputStream();
            byte[] byteData = getByteArrayFromInputStream(inputStream);
            data = BitmapFactory.decodeByteArray(byteData,0,byteData.length);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    private byte[] getByteArrayFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[4096];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return buffer.toByteArray();
    }

    public void setData(String data) {
        this.data = data;
    }
}
