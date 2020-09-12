package com.example.project.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AssistTourDB.db";
    DBHandler dbHelper = new DBHandler(getContext());

    private Context getContext() {
        return this.getContext();
    }

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + RoomManager.Rooms.TABLE_NAME + " (" +
                    RoomManager.Rooms.COLUMN_1 + " INTEGER PRIMARY KEY," +
                    RoomManager.Rooms.COLUMN_2 + " TEXT," +
                    RoomManager.Rooms.COLUMN_3 + " TEXT," +
                    RoomManager.Rooms.COLUMN_4 + " TEXT," +
                    RoomManager.Rooms.COLUMN_5 + " TEXT," +
                    RoomManager.Rooms.COLUMN_6 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + RoomManager.Rooms.TABLE_NAME;

    //Add record into SQLITE
    public long addRecord(String type,String features,String location,String price,String des){
            // Gets the data repository in write mode
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // Create a new map of values, where column names are the keys
            ContentValues values = new ContentValues();
            values.put(RoomManager.Rooms.COLUMN_2, type);
            values.put(RoomManager.Rooms.COLUMN_3, features);
            values.put(RoomManager.Rooms.COLUMN_4, location);
            values.put(RoomManager.Rooms.COLUMN_5, price);
            values.put(RoomManager.Rooms.COLUMN_6, des);

            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(RoomManager.Rooms.TABLE_NAME, null, values);

            return newRowId;    }
}
