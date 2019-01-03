package com.omni.bottomnavigationviewtutorial

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region set up navigation view
        navController = this.findNavController(R.id.my_nav_host_fragment)
        setUpActionbarNavigation()
        //setupBottomNavMenu
        bottom_nav_view.let {
            NavigationUI.setupWithNavController(it, navController)
        }
//        NavigationUI.setupWithNavController(bottom_nav_view , navController)

        //endregion

        navController.addOnNavigatedListener { _, destination ->
            val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                Integer.toString(destination.id)
            }

            Log.d("NavigationActivity", "Navigated to $dest")
        }


    }



    private fun setUpActionbarNavigation() {
//        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

}
