package biz.gina.southernbreezetour.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import biz.gina.southernbreezetour.R
import com.savvi.rangedatepicker.CalendarPickerView
import kotlinx.android.synthetic.main.fragment_setting.*
import java.util.*
 import java.text.ParseException
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList


/**
 * Created by PC on 12/18/2017.
 */
class SettingFragment : Fragment() {
   // var calendar: CalendarPickerView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(
                R.layout.fragment_setting, container, false)
        return view


    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nextYear = Calendar.getInstance()
        nextYear.add(Calendar.YEAR, 10)

        val lastYear = Calendar.getInstance()
        lastYear.add(Calendar.YEAR, -10)
        calendar_view!!.init(lastYear.time, nextYear.time) //
                .inMode(CalendarPickerView.SelectionMode.RANGE) //
                .withSelectedDate(Date())



/*
        val dateformat = SimpleDateFormat("dd-MM-yyyy")
        val strdate = "22-06-2017"
        val strdate2 = "26-06-2017"




        try {
            val newdate = dateformat.parse(strdate)
            val newdate2 = dateformat.parse(strdate2)
            var arrayList :MutableList<Date> = ArrayList()
            arrayList.add(newdate)
            arrayList.add(newdate2)
            calendar_view!!.highlightDates(arrayList)
        } catch (e: ParseException) {
            e.printStackTrace()
        }*/


        var list: ArrayList<Int> = ArrayList()
        list.add(1)
        list.add(7)

        calendar_view!!.deactivateDates(list)

        Log.d("list", calendar_view!!.selectedDates.toString())

    }
}