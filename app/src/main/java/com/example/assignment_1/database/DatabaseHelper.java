package com.example.assignment_1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "flash_delivery.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ DatabaseSchema.UsersTable.NAME+"("+ DatabaseSchema.UsersTable.Cols.ID+" TEXT, "
                + DatabaseSchema.UsersTable.Cols.EMAIL+" TEXT, "
                + DatabaseSchema.UsersTable.Cols.PASSWORD+" TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
