package com.example.assignment_1.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.assignment_1.User;

public class DatabaseCursor extends CursorWrapper {
    public DatabaseCursor(Cursor cursor) {
        super(cursor);
    }

    public User getUser()
    {
        int userId = Integer.parseInt(getString(getColumnIndex(DatabaseSchema.UsersTable.Cols.ID)));
        String email = getString(getColumnIndex(DatabaseSchema.UsersTable.Cols.EMAIL));
        String password = getString(getColumnIndex(DatabaseSchema.UsersTable.Cols.PASSWORD));

        return new User(userId,email,password);
    }
}
