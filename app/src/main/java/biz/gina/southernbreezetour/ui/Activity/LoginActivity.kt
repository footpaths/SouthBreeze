package biz.gina.southernbreezetour.ui.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import biz.gina.southernbreezetour.R
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.login.*
import org.json.JSONException
import java.util.*
import android.app.Activity
import android.os.AsyncTask
import android.view.inputmethod.InputMethodManager
import com.google.android.gms.auth.GoogleAuthException
import com.google.android.gms.auth.GoogleAuthUtil
import com.google.android.gms.auth.UserRecoverableAuthException
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInApi
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.ResultCallback
import java.io.IOException


/**
 * Created by PC on 12/13/2017.
 */
class LoginActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {


    var callbackManager: CallbackManager? = null
    var email: String? = null
    var name:String? = null
    var first_name:String? = null
    var last_name:String? = null

    private val RC_SIGN_IN = 7
    private var mGoogleApiClient: GoogleApiClient? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FacebookSdk.sdkInitialize(applicationContext)

        setContentView(R.layout.login)

        var gso =  GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleApiClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()


        callbackManager = CallbackManager.Factory.create()
        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        tvLogin.setOnClickListener {
            tvLogin.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
            tvSignup.setTextColor(ContextCompat.getColor(this, R.color.color_dark))
            signup_form.visibility = View.GONE
            login_form.visibility = View.VISIBLE
        }
        tvSignup.setOnClickListener {
            tvLogin.setTextColor(ContextCompat.getColor(this, R.color.color_dark))
            tvSignup.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
            signup_form.visibility = View.VISIBLE
            login_form.visibility = View.GONE
        }
        imgFacebook.setOnClickListener {
            onFblogin()
        }
        imgGoogle.setOnClickListener {
            val signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }



        var accessToken = AccessToken.getCurrentAccessToken()
        if( accessToken!=null) {
            val graphRequest = GraphRequest.newMeRequest(accessToken) { jsonObject, response ->
                Log.d("JSON", "" + response.jsonObject.toString())
                val data = response.jsonObject
                try {
                    email = data.getString("email")
                    name = data.getString("name")
                    first_name = data.optString("first_name")

                    if (data.has("picture")) {
                        val profilePicUrl = data.getJSONObject("picture").getJSONObject("data").getString("url")
                        last_name = data.optString("last_name")
                    }


                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }

            val parameters = Bundle()
            parameters.putString("fields", "id,name,first_name,last_name,email,picture")
            graphRequest.parameters = parameters
            graphRequest.executeAsync()
        }
    }
    override fun onConnectionFailed(p0: ConnectionResult) {
        Log.d("TAG", "onConnectionFailed:" + p0)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                hideSoftKeyboard(this@LoginActivity)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        callbackManager?.onActivityResult(requestCode, resultCode, data)
         if (requestCode == RC_SIGN_IN) {
            var result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
             Log.i("result", result.toString())
             if(result.isSuccess){
               Log.i("name",  result.signInAccount?.email)
             }
        }
    }


    private fun onFblogin() {
        callbackManager = CallbackManager.Factory.create()

        // Set permissions
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "user_photos", "public_profile"))

        LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(loginResult: LoginResult) {

                        val graphRequest = GraphRequest.newMeRequest(loginResult.accessToken) { jsonObject, response ->
                            Log.d("JSON", "" + response.jsonObject.toString())
                            val data = response.jsonObject
                            try {
                                email = data.getString("email")
                                name = data.getString("name")
                                first_name = data.optString("first_name")

                                if (data.has("picture")) {
                                    val profilePicUrl = data.getJSONObject("picture").getJSONObject("data").getString("url")
                                }
                                last_name = data.optString("last_name")
                                finish()
                                hideSoftKeyboard(this@LoginActivity)

                            } catch (e: JSONException) {
                                e.printStackTrace()
                            }
                        }

                        val parameters = Bundle()
                        parameters.putString("fields", "id,name,first_name,last_name,email,picture")
                        graphRequest.parameters = parameters
                        graphRequest.executeAsync()
                    }

                    override fun onCancel() {

                    }

                    override fun onError(exception: FacebookException) {

                    }
                })
    }

    override fun onStart() {
        mGoogleApiClient?.connect()
        super.onStart()
        var opr   = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient)
        if (opr.isDone) {
            Log.d("TAG", "Got cached sign-in")
            var result  = opr.get()
            if(result.isSuccess){
                Log.i("rename",  result.signInAccount?.email)
            }
        } else {
            opr.setResultCallback {

            }
        }

    }
    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager!!.hideSoftInputFromWindow(
                activity.currentFocus!!.windowToken, 0)
    }


}