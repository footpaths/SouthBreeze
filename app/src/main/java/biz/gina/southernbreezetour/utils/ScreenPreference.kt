package biz.gina.southernbreezetour.utils

/**
 * Created by PC on 1/17/2018.
 */
import java.util.Date

import android.content.Context
import android.content.SharedPreferences

class ScreenPreference (private val context: Context) {

    private val sharedName = "screenmanager_play"

    private val sharedName1 = "screenmanager_play1"

    private val mPref: SharedPreferences

    private val sharedPreferences: SharedPreferences

    fun getmPref(): SharedPreferences {
        return mPref
    }

    var numberRetry: Int
        get() = sharedPreferences.getInt("number_retry", 3)
        set(value) {
            sharedPreferences.edit().putInt("number_retry", value).apply()
        }

    var shopListID: String
        get() = sharedPreferences.getString("shop_id", "")
        set(value) {
            sharedPreferences.edit().putString("shop_id", value).apply()
        }



    init {
        mPref = context.getSharedPreferences(sharedName, Context.MODE_PRIVATE)
        sharedPreferences = context.getSharedPreferences(sharedName1,
                Context.MODE_PRIVATE)
    }

    companion object {

        lateinit var instance:ScreenPreference

        fun getInstance(context: Context): ScreenPreference {
            instance= ScreenPreference(context)
            return instance

        }
    }


}