package dev.mmoreno.snoozelo.ui.extensions

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import androidx.annotation.AnimatorRes
import androidx.core.animation.doOnEnd

fun Context.loadAndStartObjectAnimator(
    @AnimatorRes animationRes: Int,
    view: View,
    onEnd: () -> Unit = {}
) {
    (AnimatorInflater.loadAnimator(this, animationRes) as ObjectAnimator).apply {
        target = view
        start()
        doOnEnd { onEnd() }
    }
}