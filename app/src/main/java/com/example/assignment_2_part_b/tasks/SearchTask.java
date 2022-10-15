package com.example.assignment_2_part_b.tasks;

import android.app.Activity;

import com.example.assignment_2_part_b.RemoteUtilities;

import java.net.HttpURLConnection;
import java.util.concurrent.Callable;

public class SearchTask implements Callable<String> {
    private Activity activity;
    private RemoteUtilities remoteUtilities;
    private String searchkey;
    public SearchTask(Activity activity)
    {
        this.searchkey = null;
        this.activity =activity;
        this.remoteUtilities = RemoteUtilities.getInstance(activity);
    }
    @Override
    public String call() throws Exception {
        String response=null;
        String endpoint = "https://pixabay.com/api/?key=23319229-94b52a4727158e1dc3fd5f2db&q="+this.searchkey;
        HttpURLConnection connection = remoteUtilities.openConnection(endpoint);
        if(connection!=null){
            if(remoteUtilities.isConnectionOkay(connection)==true){
                response = remoteUtilities.getResponseString(connection);
                connection.disconnect();
                try {
                    Thread.sleep(3000);
                }
                catch (Exception e){

                }
            }
        }
        return response;
    }

    public void setSearchkey(String searchkey) {
        this.searchkey = searchkey;
    }
}
