package com.frede360.app.commons.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieDrawable
import com.frede360.app.R
import kotlinx.android.synthetic.main.fragment_loader.*

class Frede360LoaderFragment : Fragment() {

    var containerID: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_loader, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loaderAnimation.setAnimation("animations/loader.json")
        loaderAnimation.repeatCount = LottieDrawable.INFINITE
        loaderAnimation.repeatMode = LottieDrawable.RESTART
        loaderAnimation.playAnimation()

        //If loader container is full screen, disable click flags
        if (containerID == android.R.id.content) {
            activity!!.window.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        //If loader container is full screen, allow click flags
        if (containerID == android.R.id.content) {
            activity!!.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
    }
}