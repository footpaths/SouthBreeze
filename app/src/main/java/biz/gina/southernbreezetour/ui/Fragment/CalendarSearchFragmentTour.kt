package biz.gina.southernbreezetour.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import biz.gina.southernbreezetour.R
import com.squareup.timessquare.CalendarPickerView
import kotlinx.android.synthetic.main.fragment_tour_calendar_layout.*
import org.jetbrains.anko.toast
import java.util.*

/**
 * Created by PC on 12/18/2017.
 */
class CalendarSearchFragmentTour : Fragment(), CalendarPickerView.OnDateSelectedListener {



    override fun onDateSelected(date: Date?) {

        SearchFragment.instance.dayTour = DateFormat.format("dd", date).toString()   // 20
        SearchFragment.instance.monthTour = DateFormat.format("MMM", date).toString()
        SearchFragment.instance.dayOfWeekTour = DateFormat.format("EEEE", date).toString()
        SearchFragment.instance.datesTour = date

        txtDayOfWeekTourCalendar.text = SearchFragment.instance.dayOfWeekTour
        txtDayMonthTourCalendar.text = SearchFragment.instance.monthTour + " " + SearchFragment.instance.dayTour

        // activity.toast("startDate: "+ startDate + "endDate: "+ endDate)
        /* var dayOfTheWeek = DateFormat.format("EE", date) as String // Thursday
         var day = DateFormat.format("dd", date) as String // 20
         var monthString = DateFormat.format("MMM", date) as String // Jun
         var monthNumber = DateFormat.format("MM", date) as String // 06
         var year = DateFormat.format("yyyy", date) as String // 2013*/
    }

    override fun onDateUnselected(date: Date?) {
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
         val view = inflater!!.inflate(R.layout.fragment_tour_calendar_layout, container, false)
        return view
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextYear = Calendar.getInstance()
        nextYear.add(Calendar.YEAR, 1)

        val lastYear = Calendar.getInstance()
        lastYear.add(Calendar.YEAR, -1)
    if (SearchFragment.instance.datesTour == null){
        calendar_view.init(Date(), nextYear.time) //
                .inMode(CalendarPickerView.SelectionMode.SINGLE) //
                .withSelectedDate(Date())
    }else{
        calendar_view.init(Date(), nextYear.time) //
                .inMode(CalendarPickerView.SelectionMode.SINGLE) //
                .withSelectedDate(SearchFragment.instance.datesTour)
    }


        calendar_view.setOnDateSelectedListener(this)
        txtDayOfWeekTourCalendar.text = SearchFragment.instance.dayOfWeekTour
        txtDayMonthTourCalendar.text = SearchFragment.instance.monthTour + " " + SearchFragment.instance.dayTour
        done_button.setOnClickListener {
            SearchFragment.instance.checkTab =2
            activity.onBackPressed()
        }


     /*   calendar_view.setCustomDayView(DefaultDayViewAdapter())
        dateLeft.text = "${SearchFragment.instance.monthStartedHotel} ${SearchFragment.instance.dayStartedHotel}"
        dateRight.text = "${SearchFragment.instance.monthEndHotel} ${SearchFragment.instance.dayEndHotel}"

        if (SearchFragment.instance.tempSize!! == 0) {
            done_button.text = "OK (1 Nights)"
        } else {
            done_button.text = "OK (${SearchFragment.instance.tempSize} Nights)"
        }
        calendar_view.decorators = emptyList<CalendarCellDecorator>()
        //calendar_view.init(lastYear.time, nextYear.getTime()) //
        calendar_view.init(Date(), nextYear.time)
                .inMode(CalendarPickerView.SelectionMode.RANGE) //
                .withSelectedDates(SearchFragment.instance.dates)

        calendar_view.setOnDateSelectedListener(this)
        done_button.setOnClickListener {
            var selectedDates = calendar_view.selectedDates
            try {
                var tempSize: Int = selectedDates.size - 1
                SearchFragment.instance.tempSize = tempSize
                SearchFragment.instance.monthStartedHotel = DateFormat.format("MMM", selectedDates[0]).toString()
                SearchFragment.instance.dayStartedHotel = DateFormat.format("dd", selectedDates[0]).toString()
                SearchFragment.instance.dayOfTheWeekStartedHotel = DateFormat.format("EEEE", selectedDates[0]).toString()
                SearchFragment.instance.monthEndHotel = DateFormat.format("MMM", selectedDates[tempSize!!]).toString()
                SearchFragment.instance.dayEndHotel = DateFormat.format("dd", selectedDates[tempSize!!]).toString()
                SearchFragment.instance.dayOfTheWeekEndHotel = DateFormat.format("EEEE", selectedDates[tempSize!!]).toString()
                SearchFragment.instance.dates.clear()
                SearchFragment.instance.dates.add(0, selectedDates[0])
                SearchFragment.instance.dates.add(1, selectedDates[tempSize!!])
                activity.onBackPressed()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }*/
    }


}