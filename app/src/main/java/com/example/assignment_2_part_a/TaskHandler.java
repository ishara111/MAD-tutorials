package com.example.assignment_2_part_a;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TaskHandler implements Runnable{
    private Activity activity;
    private MainActivity ma;
    private ArrayList<User> users;
    private ProgressBar progressBar;

    public TaskHandler(MainActivity ma,Activity activity,ArrayList<User> users,ProgressBar progressBar) {
        this.activity = activity;
        this.ma = ma;
        this.users=users;
        this.progressBar =progressBar;
    }

    @Override
    public void run() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        GetUsersTask getUsersTask = new GetUsersTask(activity);
        Future<String> resPlaceholder = executorService.submit(getUsersTask);
        String returnUsers = awaitingUsers(resPlaceholder);

        if(returnUsers!=null){
            addToList(returnUsers);
            ma.startUsersFrag();
        }
        else{
            showError(4,"Search");
        }
        executorService.shutdown();
    }

    private void addToList(String data){
        String imageUrl = null;
        try {
            JSONArray jBase = new JSONArray(data);
            for (int i = 0; i < jBase.length(); i++) {
                JSONObject user = jBase.getJSONObject(i);
                int id = user.getInt("id");
                String name = user.getString("name");
                String username = user.getString("username");
                String email = user.getString("email");

                JSONObject address = user.getJSONObject("address");
                String street = address.getString("street");
                String suite = address.getString("suite");
                String city = address.getString("city");
                String zipcode = address.getString("zipcode");

                JSONObject geo = address.getJSONObject("geo");
                String lat = geo.getString("lat");
                String lng = geo.getString("lng");

                String phone = user.getString("phone");
                String website = user.getString("website");

                JSONObject company = user.getJSONObject("company");
                String cname = company.getString("name");
                String catchphrase = company.getString("catchPhrase");
                String bs = company.getString("bs");

                users.add(new User(id,name,username,email,street,suite,
                        city,zipcode,lat,lng,phone,website,cname,catchphrase,bs));

            }
//            JSONArray jHits = jBase.getJSONArray("hits");
//            if(jHits.length()>0){
//                JSONObject jHitsItem = jHits.getJSONObject(0);
//                imageUrl = jHitsItem.getString("largeImageURL");
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String awaitingUsers(Future<String> resPlaceholder){
        showToast("Search Starts");
        String searchResponseData =null;
        try {
            searchResponseData = resPlaceholder.get(6000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
            showError(1, "Search");
        } catch (InterruptedException e) {
            e.printStackTrace();
            showError(2, "Search");
        } catch (TimeoutException e) {
            e.printStackTrace();
            showError(3, "Search");
        }
        showToast("Search Ends");
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        return  searchResponseData;
    }

    public void showError(int code, String taskName){
        if(code ==1){
            showToast(taskName+ " Task Execution Exception");
        }
        else if(code ==2){
            showToast(taskName+" Task Interrupted Exception");
        }
        else if(code ==3){
            showToast(taskName+" Task Timeout Exception");
        }
        else{
            showToast(taskName+" Task could not be performed. Restart!!");
        }
    }

    public void showToast(String text){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity,text,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
