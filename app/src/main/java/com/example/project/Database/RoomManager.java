package com.example.project.Database;

import android.provider.BaseColumns;

public final class RoomManager {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private RoomManager() {}

    /* Inner class that defines the table contents */
    public static class Rooms implements BaseColumns {
        public static final String TABLE_NAME = "Rooms";
        public static final String COLUMN_1 = "RoomID";
        public static final String COLUMN_2 = "RoomType";
        public static final String COLUMN_3 = "RoomFeatures";
        public static final String COLUMN_4 = "Location";
        public static final String COLUMN_5 = "RoomPrice";
        public static final String COLUMN_6 = "RoomDescription";
    }
}
