package com.example.tutorial_6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.tutorial_6.FactionDBSchema.FactionTable;

import androidx.annotation.Nullable;

public class FactionDBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "factions.db";

    public FactionDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+ FactionTable.NAME+"("+FactionTable.Cols.ID+" TEXT, " +FactionTable.Cols.NAME+" TEXT, "+FactionTable.Cols.STRENGTH+" TEXT, " + FactionTable.Cols.RELATIONSHIP+ " TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
