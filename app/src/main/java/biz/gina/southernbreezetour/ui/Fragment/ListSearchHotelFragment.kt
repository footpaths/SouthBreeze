package biz.gina.southernbreezetour.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import biz.gina.southernbreezetour.R
import biz.gina.southernbreezetour.adapter.HotelAdapter
import biz.gina.southernbreezetour.adapter.TourAdapter
import biz.gina.southernbreezetour.utils.MoveScreen
import kotlinx.android.synthetic.main.fragment_list_search_hotel.*

/**
 * Created by PC on 12/18/2017.
 */
class ListSearchHotelFragment : Fragment(),View.OnClickListener {

    private var moveScreen: MoveScreen? = null
    var list: MutableList<String> = ArrayList()
    var hotelAdapter: HotelAdapter? = null
    var rvHotel: RecyclerView? = null
    // var calendar: CalendarPickerView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(
                R.layout.fragment_list_search_hotel, container, false)
        rvHotel = view!!.findViewById(R.id.rvHotel)
        hotelAdapter = HotelAdapter(context, list)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvHotel?.adapter = hotelAdapter
        rvHotel?.layoutManager = linearLayoutManager
        hotelAdapter!!.setOnItemClickListener(object : HotelAdapter.ClickListener {
            override fun OnItemClick(position: Int, v: View) {
                moveScreen!!.clickedOn(R.id.content, HotelDetailsFragment())
            }
        })
        return view


    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnDetails.setOnClickListener(this)
        moveScreen = MoveScreen(activity)
    }


    override fun onClick(p0: View?) {
        moveScreen!!.clickedOn(R.id.content, HotelDetailsFragment())
    }


}