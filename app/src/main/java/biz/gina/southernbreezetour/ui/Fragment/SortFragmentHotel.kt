package biz.gina.southernbreezetour.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import biz.gina.southernbreezetour.R
import kotlinx.android.synthetic.main.fragment_sort_hotel.*
import org.jetbrains.anko.toast
import java.util.ArrayList
import android.view.Gravity
import android.R.attr.gravity
import android.app.ActionBar
import android.graphics.Color
import android.view.ViewGroup.LayoutParams.FILL_PARENT
import android.widget.LinearLayout
import android.widget.TextView
import android.graphics.Color.LTGRAY







/**
 * Created by PC on 12/18/2017.
 */
class SortFragmentHotel : Fragment(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(p0: AdapterView<*>?) {


    }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        val item = parent?.getItemAtPosition(position).toString()
        Toast.makeText(parent?.context, "Selected: " + item, Toast.LENGTH_LONG).show()
     }

    // var calendar: CalendarPickerView? = null
   var categories : MutableList<String>? = ArrayList()
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(
                R.layout.fragment_sort_hotel, container, false)
        return view


    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categories?.add("Lao")
        categories?.add("Campuchia")
        categories?.add("Campuchia")
        categories?.add("Campuchia")

        val sprache_ratoromanisch_adapter = object : ArrayAdapter<CharSequence>(
                context,
                R.layout.item_spinner,
                categories as List<CharSequence>?) {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val v = super.getView(position, convertView, parent)
                 return v
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View? {
                val v = super.getDropDownView(position, convertView, parent)
                (v as TextView).gravity = Gravity.CENTER

                return v
            }

        }
        spinnerSort?.adapter = sprache_ratoromanisch_adapter


        spinnerSort?.onItemSelectedListener = this
    }


}