package com.thepantoster.mikuquiz

import java.net.URL
import java.util.Date

data class Song(val number: String, val name: String, val difficulty: String, val voices: Array<String>, val producer: String, val published: Date, val link: URL) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Song

        return voices.contentEquals(other.voices)
    }

    override fun hashCode(): Int {
        return voices.contentHashCode()
    }
}
