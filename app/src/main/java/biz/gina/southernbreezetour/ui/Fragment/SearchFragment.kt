package biz.gina.southernbreezetour.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import biz.gina.southernbreezetour.R
import kotlinx.android.synthetic.main.fragment_search_home.*

/**
 * Created by PC on 1/10/2018.
 */
class SearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view= inflater?.inflate(R.layout.fragment_search_home, container,false)

        return view
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        btnHotel.setBackgroundResource(R.color.color_orange)
        btnTour.setOnClickListener {
             btnTour.setBackgroundResource(R.color.color_orange)
            btnHotel.setBackgroundResource(R.color.color_main)
        }

        btnHotel.setOnClickListener {
             btnHotel.setBackgroundResource(R.color.color_orange)
            btnTour.setBackgroundResource(R.color.color_main)
        }

        super.onViewCreated(view, savedInstanceState)
    }
}