package biz.gina.southernbreezetour.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import biz.gina.southernbreezetour.R
import biz.gina.southernbreezetour.adapter.TourAdapter
import biz.gina.southernbreezetour.utils.MoveScreen
import java.util.*


/**
 * Created by PC on 12/8/2017.
 */
class TourFragment: Fragment(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(p0: AdapterView<*>?) {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        val item = parent?.getItemAtPosition(position).toString()
        Toast.makeText(parent?.context, "Selected: " + item, Toast.LENGTH_LONG).show()


    }

    var list: MutableList<String> = ArrayList()
    var tourAdapter: TourAdapter? = null
    var rvTour: RecyclerView? = null
    var spinner : Spinner? = null
    var btncheckPicker : Button? =null
    var categories : MutableList<String>? = ArrayList()
    private var date: String? = null
    private var ngay: Int = 0
    private var thang:Int = 0
    private var nam:Int = 0

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            var view= inflater?.inflate(R.layout.fragment_tour, container,false)
        rvTour = view!!.findViewById(R.id.rvTour)
        spinner = view!!.findViewById(R.id.spinner)
        btncheckPicker = view!!.findViewById(R.id.btncheckPicker)

        categories?.add("Lao")
        categories?.add("Campuchia")
        categories?.add("Campuchia")
        categories?.add("Campuchia")
        categories?.add("Campuchia")
        categories?.add("Campuchia")
        categories?.add("Campuchia")
        categories?.add("Campuchia")


        val dataAdapter = ArrayAdapter<String>(activity, R.layout.item_spinner, categories)

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.item_spinner_dropdown)

        spinner?.setPrompt("Chọn quốc gia")

        // attaching data adapter to spinner
        spinner?.adapter = dataAdapter

        spinner?.onItemSelectedListener = this

        btncheckPicker?.setOnClickListener {
        }

        tourAdapter = TourAdapter(context, list)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvTour?.adapter = tourAdapter
        rvTour?.layoutManager = linearLayoutManager
        tourAdapter!!.setOnItemClickListener(object : TourAdapter.ClickListener {
            override fun OnItemClick(position: Int, v: View) {
                var moveScreen= MoveScreen(activity)
                moveScreen.clickedOn(R.id.content, DetailTourFragment())
            }
        })
        return view
    }

    /**
     * Lay ngay hien tai cua he thong
     */

}