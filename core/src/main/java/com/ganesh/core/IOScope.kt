package com.ganesh.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class IOScope: Scope {
    override val uiDispatcher: CoroutineDispatcher
        get() = Dispatchers.Main
    override val bgDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO
}