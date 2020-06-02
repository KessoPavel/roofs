package com.roof.roofs.ui.addRoof

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.roof.roofs.R
import com.roof.roofs.domain.RoofOrder
import kotlinx.android.synthetic.main.add_roof_fragment.*
import kotlinx.android.synthetic.main.add_roof_fragment.view.*

class AddRoof : Fragment() {

    companion object {
        fun newInstance() = AddRoof()
    }

    private lateinit var viewModel: AddRoofViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_roof_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.clear.setOnClickListener {
            clearFields()
        }
        view.add.setOnClickListener {
            if (checkOrderFields()){
                addRoof()
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddRoofViewModel::class.java)
    }

    private fun checkOrderFields(): Boolean {
        return checkFields(client_name, address, skate_roof, roof_slope_left, roof_slope_right)
    }

    private fun addRoof() {
        val order = RoofOrder(
            client = client_name.text.toString(),
            address = address.text.toString(),
            skate = skate_roof.text.toString().toInt(),
            leftSlope = roof_slope_left.text.toString().toInt(),
            rightSlope = roof_slope_right.text.toString().toInt()
        )

        viewModel.addRoof(order)
        clearFields()
    }

    private fun clearFields() {
        client_name.setText("")
        client_name.error = null
        address.setText("")
        address.error = null
        skate_roof.setText("")
        skate_roof.error = null
        roof_slope_left.setText("")
        roof_slope_left.error = null
        roof_slope_right.setText("")
        roof_slope_right.error = null
    }

    private fun checkFields(vararg viewList: EditText): Boolean {
        var fieldsReady = true

        viewList.forEach {
            if (it.text.isEmpty()) {
                it.error = getString(R.string.empty_field)
                fieldsReady = false
            }
        }

        return fieldsReady
    }
}