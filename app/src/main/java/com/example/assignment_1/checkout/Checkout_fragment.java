/**this fragment will insert checkout list to db to save order history**/
package com.example.assignment_1.checkout;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.assignment_1.models.Checkout;
import com.example.assignment_1.login.Login_fragment;
import com.example.assignment_1.MainActivity;
import com.example.assignment_1.R;
import com.example.assignment_1.database.DatabaseHelper;
import com.example.assignment_1.database.DatabaseSchema;
import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Checkout_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Checkout_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SQLiteDatabase db;

    ArrayList<Checkout> checkoutList;


    public Checkout_fragment() {
        // Required empty public constructor
    }

    public Checkout_fragment(ArrayList<Checkout> checkoutList) {
        this.checkoutList = checkoutList;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Checkout_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Checkout_fragment newInstance(String param1, String param2) {
        Checkout_fragment fragment = new Checkout_fragment();
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
        View view = inflater.inflate(R.layout.fragment_checkout, container, false);

        db = new DatabaseHelper(container.getContext()).getWritableDatabase();

        RecyclerView rv = view.findViewById(R.id.checkout_recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        CheckoutAdapter myAdapter = new CheckoutAdapter(checkoutList);
        rv.setAdapter(myAdapter);

        double allTotalPrice=0;
        DecimalFormat df = new DecimalFormat("#.##");
        TextView allTotalPriceTxt = (TextView) view.findViewById(R.id.checkout_all_total);
        Button checkoutBtn = (Button) view.findViewById(R.id.checkout_button);

        for (Checkout c : checkoutList) {
            allTotalPrice = Double.parseDouble(df.format(allTotalPrice + c.totalPrice));
        }


        allTotalPriceTxt.setText("Total: $"+String.valueOf(allTotalPrice));

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity ma = (MainActivity)getActivity();
                boolean loggedIn = ma.loggedIn;

                if (checkoutList.size()!=0)
                {
                    if (loggedIn == true)
                    {
                        Log.d(null,""+getLastId());
                        int id = getLastId();
                        for (Checkout c:checkoutList) {  /**adding checkout list to db*/
                            ContentValues cv = new ContentValues();
                            cv.put(DatabaseSchema.OrdersTable.Cols.ITEM_ID, (id+1));
                            cv.put(DatabaseSchema.OrdersTable.Cols.ITEM_NAME, c.itemName);
                            cv.put(DatabaseSchema.OrdersTable.Cols.ITEM_PRICE, c.itemPrice);
                            cv.put(DatabaseSchema.OrdersTable.Cols.ITEM_TOTAL_PRICE, c.totalPrice);
                            cv.put(DatabaseSchema.OrdersTable.Cols.ITEM_AMOUNT, c.itemAmount);
                            cv.put(DatabaseSchema.OrdersTable.Cols.ITEM_IMG, c.itemImg);
                            cv.put(DatabaseSchema.OrdersTable.Cols.ITEM_RESTAURANT, c.restaurant);
                            cv.put(DatabaseSchema.OrdersTable.Cols.USERNAME,ma.loggedUserName );
                            db.insert(DatabaseSchema.OrdersTable.NAME, null, cv);
                        }
                        ma.checkoutList.removeAll(checkoutList);
                        String snack_text = ("Order Placed Successfully");
                        Snackbar.make(getActivity().findViewById(android.R.id.content), snack_text, Snackbar.LENGTH_SHORT).show();
                        getActivity().getSupportFragmentManager().popBackStackImmediate();
                    }
                    else{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container,new Login_fragment())
                                .addToBackStack(null).commit();
                    }
                }
                else{
                    String snack_text = ("Checkout Is Empty");
                    Snackbar.make(getActivity().findViewById(android.R.id.content), snack_text, Snackbar.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }

    public int getLastId() {
        int id = 0;
        //SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseSchema.OrdersTable.NAME, new String[] {DatabaseSchema.OrdersTable.Cols.ITEM_ID}, null, null, null, null, null);

        if (cursor.moveToLast()) {
            id = cursor.getInt(0);
        }

        cursor.close();
        return id;
    }
}