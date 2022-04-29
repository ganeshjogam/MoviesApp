package com.ganesh.moviesapp.core

import kotlinx.coroutines.Dispatchers

class AppIOScope() : Scope {
    override val bgDispatcher = Dispatchers.IO
    override val uiDispatcher = Dispatchers.Main
}