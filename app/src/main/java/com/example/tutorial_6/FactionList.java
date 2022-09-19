package com.example.tutorial_6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.example.tutorial_6.FactionDBSchema.FactionTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Maintains the overall dataset; specifically of course all the different factions.
 */
public class FactionList
{
    private List<Faction> factions = new ArrayList<>();

    public FactionList() {}

    public SQLiteDatabase db;

    public void load(Context context)
    {
        this.db = new FactionDBHelper(context).getWritableDatabase();
    }

    public int size()
    {
        return factions.size();
    }

    public Faction get(int i)
    {
        //ArrayList<Faction> facList = new ArrayList<>();
        return factions.get(i);
    }

    public int add(Faction newFaction)
    {
        //factions.add(newFaction);
        ContentValues cv = new ContentValues();
        cv.put(FactionTable.Cols.ID, newFaction.getId());
        cv.put(FactionTable.Cols.NAME, newFaction.getName());
        cv.put(FactionTable.Cols.STRENGTH, newFaction.getStrength());
        cv.put(FactionTable.Cols.RELATIONSHIP, newFaction.getRelationship());
        db.insert(FactionTable.NAME, null, cv);

        Cursor cursor = db.query(FactionTable.NAME,null,null,null,null,null,null);
        FactionDBCursor factionDBCursor = new FactionDBCursor(cursor);

        try{
            factionDBCursor.moveToFirst();
            while(!factionDBCursor.isAfterLast()){
                factions.add(factionDBCursor.getfaction());
                factionDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }



        //return (int)DatabaseUtils.queryNumEntries(db, FactionTable.NAME));

        return factions.size() - 1; // Return insertion point
    }

    public void edit(Faction newFaction)
    {
        // ...
    }

    public void remove(Faction rmFaction)
    {
        factions.remove(rmFaction);
        // ...
    }
}
