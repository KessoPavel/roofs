package com.roof.roofs.database.sqlite

import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import com.roof.roofs.database.entity.RoofOrderEntity

class RoofOrderDB(context: Context) {
    private val writableDb = RoofOrderDbHelper(context).writableDatabase
    private val readableDb = RoofOrderDbHelper(context).readableDatabase

    fun getRoofOrders(): List<RoofOrderEntity> {
        val projection = arrayOf(
            BaseColumns._ID,
            RoofOrderContract.COLUMN_CLIENT,
            RoofOrderContract.COLUMN_ADDRESS,
            RoofOrderContract.COLUMN_SKATE,
            RoofOrderContract.COLUMN_LEFT_SLOPE,
            RoofOrderContract.COLUMN_RIGHT_SLOPE
        )

        val cursor = readableDb.query(RoofOrderContract.TABLE_NAME, projection, null, null, null, null, null)

        val orders = ArrayList<RoofOrderEntity>()

        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow(BaseColumns._ID))
                val client = getString(getColumnIndexOrThrow(RoofOrderContract.COLUMN_CLIENT))
                val address = getString(getColumnIndexOrThrow(RoofOrderContract.COLUMN_ADDRESS))
                val skate = getInt(getColumnIndexOrThrow(RoofOrderContract.COLUMN_SKATE))
                val leftSlope = getInt(getColumnIndexOrThrow(RoofOrderContract.COLUMN_LEFT_SLOPE))
                val rightSlope = getInt(getColumnIndexOrThrow(RoofOrderContract.COLUMN_RIGHT_SLOPE))


                orders.add(RoofOrderEntity(id, client, address, skate, leftSlope, rightSlope))
            }
        }

        return orders
    }

    fun insert(roofOrder: RoofOrderEntity): Boolean {
        val values = ContentValues().apply {
            put(RoofOrderContract.COLUMN_CLIENT, roofOrder.client)
            put(RoofOrderContract.COLUMN_ADDRESS, roofOrder.address)
            put(RoofOrderContract.COLUMN_SKATE, roofOrder.skate)
            put(RoofOrderContract.COLUMN_LEFT_SLOPE, roofOrder.leftSlope)
            put(RoofOrderContract.COLUMN_RIGHT_SLOPE, roofOrder.rightSlope)
        }

        return writableDb?.replace(RoofOrderContract.TABLE_NAME, null, values) == -1L
    }
}