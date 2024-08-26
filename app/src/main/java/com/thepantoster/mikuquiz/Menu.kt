package com.thepantoster.mikuquiz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import kotlin.system.exitProcess


class Menu : Fragment() {

    private var imgMiku: ImageView? = null
    private var txtTitle: TextView? = null
    private var txtStart: TextView? = null

    private var moveToFrameLeft: Animation? = null
    private var moveOutFrameLeft: Animation? = null
    private var moveToFrameRight: Animation? = null
    private var moveOutFrameRight: Animation? = null
    private var pulse: Animation? = null

    private fun initializeProperties( view: View ){
        moveToFrameLeft = AnimationUtils.loadAnimation(view.context, R.anim.to_frame_left)
        moveOutFrameLeft = AnimationUtils.loadAnimation(view.context, R.anim.out_frame_left)
        moveToFrameRight = AnimationUtils.loadAnimation(view.context, R.anim.to_frame_right)
        moveOutFrameRight = AnimationUtils.loadAnimation(view.context, R.anim.out_frame_right)
        pulse = AnimationUtils.loadAnimation(view.context, R.anim.pulse)

        imgMiku = view.findViewById(R.id.imgMiku)
        txtTitle = view.findViewById(R.id.txtTitle)
        txtStart = view.findViewById(R.id.txtStart)
    }

    private fun runStartingAnimations (){
        imgMiku?.startAnimation(moveToFrameLeft)
        txtTitle?.startAnimation(moveToFrameRight)
        txtStart?.startAnimation(pulse)
    }

    private fun runEndingAnimations (){
        imgMiku?.startAnimation(moveOutFrameLeft)
        txtTitle?.startAnimation(moveOutFrameRight)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_menu, container, false)
        initializeProperties(view)

        view.findViewById<ImageView>(R.id.imgMiku).setOnClickListener {
            runEndingAnimations()
            Navigation.findNavController(view).navigate(R.id.navigateToGame)
        }
        runStartingAnimations()

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(
            true
        ) {
            override fun handleOnBackPressed() {
                exitProcess(0)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }
}
