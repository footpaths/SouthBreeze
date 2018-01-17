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
import kotlinx.android.synthetic.main.fragment_list_search_tour.*

/**
 * Created by PC on 12/18/2017.
 */
class ListSearchTourFragment : Fragment(), View.OnClickListener {
    var list: MutableList<String> = ArrayList()
    var tourAdapter: TourAdapter? = null
    var rvTour: RecyclerView? = null
    private var moveScreen: MoveScreen? = null
    // var calendar: CalendarPickerView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(
                R.layout.fragment_list_search_tour, container, false)
        rvTour = view!!.findViewById(R.id.rvTour)
        tourAdapter = TourAdapter(context, list)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvTour?.adapter = tourAdapter
        rvTour?.layoutManager = linearLayoutManager
        tourAdapter!!.setOnItemClickListener(object : TourAdapter.ClickListener {
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
        moveScreen!!.clickedOn(R.id.content, TourDetailsFragment())
    }


}