package com.hellking.higher.data

class Quotes {
    companion object {
        private val BongQuotes = mutableListOf<String>(
            "Keep Calm and Hit a Bong",
            "The Big Bong Theory",
            "If We All had a Bong, We'd all get Along",


        )
        private val ChillumQuotes = mutableListOf<String>(
            "Don't panic, it's organic",
            "Rise and Shine, it's Chillum time",
            "Take a Hit, Share that Shit"
        )
        private val JointQuotes = mutableListOf<String>(
            "Puff Puff Pass",
            "Toke Till Ya Choke",
            "It's Joint-o-Clock"
        )

        fun quotely(mode: String): String {
            if (mode == "Bong")
                return BongQuotes.random().toString()
            else if (mode == "Chillum")
                return ChillumQuotes.random().toString()
            else
                return JointQuotes.random().toString()
        }
    }
}