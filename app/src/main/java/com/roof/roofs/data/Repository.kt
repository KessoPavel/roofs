package com.roof.roofs.data

import android.content.Context
import com.roof.roofs.database.entity.RoofOrderEntity
import com.roof.roofs.database.sqlite.DataBase
import com.roof.roofs.domain.RoofOrder

object Repository {
    private val listenerList = ArrayList<UpdateListener>()
    private val orderList = ArrayList<RoofOrder>()
    private lateinit var db: DataBase

    fun init(context: Context) {
        db = DataBase(context)

        db.getRoofOrders().forEach {
            orderList.add(it.toDomain())
        }
    }

    fun addRoofOrder(roofOrder: RoofOrder) {
        db.insert(roofOrder.toEntity())
        orderList.add(roofOrder)
        listenerList.forEach {
            it.newOrder()
        }
    }

    fun getRoofOrderList(): List<RoofOrder> {
        return orderList
    }

    fun addListener(listener: UpdateListener) {
        if (!listenerList.contains(listener)) {
            listenerList.add(listener)
        }
    }

    fun removeListener(listener: UpdateListener) {
        listenerList.remove(listener)
    }

    fun getPassword(login: String): String? {
        return db.getPassword(login)
    }

    interface UpdateListener {
        fun newOrder()
    }
}

fun RoofOrder.toEntity(): RoofOrderEntity {
    return RoofOrderEntity(
        0,
        client,
        address,
        skate,
        leftSlope,
        rightSlope
    )
}

fun RoofOrderEntity.toDomain(): RoofOrder {
    return RoofOrder(
        client,
        address,
        skate,
        leftSlope,
        rightSlope
    )
}