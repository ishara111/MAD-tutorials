/**this fragment logs/registers user using db*/
package com.example.assignment_1.login;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.assignment_1.MainActivity;
import com.example.assignment_1.R;
import com.example.assignment_1.models.User;
import com.example.assignment_1.database.DatabaseCursor;
import com.example.assignment_1.database.DatabaseSchema.UsersTable;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.assignment_1.database.DatabaseHelper;
import com.example.assignment_1.order_history.OrderHistory_fragment;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Login_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Login_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    boolean emailValid,itsOrder;
    public SQLiteDatabase db;

    public Login_fragment() {
        // Required empty public constructor
    }
    public Login_fragment(boolean itsOrder) {
        // Required empty public constructor
        this.itsOrder = itsOrder;
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Login_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Login_fragment newInstance(String param1, String param2) {
        Login_fragment fragment = new Login_fragment();
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
        db = new DatabaseHelper(container.getContext()).getWritableDatabase();

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        EditText emailBox = (EditText) view.findViewById(R.id.loginRegister_username);
        EditText passwordBox = (EditText) view.findViewById(R.id.loginRegister_password);
        Button loginBtn = (Button) view.findViewById(R.id.loginBtn);
        Button registerBtn = (Button) view.findViewById(R.id.registerBtn);
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        emailValid = false;

        emailBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!emailBox.getText().toString().matches(emailPattern) && editable.length() > 0){
                    emailBox.setError("Email not valid");
                    emailValid = false;
                }
                else{
                    emailValid = true;
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailBox.getText().toString().equals(""))
                {
                    emailBox.setError("Email cannot be empty");
                }
                if (passwordBox.getText().toString().equals(""))
                {
                    passwordBox.setError("Password cannot be empty");
                }
                else if (emailValid ==true) {
                    String snack_text;
                    User user = new User(emailBox.getText().toString(), passwordBox.getText().toString());
                    if (userExist(user.email)==false) {
                        ContentValues cv = new ContentValues();
                        cv.put(UsersTable.Cols.ID, user.userid);
                        cv.put(UsersTable.Cols.EMAIL, user.email);
                        cv.put(UsersTable.Cols.PASSWORD, user.password);
                        db.insert(UsersTable.NAME, null, cv);

                        snack_text = ("Successfully Registered Account");
                    }
                    else {
                        snack_text = ("User already exists");
                    }
                    Snackbar.make(getActivity().findViewById(android.R.id.content), snack_text, Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailBox.getText().toString().equals(""))
                {
                    emailBox.setError("Email cannot be empty");
                }
                if (passwordBox.getText().toString().equals(""))
                {
                    passwordBox.setError("Password cannot be empty");
                }
                else if (emailValid ==true)
                {
                    ArrayList<User> userList = new ArrayList<User>();



                    Cursor cursor = db.query(UsersTable.NAME,null,null,null,null,null,null);
                    DatabaseCursor databaseCursor = new DatabaseCursor(cursor);

                    try{
                        databaseCursor.moveToFirst();
                        while(!databaseCursor.isAfterLast()){
                            userList.add(databaseCursor.getUser());
                            databaseCursor.moveToNext();
                        }
                    }
                    finally {
                        cursor.close();
                    }

                    if(userExist(emailBox.getText().toString())==true)
                    {
                        for (User u:userList) {
                            if (u.email.equals(emailBox.getText().toString()) && u.password.equals(passwordBox.getText().toString()))
                            {
                                MainActivity ma = (MainActivity)getActivity();
                                ma.loggedIn = true;
                                ma.loggedUserName = u.email;
                                String snack_text = ("Successfully Logged In As "+u.email);
                                Snackbar.make(getActivity().findViewById(android.R.id.content), snack_text, Snackbar.LENGTH_SHORT).show();
                                if (itsOrder)
                                {
                                    getActivity().getSupportFragmentManager().popBackStack();
                                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new OrderHistory_fragment(ma.historyList))
                                            .commit();
                                }
                                else
                                {
                                    getActivity().getSupportFragmentManager().popBackStackImmediate();
                                }
                            }
                            else
                            {
                                String snack_text = ("Incorrect Username Or password");
                                Snackbar.make(getActivity().findViewById(android.R.id.content), snack_text, Snackbar.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else {
                        String snack_text = ("User Does Not Exist Register First");
                        Snackbar.make(getActivity().findViewById(android.R.id.content), snack_text, Snackbar.LENGTH_SHORT).show();
                    }

                }

            }
        });

        return view;
    }

    public boolean userExist(String email) {

        boolean found = false;
        Cursor csr = db.query(UsersTable.NAME, null,
                UsersTable.Cols.EMAIL + "=?", new String[]{email}, null, null, null);
        if (csr.getCount() > 0) {
            found = true;
        }
        csr.close();
        return found;
    }

    }