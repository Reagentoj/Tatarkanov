package com.example.tatarkanovkantemir.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tatarkanovkantemir.R
import com.example.tatarkanovkantemir.databinding.ActivityMainBinding
import com.example.tatarkanovkantemir.utils.Const
import com.example.tatarkanovkantemir.utils.InternetConnection
import com.example.tatarkanovkantemir.utils.mainActivityContext


class MainActivity : AppCompatActivity() {

    private var viewBinding: ActivityMainBinding? = null
    private val binding get() = viewBinding!!
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (InternetConnection.checkConnection(this)){
            viewBinding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            title = getString(R.string.popular)
            mainActivityContext = this
            navController = Navigation.findNavController(this, R.id.nav_host)

        } else {
            setContentView(R.layout.no_internet)
            Toast.makeText(this, Const.CHECK_INTERNET_CONNECTION, Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }

}