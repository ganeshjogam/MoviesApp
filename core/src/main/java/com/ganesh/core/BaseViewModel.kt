package com.ganesh.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

open class BaseViewModel<UI : BaseData>(private val scope: Scope, val data: UI) : ViewModel(),
    CoroutineScope {
    private val job by lazy { SupervisorJob() }
    override val coroutineContext: CoroutineContext
        get() = scope.uiDispatcher + job

    fun <UI : BaseData> BaseViewModel<UI>.execute(block: suspend CoroutineScope.() -> Unit): Job =
        launch {
            block(this)
        }
}