package com.roof.roofs.database.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class RoofOrderDbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
        db.execSQL(SQL_CREATE_USERS)
        db.execSQL(SQL_INSERT_USER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }


    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "roofs.db"

        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${RoofOrderContract.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${RoofOrderContract.COLUMN_CLIENT} TEXT," +
                    "${RoofOrderContract.COLUMN_ADDRESS} TEXT," +
                    "${RoofOrderContract.COLUMN_SKATE} INTEGER," +
                    "${RoofOrderContract.COLUMN_LEFT_SLOPE} INTEGER," +
                    "${RoofOrderContract.COLUMN_RIGHT_SLOPE} INTEGER)"
        private const val SQL_CREATE_USERS =
            "CREATE TABLE ${UserContract.TABLE_NAME} (" +
                    "${UserContract.COLUMN_LOGIN} TEXT PRIMARY KEY," +
                    "${UserContract.COLUMN_PASSWORD} TEXT)"
        private const val SQL_INSERT_USER =
            "INSERT INTO ${UserContract.TABLE_NAME} " +
                    "(${UserContract.COLUMN_LOGIN}, ${UserContract.COLUMN_PASSWORD}) " +
                    "VALUES ('login', 'pass');"

        private const val SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS ${RoofOrderContract.TABLE_NAME}"
    }
}