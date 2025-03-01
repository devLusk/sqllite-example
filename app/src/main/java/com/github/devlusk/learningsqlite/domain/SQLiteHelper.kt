package com.github.devlusk.learningsqlite.domain

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_NAME (" +
                "$ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$FIRST_NAME TEXT," +
                "$LAST_NAME TEXT)")
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    }

    companion object {
        private const val DATABASE_NAME = "Database.db"
        private const val TABLE_NAME = "Members"
        private const val ID = "ID"
        private const val FIRST_NAME = "first_name"
        private const val LAST_NAME = "last_name"
    }
}
