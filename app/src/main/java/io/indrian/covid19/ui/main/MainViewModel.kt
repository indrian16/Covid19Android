package io.indrian.covid19.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _menuState = MutableLiveData<MenuState>()
    val menuState: LiveData<MenuState>
        get() = _menuState

    init {

        _menuState.value = MenuState.Home
    }

    fun changeMenu(state: MenuState) {

        if (state != _menuState.value) {

            _menuState.value = state
        }
    }
}