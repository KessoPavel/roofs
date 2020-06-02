package com.roof.roofs.ui.roofList.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roof.roofs.R
import com.roof.roofs.domain.RoofOrder
import com.roof.roofs.inflate
import kotlinx.android.synthetic.main.roof_item.view.*

class RoofOrderAdapter(var list: List<RoofOrder>): RecyclerView.Adapter<RoofOrderAdapter.RoofOrderHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoofOrderHolder {
        val inflateView = parent.inflate(R.layout.roof_item, false)
        return RoofOrderHolder(inflateView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RoofOrderHolder, position: Int) {
        holder.bind(list[position])
    }

    class RoofOrderHolder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bind(roofOrder: RoofOrder) {
            itemView.client_name.text = roofOrder.client
            itemView.address.text = roofOrder.address
            itemView.skate.text =
                "skate: ${roofOrder.skate}, slope left: ${roofOrder.leftSlope}, slope right: ${roofOrder.rightSlope}"
        }
    }
}