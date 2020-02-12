package com.example.infocity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    SQLiteDatabase db = null;
    @Before
    public void setUp(){
        String myPath = "/data/data/com.example.infocity/databases/utopia_cities.db";
        db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    @After
    public void finish() {
        db.close();
    }
    @Test
    public void testIsCorrectNumberLine() {
        Cursor res = db.rawQuery("SELECT * FROM cities",null);
        assertThat(res.getCount(),is(272128));
        db.close();
    }
}