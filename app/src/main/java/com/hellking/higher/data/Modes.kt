package com.hellking.higher.data

import android.util.Log

class Modes {
    companion object {
        private var modes = mutableListOf("Bong", "Chillum", "Joint")
        private var modesHelper = mutableListOf<String>()

        fun newHigh(): String {
            if (modes.isEmpty()) {
                if (modesHelper.isNotEmpty()) {
                    modes = modesHelper
                    modesHelper = mutableListOf()
                } else {
                    Log.e("--MODE ERROR--", "Empty List")
                    return ""
                }
            }

            val newMode = modes.random().toString()
            modes.remove(newMode)
            modesHelper.add(newMode)
            return newMode
        }
    }
}