package com.example.assignment_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddToBasket_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddToBasket_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Double total;


    public AddToBasket_fragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddToBasket_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddToBasket_fragment newInstance(String param1, String param2) {
        AddToBasket_fragment fragment = new AddToBasket_fragment();
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

        View view = inflater.inflate(R.layout.fragment_add_to_basket, container, false);
        TextView itemName = (TextView) view.findViewById(R.id.add_item_name);
        TextView itemPrice = (TextView) view.findViewById(R.id.add_item_price);
        TextView itemTotal = (TextView) view.findViewById(R.id.add_total_price);
        TextView itemAmount = (TextView) view.findViewById(R.id.add_item_amount);
        Button addToBasketBtn = (Button) view.findViewById(R.id.add_to_basket);
        Button backButton = (Button) view.findViewById(R.id.add_back_btn);
        Button plusBtn = (Button) view.findViewById(R.id.add_plus_btn);
        Button minusBtn = (Button) view.findViewById(R.id.add_minus_btn);

        String name = getArguments().getString("name");
        String priceStr = getArguments().getString("price");
        Double price = Double.valueOf(priceStr.replace("$", ""));
        total = Double.parseDouble(itemAmount.getText().toString())*price;

        itemName.setText(name);
        itemPrice.setText(priceStr);
        itemTotal.setText(total.toString());

        MainActivity ma = (MainActivity)getActivity();
        ArrayList<Checkout> checkoutList = ma.checkoutList;

        addToBasketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount = Integer.parseInt(itemAmount.getText().toString());
                amount +=1;
                itemAmount.setText(""+amount);
                total = price * amount;
                itemTotal.setText(total.toString());

            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int amount = Integer.parseInt(itemAmount.getText().toString());
                if(amount!=1)
                {
                    amount -=1;
                    itemAmount.setText(""+amount);
                    total = price * amount;
                    itemTotal.setText(total.toString());
                }
            }
        });



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });
        return view;
    }
}