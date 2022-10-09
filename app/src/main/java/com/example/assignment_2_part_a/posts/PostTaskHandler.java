package com.example.assignment_2_part_a.posts;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;

import com.example.assignment_2_part_a.MainActivity;
import com.example.assignment_2_part_a.users.GetUsersTask;
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

public class PostTaskHandler implements Runnable{

    private Activity activity;
    private MainActivity ma;
    private ArrayList<Post> posts;
    private ProgressBar progressBar;
    private int id;

    public PostTaskHandler(MainActivity ma, Activity activity, ArrayList<Post> posts, ProgressBar progressBar,int id) {
        this.activity = activity;
        this.ma = ma;
        this.posts=posts;
        this.progressBar =progressBar;
        this.id=id;
    }

    @Override
    public void run() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        GetPostsTask getPostsTask = new GetPostsTask(activity);
        Future<String> resPlaceholder = executorService.submit(getPostsTask);
        String returnUsers = awaitingPosts(resPlaceholder);

        if(returnUsers!=null){
            addToList(returnUsers);
            ma.startPostsFrag();
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
                int uid = user.getInt("userId");
                if (uid==id)
                {
                    String title = user.getString("title");
                    String body = user.getString("body");
                    posts.add(new Post(title,body));
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String awaitingPosts(Future<String> resPlaceholder){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
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
            Snackbar.make(activity.findViewById(android.R.id.content), " Task Timeout Exception",
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
