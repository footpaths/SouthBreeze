package biz.gina.southernbreezetour.ui.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import biz.gina.southernbreezetour.R
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by PC on 12/13/2017.
 */
class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
         }
    }

}