package biz.gina.southernbreezetour.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import biz.gina.southernbreezetour.R
import biz.gina.southernbreezetour.adapter.HomeAdapter
import java.util.*

/**
 * Created by PC on 12/12/2017.
 */
class HomeFragment : Fragment() {
       private lateinit var rvhome: RecyclerView
    private var list: MutableList<String> = ArrayList()
    private var homeAdapter: HomeAdapter? = null
    @SuppressLint("ResourceType")
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view= inflater?.inflate(R.layout.fragment_home, container,false)
        rvhome = view!!.findViewById(R.id.rvHome)
        homeAdapter = HomeAdapter(activity, list)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvhome.adapter = homeAdapter
        rvhome.layoutManager = linearLayoutManager
        val ward_array = activity.resources.getStringArray(R.array.title)
        val arrayWard :List<String> = ward_array.toList()
        for (i in 0 until arrayWard.size){
            list.add(arrayWard[i])
        }
        return view
    }
}