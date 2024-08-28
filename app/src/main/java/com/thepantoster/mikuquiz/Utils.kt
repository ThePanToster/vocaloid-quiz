package com.thepantoster.mikuquiz

import android.annotation.SuppressLint
import android.content.Context

class Utils {
    companion object {
        @SuppressLint("DiscouragedApi")
        fun getResourceId(context: Context, name: String, type: String? = "raw"): Int {
            return context.resources.getIdentifier(name, type, context.packageName)
        }
    }
}