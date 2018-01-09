package biz.gina.southernbreezetour;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;



/**
 * Created by quantran on 6/29/17.
 */

public class SBI_App extends Application {
    private static SBI_App mInstance;


    @Override public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public boolean isNetworkConnected() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return (networkInfo != null && networkInfo.isConnected());
    }

    public static SBI_App getInstance() {
        return mInstance;
    }
}
