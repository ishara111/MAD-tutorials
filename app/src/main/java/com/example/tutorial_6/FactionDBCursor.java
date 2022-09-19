package com.example.tutorial_6;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.tutorial_6.FactionDBSchema.FactionTable;

public class FactionDBCursor extends CursorWrapper {
    public FactionDBCursor(Cursor cursor) {
        super(cursor);
    }
    public Faction getfaction(){
        //String id = getString(getColumnIndex(FactionTable.Cols.ID));
        String name = getString(getColumnIndex(FactionTable.Cols.NAME));
        String strength = getString(getColumnIndex(FactionTable.Cols.STRENGTH));
        String relationship = getString(getColumnIndex(FactionTable.Cols.RELATIONSHIP));

        return new Faction(name,Integer.parseInt(strength),Integer.parseInt(relationship));
    }
}
