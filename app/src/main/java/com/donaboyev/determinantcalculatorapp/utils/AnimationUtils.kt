package com.donaboyev.determinantcalculatorapp.utils

import android.view.View
import android.view.View.OnLayoutChangeListener
import android.view.ViewAnimationUtils
import android.view.animation.DecelerateInterpolator
import com.donaboyev.determinantcalculatorapp.data.Center

fun View.startCircularReveal(center: Center, endRadius: Float) {
    addOnLayoutChangeListener(object : OnLayoutChangeListener {
        override fun onLayoutChange(
            v: View, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int,
            oldRight: Int, oldBottom: Int
        ) {
            v.removeOnLayoutChangeListener(this)
            ViewAnimationUtils.createCircularReveal(v, center.posX!!, center.posY!!, 0f, endRadius)
                .apply {
                    interpolator = DecelerateInterpolator(2f)
                    duration = 2000
                    start()
                }
        }
    })
}

fun View.findLocationOfCenterOnTheScreen(): Center {
    val centerX = x + width / 2
    val centerY = y + height / 2
    return Center(centerX.toInt(), centerY.toInt())
}