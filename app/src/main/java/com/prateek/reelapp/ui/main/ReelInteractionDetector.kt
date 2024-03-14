package com.prateek.reelapp.ui.main

import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

class ReelInteractionDetector(private val listener : ReelInteractionInterface) : View.OnTouchListener {

    private var y1 = 0f
    private var y2 = 0f

    companion object{
        private const val MIN_DISTANCE = 150
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if (event != null) {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    y1 = event.y
                    listener.onReelTouchDown()
                }
                MotionEvent.ACTION_UP -> {
                    y2 = event.y
                    val deltaY = y2 - y1

                    listener.onReelTouchUp()

                    if (abs(deltaY) > MIN_DISTANCE) {
                        if (y2 > y1) {
                            listener.onPreviousReel()
                        } else {
                            listener.onNextReel()
                        }
                    }
                }
            }
        }
        return true
    }

}