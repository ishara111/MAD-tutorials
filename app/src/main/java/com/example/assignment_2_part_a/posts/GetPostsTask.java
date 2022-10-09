package com.example.assignment_2_part_a.posts;

import android.app.Activity;

import com.example.assignment_2_part_a.ConnectionUtilities;

import java.net.HttpURLConnection;
import java.util.concurrent.Callable;

public class GetPostsTask implements Callable<String> {
    private Activity activity;
    private ConnectionUtilities connectionUtilities;
    public GetPostsTask(Activity activity)
    {
        this.activity =activity;
        this.connectionUtilities = ConnectionUtilities.getInstance(activity);
    }
    @Override
    public String call() throws Exception {
        String response=null;
        String endpoint = "https://jsonplaceholder.typicode.com/posts";
        HttpURLConnection connection = connectionUtilities.openConnection(endpoint);
        if(connection!=null){
            if(connectionUtilities.isConnectionOkay(connection)==true){
                response = connectionUtilities.getResponseString(connection);
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
}
