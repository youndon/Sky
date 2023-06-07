package com.eslirodrigues.tutorials.di_hilt.data.api

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject

class DependencyApi @Inject constructor(
    private val context: Context
) {
    fun getString(): String {
        return context.getString(0)
    }
}