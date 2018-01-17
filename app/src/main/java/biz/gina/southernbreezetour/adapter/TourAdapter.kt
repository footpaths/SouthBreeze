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
class TourAdapter(var context: Context, var list: List<String>): RecyclerView.Adapter<TourAdapter.MyHolder>() {
    override fun onBindViewHolder(holder: MyHolder?, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(context)
        return MyHolder(inflater.inflate(R.layout.cell_tour, parent, false))
    }


    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        override fun onClick(p0: View?) {
           clickListener?.OnItemClick(adapterPosition, p0!!)
        }

        init {
            itemView.setOnClickListener(this)
        }
    }
    fun setOnItemClickListener(clickListener: TourAdapter.ClickListener) {
        TourAdapter.clickListener = clickListener
    }
    interface ClickListener{
        fun OnItemClick(position : Int, v: View)
    }
    companion object {
        var clickListener:ClickListener? = null
    }
}