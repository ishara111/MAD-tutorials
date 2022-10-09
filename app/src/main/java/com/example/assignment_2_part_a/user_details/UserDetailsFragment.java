package com.example.assignment_2_part_a.user_details;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment_2_part_a.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserDetailsFragment newInstance(String param1, String param2) {
        UserDetailsFragment fragment = new UserDetailsFragment();
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
       View view = inflater.inflate(R.layout.fragment_user_details, container, false);

        TextView name,username,email,address,geo,phone,website,cname,catchphrase,bs;

        name = view.findViewById(R.id.name);
        username = view.findViewById(R.id.uname);
        email = view.findViewById(R.id.email);
        address = view.findViewById(R.id.address);
        geo = view.findViewById(R.id.geo);
        phone = view.findViewById(R.id.phone);
        website = view.findViewById(R.id.website);
        cname = view.findViewById(R.id.companyName);
        catchphrase = view.findViewById(R.id.catchphrase);
        bs = view.findViewById(R.id.bs);

        name.setText("Name: "+getArguments().getString("name"));
        username.setText("Username: "+getArguments().getString("username"));
        email.setText("Email: "+getArguments().getString("email"));
        address.setText("Address: "+getArguments().getString("address"));
        geo.setText("Geo: "+getArguments().getString("geo"));
        phone.setText("Phone: "+getArguments().getString("phone"));
        website.setText("Website: "+getArguments().getString("website"));
        cname.setText("CompanyName: "+getArguments().getString("companyName"));
        catchphrase.setText("CatchPhrase: "+getArguments().getString("catchPhrase"));
        bs.setText("Bs: "+getArguments().getString("bs"));


       return view;
    }
}