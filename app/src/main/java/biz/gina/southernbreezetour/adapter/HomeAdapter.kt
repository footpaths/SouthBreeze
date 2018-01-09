package biz.gina.southernbreezetour.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import biz.gina.southernbreezetour.R
import kotlinx.android.synthetic.main.cell_home.view.*

/**
 * Created by PC on 12/12/2017.
 */
class HomeAdapter(var context: Context, var list: List<String>): RecyclerView.Adapter<HomeAdapter.MyHolder>() {
    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        val myHolder = holder as MyHolder
        myHolder.homeMinorAdapter = HomeMinorAdapter(context, list)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        myHolder.rv_home_minor.adapter = myHolder.homeMinorAdapter
        myHolder.rv_home_minor.layoutManager = linearLayoutManager
        myHolder.tvTitle.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(context)

        return MyHolder(inflater.inflate(R.layout.cell_home, parent, false))
    }


    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
         var list: MutableList<String> = ArrayList()
         var homeMinorAdapter: HomeMinorAdapter? = null
        var tvTitle:TextView =itemView.findViewById(R.id.tvTitle)
        var rv_home_minor: RecyclerView = itemView.findViewById(R.id.rv_home_minor)
        override fun onClick(p0: View?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
            init {

            }
    }
}