package com.thepantoster.mikuquiz

import android.content.Context
import android.content.res.AssetManager
import com.google.gson.Gson

class Database(context: Context) {

    private var songs: Array<Song>? = null

    init {
        val assetMgr: AssetManager = context.assets
        val jsonString = assetMgr.open("songs.json").toString()
        songs = Gson().fromJson(jsonString, Array<Song>::class.java)
    }

    fun getRandomSong(): Song? {
        return songs?.random()
    }
}