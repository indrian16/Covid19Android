package io.indrian.covid19.ui.main

sealed class MenuState {

    object Home : MenuState()
    object Developer : MenuState()
}