package com.github.devlusk.learningsqlite.domain

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE $TABLE_NAME (" +
                    "$ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$FIRST_NAME TEXT," +
                    "$LAST_NAME TEXT)"
        )
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    }

    fun insertValues(firstName: String?, lastName: String?) {
        val db = writableDatabase
        val contentValues = ContentValues()

        contentValues.put(FIRST_NAME, firstName)
        contentValues.put(LAST_NAME, lastName)
        db.insert(TABLE_NAME, null, contentValues)
    }

    fun getAllValues(): List<Member> {
        val db = readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(FIRST_NAME, LAST_NAME),
            null,
            null,
            null,
            null,
            null
        )

        val members = mutableListOf<Member>()

        while (cursor.moveToNext()) {
            val firstName = cursor.getString(cursor.getColumnIndex(FIRST_NAME))
            val lastName = cursor.getString(cursor.getColumnIndex(LAST_NAME))
            members.add(Member(firstName, lastName))
        }

        cursor.close()

        return members
    }

    fun deleteByFirstName(firstName: String) {
        val db = writableDatabase
        db.delete(TABLE_NAME, "$FIRST_NAME = ?", arrayOf(firstName))
    }

    companion object {
        private const val DATABASE_NAME = "Database.db"
        private const val TABLE_NAME = "Members"
        private const val ID = "ID"
        private const val FIRST_NAME = "first_name"
        private const val LAST_NAME = "last_name"
    }
}
