/**this fragment shows all orders placed*/
package com.example.assignment_1.order_history;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignment_1.models.History;
import com.example.assignment_1.MainActivity;
import com.example.assignment_1.models.Order;
import com.example.assignment_1.R;
import com.example.assignment_1.database.DatabaseCursor;
import com.example.assignment_1.database.DatabaseHelper;
import com.example.assignment_1.database.DatabaseSchema;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderHistory_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderHistory_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SQLiteDatabase db;

    ArrayList<History> historyList;

    public OrderHistory_fragment() {
        // Required empty public constructor
    }
    public OrderHistory_fragment(ArrayList<History> historyList) {
        // Required empty public constructor
        this.historyList = historyList;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderHistory_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderHistory_fragment newInstance(String param1, String param2) {
        OrderHistory_fragment fragment = new OrderHistory_fragment();
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
       View view = inflater.inflate(R.layout.fragment_order_history, container, false);

        db = new DatabaseHelper(container.getContext()).getWritableDatabase();
        MainActivity ma = (MainActivity)getActivity();


        int id = getLastId();

        ArrayList<Order> tmp = new ArrayList<Order>();
        Cursor cursor = db.query(DatabaseSchema.OrdersTable.NAME,null,null,null,null,null,null);
        DatabaseCursor databaseCursor = new DatabaseCursor(cursor);

        try{
            databaseCursor.moveToFirst();
            while(!databaseCursor.isAfterLast()){
                tmp.add(databaseCursor.getOrder());
                databaseCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        ma.historyList.removeAll(ma.historyList);
        for (int i = 0; i <=(id+2) ; i++) {
            ArrayList<Order> tempOrder = new ArrayList<Order>();
            for (Order o : tmp) {
                if (o.username.equals(ma.loggedUserName) && o.orderId==i)
                {
                    tempOrder.add(o);
                }
            }
            if (tempOrder.size()>0)
            {
                ma.historyList.add(new History(i, tempOrder));
            }
        }



        RecyclerView rv = view.findViewById(R.id.order_history_recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        OrderHistoryAdapter orderAdapter = new OrderHistoryAdapter(historyList);
        rv.setAdapter(orderAdapter);

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