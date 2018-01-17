package biz.gina.southernbreezetour.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import biz.gina.southernbreezetour.R
import kotlinx.android.synthetic.main.fragment_choose_person_search.*
import org.jetbrains.anko.toast

/**
 * Created by PC on 12/18/2017.
 */
class ChoosePersonSearchFragment : Fragment(), View.OnClickListener {
    var checkPossionClickMin: String? = null
    var checkPossionClickPlus: String? = null
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.minRoom -> {
                checkPossionClickMin = "0"
                minusRoomCount(checkPossionClickMin!!)

            }
            R.id.plusRoom -> {
                checkPossionClickPlus = "0"
                plusRoomCount(checkPossionClickPlus!!)

            }
            R.id.minAdult -> {
                checkPossionClickMin = "1"
                minusRoomCount(checkPossionClickMin!!)
            }
            R.id.plusAdult -> {
                checkPossionClickPlus = "1"
                plusRoomCount(checkPossionClickPlus!!)
            }
            R.id.minChild -> {
                checkPossionClickMin = "2"
                minusRoomCount(checkPossionClickMin!!)
            }
            R.id.plusChild -> {
                checkPossionClickPlus = "2"
                plusRoomCount(checkPossionClickPlus!!)
            }
            R.id.btnOk -> {

            }

        }
    }

    // var calendar: CalendarPickerView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(
                R.layout.fragment_choose_person_search, container, false)
        return view


    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        minRoom.setOnClickListener(this)
        plusRoom.setOnClickListener(this)
        minAdult.setOnClickListener(this)
        plusAdult.setOnClickListener(this)
        minChild.setOnClickListener(this)
        plusChild.setOnClickListener(this)
        btnOk.setOnClickListener(this)
    }

    private fun minusRoomCount(checkPossionClickMin: String) {
        /**
         * checkPossionClickMin
         * 0 = room
         * 1= adult
         * 2 =child
         */
        if (checkPossionClickMin.contains("0")) {
            var getNumberRoom = txtRoom.text.toString()
            var counterMin = getNumberRoom.toInt()

            if (counterMin > 0) {

                var temp = counterMin - 1

                txtRoom.text = temp.toString()
                if (temp == 0) {
                    minRoom.setColorFilter(context.resources.getColor(R.color.color_dark_white))
                }
            }
        }
        if (checkPossionClickMin.contains("1")) {
            var getNumberAdult = txtAdult.text.toString()
            var counterMin = getNumberAdult.toInt()

            if (counterMin > 0) {
                var temp = counterMin - 1

                txtAdult.text = temp.toString()
                if (temp == 0) {
                    minAdult.setColorFilter(context.resources.getColor(R.color.color_dark_white))
                }
            }

        }
        if (checkPossionClickMin.contains("2")) {
            var getNumberChild = txtChild.text.toString()
            var counterMin = getNumberChild.toInt()

            if (counterMin > 0) {
                var temp = counterMin - 1

                txtChild.text = temp.toString()
                if (temp == 0) {
                    minChild.setColorFilter(context.resources.getColor(R.color.color_dark_white))
                }
            }
        }


    }

    private fun plusRoomCount(checkPossionClickPlus: String) {
        if (checkPossionClickPlus.contains("0")) {
            var getNumberRoom = txtRoom.text.toString()
            var counterPlus = getNumberRoom.toInt()
            if (counterPlus >= 0) {
                minRoom.setColorFilter(context.resources.getColor(R.color.color_main))
                var temp = counterPlus + 1

                txtRoom.text = temp.toString()
            }
        }
        if (checkPossionClickPlus.contains("1")) {
            var getNumberAdult = txtAdult.text.toString()
            var counterPlus = getNumberAdult.toInt()
            if (counterPlus >= 0) {
                minAdult.setColorFilter(context.resources.getColor(R.color.color_main))
                var temp = counterPlus + 1

                txtAdult.text = temp.toString()
            }
        }
        if (checkPossionClickPlus.contains("2")) {
            var getNumberChild = txtChild.text.toString()
            var counterPlus = getNumberChild.toInt()
            if (counterPlus >= 0) {
                minChild.setColorFilter(context.resources.getColor(R.color.color_main))
                var temp = counterPlus + 1

                txtChild.text = temp.toString()
            }
        }


    }

}