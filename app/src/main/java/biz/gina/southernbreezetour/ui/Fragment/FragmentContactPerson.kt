package biz.gina.southernbreezetour.ui.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import biz.gina.southernbreezetour.R
import biz.gina.southernbreezetour.utils.MoveScreen
import kotlinx.android.synthetic.main.fragment_contact_person.*

/**
 * Created by PC on 12/18/2017.
 */
class FragmentContactPerson : Fragment(), View.OnClickListener {
    override fun onClick(p0: View?) {
        moveScreen!!.clickedOn(R.id.content, FragmentPersonInfo())
    }

    // var calendar: CalendarPickerView? = null
   private var moveScreen: MoveScreen? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(
                R.layout.fragment_contact_person, container, false)
        return view


    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moveScreen = MoveScreen(activity)
        btnContinues.setOnClickListener(this)
    }


}