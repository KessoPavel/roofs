package com.roof.roofs.ui.roofList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.roof.roofs.R
import com.roof.roofs.domain.RoofOrder
import com.roof.roofs.ui.roofList.adapter.RoofOrderAdapter
import kotlinx.android.synthetic.main.roof_list_fragment.*

class RoofList : Fragment() {
    private val adapter: RoofOrderAdapter by lazy { RoofOrderAdapter(emptyList()) }

    companion object {
        fun newInstance() = RoofList()
    }

    private lateinit var viewModel: RoofListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.roof_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        roof_list.layoutManager = LinearLayoutManager(context)
        roof_list.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RoofListViewModel::class.java)
        viewModel.roofOrderList.observe(viewLifecycleOwner, updateRoofOrderList())


        viewModel.getOrderList()
    }

    private fun updateRoofOrderList() = Observer<List<RoofOrder>> {
        adapter.list = it
        adapter.notifyDataSetChanged()
    }
}