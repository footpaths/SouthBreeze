package biz.gina.southernbreezetour.ui.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import biz.gina.southernbreezetour.R
import biz.gina.southernbreezetour.ui.Fragment.*
import biz.gina.southernbreezetour.utils.MoveScreen
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
   private var moveScreen: MoveScreen? = null
    private var avatar: ImageView? = null
//    private var toolbar: Toolbar? = null

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.title = "Home"
        moveScreen = MoveScreen(this@MainActivity)
        moveScreen!!.firstMoveFragment(R.id.content, SearchFragment())
        val headerLayout = nav_view.getHeaderView(0)
        avatar= headerLayout.findViewById(R.id.avatar)
        avatar?.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()


        nav_view.setNavigationItemSelectedListener(this)



      }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.avatar ->{

            }
            R.id.nav_home -> {
//                moveScreen!!.clickedOn(R.id.content, HomeFragment())
//                toolbar.title = "Home"
            }
            R.id.nav_hotel -> {
                moveScreen!!.clickedOn(R.id.content, HotelFragment())
                toolbar.title = "Hotel"
            }
            R.id.nav_tour -> {
                moveScreen!!.clickedOn(R.id.content, TourFragment())
                toolbar.title = "Tour"
            }
            R.id.nav_golf -> {
                moveScreen!!.clickedOn(R.id.content, GolfFragment())
                toolbar.title = "Golf"
            }
            R.id.nav_spa -> {
                moveScreen!!.clickedOn(R.id.content, SpaFragment())
                toolbar.title = "Spa"
            }
            R.id.nav_setting -> {
                moveScreen!!.clickedOn(R.id.content, SettingFragment())
                toolbar.title = "Setting"
            }
            R.id.nav_logout -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
