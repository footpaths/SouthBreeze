package biz.gina.southernbreezetour.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import biz.gina.southernbreezetour.R
import biz.gina.southernbreezetour.utils.MoveScreen

import kotlinx.android.synthetic.main.fragment_search_home.*
import java.util.*

/**
 * Created by PC on 1/10/2018.
 */
class SearchFragment : Fragment() {
    var dayOfTheWeekEndHotel: String? = null
    var dayOfTheWeekStartedHotel: String? = null
    var dayOfWeekTour: String? = null
    var dayTour: String? = null
    var monthTour: String? = null
    var dayStartedHotel: String? = null
    var monthStartedHotel: String? = null
    var dayEndHotel: String? = null
    var monthEndHotel: String? = null
    var tempSize = 0

    var dates = ArrayList<Date>()
    var datesTour :Date?=null

    private var moveScreen: MoveScreen? = null
    var checkTab: Int?=1
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.fragment_search_home, container, false)
        /**
         * instance khoi tao chinh no
         */
        instance = this
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        moveScreen = MoveScreen(activity)
        if (checkTab == 1){
            btnHotel.setBackgroundResource(R.color.color_orange)
            lnHotel.visibility = View.VISIBLE
            lnBtnSearchHotel.visibility = View.VISIBLE
            lnTour.visibility = View.GONE
            lnBtnSearchTour.visibility = View.GONE
            lnHotel.animate().alpha(1.0f).duration = 500
            lnTour.animate().alpha(0.0f).duration = 500
            lnBtnSearchTour.animate().alpha(0.0f).duration = 500
            btnSearchHotel.animate().alpha(1.0f).duration = 500

            if (dayOfTheWeekEndHotel.equals(null) && dayOfTheWeekStartedHotel.equals(null)) {

                val today = Calendar.getInstance()

                today.add(Calendar.DATE, 0)
                dates.add(today.time)
                try {
                    dayStartedHotel = DateFormat.format("dd", today) as String // 20
                    monthStartedHotel = DateFormat.format("MMM", today) as String // Jun
                    dayOfTheWeekStartedHotel = DateFormat.format("EEEE", today) as String
                    dateChooseLeft.text = "$monthStartedHotel $dayStartedHotel"

                    txtDayOfWeekStarted!!.text = dayOfTheWeekStartedHotel

                    today.add(Calendar.DATE, 1)
                    dates.add(today.time)
                    var date = dates[1]

                    dayEndHotel = DateFormat.format("dd", date) as String // 20
                    monthEndHotel = DateFormat.format("MMM", date) as String // Jun
                    dayOfTheWeekEndHotel = DateFormat.format("EEEE", date) as String
                    dateChooseRight.text = "$monthEndHotel $dayEndHotel"
                    txtDayOfWeekEnd!!.text = dayOfTheWeekEndHotel


                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                txtDayOfWeekStarted!!.text = dayOfTheWeekStartedHotel
                txtDayOfWeekEnd!!.text = dayOfTheWeekEndHotel
                dateChooseLeft!!.text = "$monthStartedHotel $dayStartedHotel"
                dateChooseRight!!.text = "$monthEndHotel $dayEndHotel"
            }

        }else{
            btnTour.setBackgroundResource(R.color.color_orange)
            lnHotel.visibility = View.GONE
            lnBtnSearchHotel.visibility = View.GONE
            lnTour.visibility = View.VISIBLE
            lnBtnSearchTour.visibility = View.VISIBLE


        }


        if (dayOfWeekTour.equals(null)|| dayTour.equals(null) || monthTour.equals(null)){
            val today = Calendar.getInstance()

            today.add(Calendar.DATE, 0)
            dayTour = DateFormat.format("dd", today) as String // 20
            monthTour = DateFormat.format("MMM", today) as String // Jun
            dayOfWeekTour = DateFormat.format("EEEE", today) as String
            txtDayOfWeekTour.text = dayOfWeekTour
            txtDayMonthTour.text = monthTour + " "+ dayTour
        }else{
            txtDayOfWeekTour.text = dayOfWeekTour
            txtDayMonthTour.text = monthTour + " "+ dayTour
        }

        btnTour.setOnClickListener {
            checkTab =2
            btnTour.setBackgroundResource(R.color.color_orange)
            btnHotel.setBackgroundResource(R.color.color_main)
            lnHotel.visibility = View.GONE
            lnBtnSearchHotel.visibility = View.GONE

            lnHotel.animate().alpha(0.0f).duration = 500
            btnSearchHotel.animate().alpha(0.0f).duration = 500
            lnTour.animate().alpha(1.0f).duration = 500
            lnBtnSearchTour.animate().alpha(1.0f).duration = 500

            lnTour.visibility = View.VISIBLE
            lnBtnSearchTour.visibility = View.VISIBLE
        }

        btnHotel.setOnClickListener {
            checkTab=1
            btnHotel.setBackgroundResource(R.color.color_orange)
            btnTour.setBackgroundResource(R.color.color_main)
            lnHotel.visibility = View.VISIBLE
            lnBtnSearchHotel.visibility = View.VISIBLE
            lnTour.visibility = View.GONE
            lnBtnSearchTour.visibility = View.GONE
            lnHotel.animate().alpha(1.0f).duration = 500
            lnTour.animate().alpha(0.0f).duration = 500
            lnBtnSearchTour.animate().alpha(0.0f).duration = 500
            btnSearchHotel.animate().alpha(1.0f).duration = 500
        }
        lnSetDate.setOnClickListener {
            val fragment = CalendarSearchFragmentHotel()
            moveScreen!!.clickedOn(R.id.content, fragment)
            fragment.setTargetFragment(this, 0)

        }

        lnsetDateTour.setOnClickListener {
            moveScreen!!.clickedOn(R.id.content, CalendarSearchFragmentTour())
        }
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * lay du lieu qua lai
     */
    companion object {
        lateinit var instance: SearchFragment
            private set
    }
}