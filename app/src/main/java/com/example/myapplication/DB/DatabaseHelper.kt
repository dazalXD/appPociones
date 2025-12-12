package com.example.myapplication.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "pocionses.db", null, 1) {

    companion object {
        //TODO implementation
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createIngredientes = """
            CREATE TABLE ingredientes (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT,
                tipo TEXT,
                descripcion TEXT,
                imagen TEXT
            );""".trimIndent()

        db?.execSQL(createIngredientes)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?, oldVersion: Int, newVersion: Int
    ) {
        db?.execSQL("Drop table if exists ingredientes")
        onCreate(db)
    }
}