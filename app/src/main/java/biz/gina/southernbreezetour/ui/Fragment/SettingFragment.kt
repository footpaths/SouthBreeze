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


}