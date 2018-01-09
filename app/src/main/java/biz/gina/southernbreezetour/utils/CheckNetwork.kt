package biz.gina.southernbreezetour.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast

/**
 * Created by PC on 12/25/2017.
 */
class CheckNetwork {
    //			********************************************************************************************
    //	 										IF NETWORK IS ACTIVE OR NOT
    //			********************************************************************************************
    fun isNetworkAvailable(context: Context): Boolean {
        var networkavailable = false


        try {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo as NetworkInfo

            if (connectivityManager != null && activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting) {
                networkavailable = true
            } else {
                networkavailable = false
                Toast.makeText(context as Activity, "Connection Failed", Toast.LENGTH_LONG).show()

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return networkavailable
    }

}