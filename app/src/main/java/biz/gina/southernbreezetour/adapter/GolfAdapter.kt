package biz.gina.southernbreezetour.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import biz.gina.southernbreezetour.R

/**
 * Created by PC on 12/12/2017.
 */
class GolfAdapter(var context: Context, var list: List<String>): RecyclerView.Adapter<GolfAdapter.MyHolder>() {
    override fun onBindViewHolder(holder: MyHolder?, position: Int) {

    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(context)
        return MyHolder(inflater.inflate(R.layout.cell_golf, parent, false))
    }


    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {

        }
    }
}