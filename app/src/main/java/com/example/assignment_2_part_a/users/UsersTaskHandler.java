package com.example.assignment_2_part_a.users;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.assignment_2_part_a.MainActivity;
import com.example.assignment_2_part_a.users.GetUsersTask;
import com.example.assignment_2_part_a.users.User;
import com.google.android.material.snackbar.Snackbar;

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

public class UsersTaskHandler implements Runnable{
    private Activity activity;
    private MainActivity ma;
    private ArrayList<User> users;
    private ProgressBar progressBar;

    public UsersTaskHandler(MainActivity ma, Activity activity, ArrayList<User> users, ProgressBar progressBar) {
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
            Snackbar.make(activity.findViewById(android.R.id.content), "Something went wrong restart application",
                    Snackbar.LENGTH_SHORT).show();
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String awaitingUsers(Future<String> resPlaceholder){
        String searchResponseData =null;
        try {
            searchResponseData = resPlaceholder.get(6000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
            Snackbar.make(activity.findViewById(android.R.id.content), "Task Execution Exception",
                    Snackbar.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Snackbar.make(activity.findViewById(android.R.id.content), "Task Interrupted Exception",
                    Snackbar.LENGTH_SHORT).show();
        } catch (TimeoutException e) {
            e.printStackTrace();
            Snackbar.make(activity.findViewById(android.R.id.content), "Task Timeout Exception",
                    Snackbar.LENGTH_SHORT).show();
        }
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        return  searchResponseData;
    }
}
