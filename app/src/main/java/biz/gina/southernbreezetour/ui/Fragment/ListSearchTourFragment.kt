package biz.gina.southernbreezetour.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import biz.gina.southernbreezetour.R
import biz.gina.southernbreezetour.utils.MoveScreen
import kotlinx.android.synthetic.main.fragment_list_search_tour.*

/**
 * Created by PC on 12/18/2017.
 */
class ListSearchTourFragment : Fragment(), View.OnClickListener {

    private var moveScreen: MoveScreen? = null
    // var calendar: CalendarPickerView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(
                R.layout.fragment_list_search_tour, container, false)
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