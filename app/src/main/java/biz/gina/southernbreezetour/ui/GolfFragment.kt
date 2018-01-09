package biz.gina.southernbreezetour.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import biz.gina.southernbreezetour.R
import biz.gina.southernbreezetour.adapter.GolfAdapter

/**
 * Created by PC on 12/8/2017.
 */
class GolfFragment : Fragment() {
    var list: MutableList<String> = ArrayList()
    var golfAdapter: GolfAdapter? = null
    var rvTour: RecyclerView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.fragment_golf, container, false)
        rvTour = view!!.findViewById(R.id.rvGolff)
        golfAdapter = GolfAdapter(context, list)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvTour?.adapter = golfAdapter
        rvTour?.layoutManager = linearLayoutManager
        return view

    }
}