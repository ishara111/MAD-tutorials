package com.example.assignment_2_part_b.search_page;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_2_part_b.MainActivity;
import com.example.assignment_2_part_b.R;
import com.example.assignment_2_part_b.single_image.SingleImageFragment;
import com.example.assignment_2_part_b.tasks.ImageRetrieveTask;
import com.example.assignment_2_part_b.tasks.SearchTask;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchPageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView searchText;
    Button searchBtn;
    ProgressBar progressBar;
    AppCompatActivity activity;
    MainActivity ma;

    public SearchPageFragment() {
        // Required empty public constructor
    }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchPageFragment.
         */
    // TODO: Rename and change types and number of parameters
    public static SearchPageFragment newInstance(String param1, String param2) {
        SearchPageFragment fragment = new SearchPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_search_page, container, false);

        activity = (AppCompatActivity) view.getContext();

        searchText = view.findViewById(R.id.searchBox);
        searchBtn = view.findViewById(R.id.searchButton);
        progressBar = view.findViewById(R.id.progressBar);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                searchImage();
                ma = (MainActivity)getActivity();


            }
        });
        return view;
    }
    public void searchImage(){
        progressBar.setVisibility(View.VISIBLE);
        SearchTask searchTask = new SearchTask(activity);
        searchTask.setSearchkey(searchText.getText().toString());
        Single<String> searchObservable = Single.fromCallable(searchTask);
        searchObservable = searchObservable.subscribeOn(Schedulers.io());
        searchObservable = searchObservable.observeOn(AndroidSchedulers.mainThread());
        searchObservable.subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
            }

            @Override
            public void onSuccess(@NonNull String s) {
                progressBar.setVisibility(View.INVISIBLE);

                loadImage(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Toast.makeText(activity, "Searching Error", Toast.LENGTH_SHORT).show();
                Log.d(null,e.toString());
                progressBar.setVisibility(View.INVISIBLE);

            }
        });
    }

    public void loadImage(String response){
        ImageRetrieveTask imageRetrievalTask = new ImageRetrieveTask(activity);
        imageRetrievalTask.setData(response);

        progressBar.setVisibility(View.VISIBLE);
        Single<ArrayList<Bitmap>> searchObservable = Single.fromCallable(imageRetrievalTask);
        searchObservable = searchObservable.subscribeOn(Schedulers.io());
        searchObservable = searchObservable.observeOn(AndroidSchedulers.mainThread());
        searchObservable.subscribe(new SingleObserver<ArrayList<Bitmap>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull ArrayList<Bitmap> bitmaps) {
                progressBar.setVisibility(View.INVISIBLE);
                for (Bitmap bitmap:bitmaps) {
                    ma.images.add(bitmap);
                }
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SingleImageFragment(ma.images)).commit();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Toast.makeText(activity, "Image loading error, search again", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });


    }
}