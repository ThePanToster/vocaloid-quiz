package com.thepantoster.mikuquiz

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation


class Game : Fragment() {

    private var view: View? = null
    private var songs: Database? = null
    private var player: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.layout_game, container, false)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(
            true
        ) {
            override fun handleOnBackPressed() {
                view?.let { Navigation.findNavController(it).navigate(R.id.navigateToMenu) }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        player?.stop()
    }

    override fun onStart() {
        super.onStart()
        songs = Database(requireContext())
        val song = songs!!.getRandomSong()

        player = MediaPlayer.create(context, Utils.getResourceId(requireContext(), song?.getRawName()!!))
        player?.start()
    }
}
