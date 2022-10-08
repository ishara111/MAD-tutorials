package com.example.assignment_2_part_a;

import android.app.Activity;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ConnectionUtilities {
    private Activity activity;
    public static ConnectionUtilities connection = null;

    public ConnectionUtilities(Activity activity) {
        this.activity = activity;
    }

    public static ConnectionUtilities getInstance(Activity activity){
        if(connection == null){
            connection = new ConnectionUtilities(activity);
        }
        connection.activity=activity;
        return connection;
    }

    public HttpURLConnection openConnection(String urlString)  {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(conn == null){
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity,"Check Internet",Toast.LENGTH_LONG).show();
                }
            });

        }
        return conn;
    }

    public boolean isConnectionOkay(HttpURLConnection conn){
        try {
            if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity,"Problem with API Endpoint",Toast.LENGTH_LONG).show();
                }
            });
        }
        return false;
    }

    public String getResponseString(HttpURLConnection conn){
        String data = null;
        try {
            InputStream inputStream = conn.getInputStream();
            byte[] byteData = IOUtils.toByteArray(inputStream);
            data = new String(byteData, StandardCharsets.UTF_8);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
