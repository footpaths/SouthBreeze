package biz.gina.southernbreezetour.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import biz.gina.southernbreezetour.R
import biz.gina.southernbreezetour.utils.MoveScreen
import kotlinx.android.synthetic.main.fragment_tour_detail.*

/**
 * Created by PC on 12/19/2017.
 */
class TourDetailsFragment : Fragment(), View.OnClickListener {
    private var moveScreen: MoveScreen? = null
    override fun onClick(p0: View?) {
        moveScreen!!.clickedOn(R.id.content, FragmentBookDetailsTour())
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        var view = inflater?.inflate(R.layout.fragment_tour_detail, container,false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moveScreen = MoveScreen(activity)
        btnBookNow.setOnClickListener(this)

    }
}