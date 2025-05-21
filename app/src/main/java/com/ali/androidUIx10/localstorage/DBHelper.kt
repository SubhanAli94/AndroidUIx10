package com.ali.androidUIx10.localstorage

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * DatabaseHelper manages a single table "names" with columns:
 *  - _id: INTEGER PRIMARY KEY AUTOINCREMENT
 *  - name: TEXT
 */
class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {

    companion object {
        private const val DATABASE_NAME = "names_db"
        private const val DATABASE_VERSION = 1

        const val TABLE_NAME = "names"
        const val COLUMN_ID = "_id"
        const val COLUMN_NAME = "name"

        // SQL statement to create the table
        private const val SQL_CREATE_TABLE = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT NOT NULL
            );
        """

        // SQL to drop the table if upgrading
        private const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Create the "names" table
        db.execSQL(SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // For this minimal example, simply drop and recreate on upgrade.
        db.execSQL(SQL_DROP_TABLE)
        onCreate(db)
    }

    /**
     * Insert a new name into the table.
     * Returns the row ID of the newly inserted row, or -1 if an error occurred.
     */
    fun insertName(name: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
        }
        return db.insert(TABLE_NAME, null, values)
    }

    /**
     * Retrieve all rows from the table, returning a Cursor.
     * Caller should close the Cursor when done.
     */
    fun fetchAllNames(): Cursor {
        val db = readableDatabase
        // Query all columns, no WHERE clause, default sort by _id ascending
        return db.query(
            TABLE_NAME,
            arrayOf(COLUMN_ID, COLUMN_NAME),
            null,
            null,
            null,
            null,
            "$COLUMN_ID ASC"
        )
    }
}
