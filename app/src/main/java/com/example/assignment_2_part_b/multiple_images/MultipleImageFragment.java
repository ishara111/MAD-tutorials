package com.example.assignment_2_part_b.multiple_images;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignment_2_part_b.MainActivity;
import com.example.assignment_2_part_b.R;
import com.example.assignment_2_part_b.single_image.SingleImageAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MultipleImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MultipleImageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Bitmap> images;

    public MultipleImageFragment() {
        // Required empty public constructor
    }

    public MultipleImageFragment(ArrayList<Bitmap> images) {
        this.images = images;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MultipleImageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MultipleImageFragment newInstance(String param1, String param2) {
        MultipleImageFragment fragment = new MultipleImageFragment();
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
        View view= inflater.inflate(R.layout.fragment_multiple_image, container, false);
        RecyclerView rv = view.findViewById(R.id.multi_recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        MultipleImageAdapter multipleImageAdapter= new MultipleImageAdapter(images);
        rv.setAdapter(multipleImageAdapter);

        MainActivity ma = (MainActivity)getActivity();
        ma.singleView=true;

        return view;
    }
}