package io.indrian.covid19.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import io.indrian.covid19.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    private val menuStateObserver = Observer<MenuState> { menuState ->

        when(menuState) {

            is MenuState.Home -> {

                fragment_container_view.findNavController().navigate(R.id.homeFragment)
            }
            is MenuState.Developer -> {

                fragment_container_view.findNavController().navigate(R.id.developerFragment)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initViewModel()
    }

    private fun initView() {

        bar.setOnMenuItemClickListener(::setOnMenuItemClickListener)
    }

    private fun initViewModel() {

        viewModel.menuState.observe(this, menuStateObserver)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setOnMenuItemClickListener(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.action_home -> viewModel.changeMenu(MenuState.Home)

            R.id.action_about -> viewModel.changeMenu(MenuState.Developer)
        }

        return true
    }

    override fun onDestroy() {

        viewModel.menuState.removeObserver(menuStateObserver)
        super.onDestroy()
    }
}
