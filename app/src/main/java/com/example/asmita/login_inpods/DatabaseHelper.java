package com.example.asmita.login_inpods;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asmita on 23-04-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "details.db";
    private static final String TABLE_NAME = "details";
    private static final String COLUMN_FNAME = "fname";
    private static final String COLUMN_LNAME = "lname";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASS = "pass";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table details (fname text not null,lname text not null,email text not null,pass text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertDetails(Details d) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FNAME, d.getFname());
        values.put(COLUMN_LNAME, d.getLname());
        values.put(COLUMN_EMAIL, d.getemail());
        values.put(COLUMN_PASS, d.getpass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String email) {
        db = this.getReadableDatabase();
        String query = "select email,pass from" + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        String u, p="not found";
        if (cursor.moveToFirst()) {
            do {
                u = cursor.getString(0);

                if (u.equals(email)) {
                    p = cursor.getString(1);
                    break;
                }

            } while (cursor.moveToNext());
        }
        return p;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    String query="DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
