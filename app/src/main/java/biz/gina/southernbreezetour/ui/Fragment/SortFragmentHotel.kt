package biz.gina.southernbreezetour.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import biz.gina.southernbreezetour.R
import kotlinx.android.synthetic.main.fragment_sort_hotel.*
import org.jetbrains.anko.toast
import java.util.ArrayList
import android.view.Gravity
import android.R.attr.gravity
import android.app.ActionBar
import android.graphics.Color
import android.view.ViewGroup.LayoutParams.FILL_PARENT
import android.graphics.Color.LTGRAY
import android.widget.*
import com.github.guilhe.rangeseekbar.SeekBarRangedView


/**
 * Created by PC on 12/18/2017.
 */
class SortFragmentHotel : Fragment(), AdapterView.OnItemSelectedListener, SeekBarRangedView.OnSeekBarRangedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    var isPressed1 = false
    var isPressed2 = false
    var isPressed3 = false
    var isPressed4 = false
    var isPressed5 = false
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnStar1 -> {
                if (isPressed1)
                    btnStar1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_star_border, 0)
                else
                    btnStar1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_star, 0)
                isPressed1 = !isPressed1
            }
            R.id.btnStar2 -> {
                if (isPressed2)
                    btnStar2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_star_border, 0)
                else
                    btnStar2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_star, 0)
                isPressed2 = !isPressed2
            }
            R.id.btnStar3 -> {
                if(isPressed3)
                    btnStar3.setCompoundDrawablesWithIntrinsicBounds( 0,0, R.drawable.ic_star_border, 0)
                else
                    btnStar3.setCompoundDrawablesWithIntrinsicBounds( 0,0, R.drawable.ic_star, 0)

                isPressed3 = !isPressed3
            }
            R.id.btnStar4 -> {
                if(isPressed4)
                    btnStar4.setCompoundDrawablesWithIntrinsicBounds( 0,0, R.drawable.ic_star_border, 0)
                else
                    btnStar4.setCompoundDrawablesWithIntrinsicBounds( 0,0, R.drawable.ic_star, 0)

                isPressed4 = !isPressed4
            }
            R.id.btnStar5 -> {
                if(isPressed5)
                    btnStar5.setCompoundDrawablesWithIntrinsicBounds( 0,0, R.drawable.ic_star_border, 0)
                else
                    btnStar5.setCompoundDrawablesWithIntrinsicBounds( 0,0, R.drawable.ic_star, 0)

                isPressed5 = !isPressed5
            }
        }
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        if (p1 == 0) {
            txtInfoRating.text = "GUEST RATING: ALL"
        } else {
            txtInfoRating.text = "GUEST RATING: " + p1.toFloat().toString() + " OR HIGHER"
        }

    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }

    override fun onChanged(view: SeekBarRangedView?, minValue: Double, maxValue: Double) {

    }

    override fun onChanging(view: SeekBarRangedView?, minValue: Double, maxValue: Double) {
        textMin3.text = "$" + minValue.toInt().toString()
        textMax3.text = "$" + maxValue.toInt().toString() + "+"
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {


    }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        val item = parent?.getItemAtPosition(position).toString()
        Toast.makeText(parent?.context, "Selected: " + item, Toast.LENGTH_LONG).show()
    }

    // var calendar: CalendarPickerView? = null
    var categories: MutableList<String>? = ArrayList()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(
                R.layout.fragment_sort_hotel, container, false)
        return view


    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtInfoRating.text = "GUEST RATING: " + 5.toFloat().toString() + " OR HIGHER"
        categories?.add("RATING (ASCENDING)")
        categories?.add("RATING (DECREASE)")
        categories?.add("PRICE (ASCENDING)")
        categories?.add("PRICE (DECREASE)")

        val sprache_ratoromanisch_adapter = object : ArrayAdapter<CharSequence>(
                context,
                R.layout.item_spinner,
                categories as List<CharSequence>?) {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val v = super.getView(position, convertView, parent)
                return v
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View? {
                val v = super.getDropDownView(position, convertView, parent)
                (v as TextView).gravity = Gravity.CENTER

                return v
            }

        }
        spinnerSort?.adapter = sprache_ratoromanisch_adapter


        spinnerSort?.onItemSelectedListener = this
        rangeSeekbar3.setOnSeekBarRangedChangeListener(this)
        sbGuestRating.setOnSeekBarChangeListener(this)
        btnStar1.setOnClickListener(this)
        btnStar2.setOnClickListener(this)
        btnStar3.setOnClickListener(this)
        btnStar4.setOnClickListener(this)
        btnStar5.setOnClickListener(this)

    }


}