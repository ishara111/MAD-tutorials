/**frgament is used to show all the food items both hot picks and items of a restaurant*/
package com.example.assignment_1.res_items;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment_1.models.FoodItem;
import com.example.assignment_1.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResItems_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResItems_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<FoodItem> items;
    String resName;

    public ResItems_fragment() {
        // Required empty public constructor
    }

    public ResItems_fragment(ArrayList<FoodItem> items,String resName) {
        this.items = items;
        this.resName = resName;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotPicks_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResItems_fragment newInstance(String param1, String param2) {
        ResItems_fragment fragment = new ResItems_fragment();
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

        View view = inflater.inflate(R.layout.fragment_res_items, container, false);

        TextView title;
        title = view.findViewById(R.id.res_items_text);

        if(resName.equals(""))
        {
            title.setText("Top Picks");
        }
        else
        {
            title.setText(resName);
        }


        RecyclerView rv = view.findViewById(R.id.res_items_recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        ResItemsAdapter myAdapter = new ResItemsAdapter(items);
        rv.setAdapter(myAdapter);

        return view;
    }
}