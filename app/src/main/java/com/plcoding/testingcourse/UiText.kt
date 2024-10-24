package com.plcoding.testingcourse

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

sealed class UiText {
    data class DynamicString(val value: String) : UiText()
    data class StringResource(val id: Int, val args: List<Any>) : UiText()

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> context.getString(this.id, *this.args.toTypedArray())
        }
    }

    @Composable
    fun asString(): String {
        val context = LocalContext.current.applicationContext
        return when (this) {
            is DynamicString -> value
            is StringResource -> context.getString(this.id, *this.args.toTypedArray())
        }
    }
}