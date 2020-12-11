package com.donaboyev.determinantcalculatorapp.fragments

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.donaboyev.determinantcalculatorapp.R
import com.donaboyev.determinantcalculatorapp.utils.startCircularReveal
import kotlinx.android.synthetic.main.fragment_three_by_three.view.*
import kotlin.math.hypot

class ThreeByThreeFragment : Fragment() {
    private var a11: Double? = null
    private var a12: Double? = null
    private var a13: Double? = null
    private var a21: Double? = null
    private var a22: Double? = null
    private var a23: Double? = null
    private var a31: Double? = null
    private var a32: Double? = null
    private var a33: Double? = null

    private val args by navArgs<ThreeByThreeFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_three_by_three, container, false)

        view.btnCalculate.setOnClickListener {
            getInputs(view)
            val result =
                a11!! * a22!! * a33!! + a21!! * a32!! * a13!! + a12!! * a23!! * a31!! - (a31!! * a22!! * a13!! + a21!! * a12!! * a33!! + a32!! * a23!! * a11!!)
            view.tvResult.text = "$result"
        }

        view.btnReset.setOnClickListener {
            view.etA11.setText("")
            view.etA12.setText("")
            view.etA13.setText("")
            view.etA21.setText("")
            view.etA22.setText("")
            view.etA23.setText("")
            view.etA31.setText("")
            view.etA32.setText("")
            view.etA33.setText("")
            view.tvResult.text = ""
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val endRadius =
            hypot(
                view.right.toFloat(),
                (Resources.getSystem().displayMetrics.heightPixels - view.bottom).toFloat()
            )
        view.startCircularReveal(args.centerPosition, endRadius)
    }

    private fun getInputs(view: View) {
        a11 = if (view.etA11.text.isNotEmpty()) view.etA11.text.toString().trim()
            .toDouble() else 0.toDouble()
        a12 = if (view.etA12.text.isNotEmpty()) view.etA12.text.toString().trim()
            .toDouble() else 0.toDouble()
        a13 = if (view.etA13.text.isNotEmpty()) view.etA13.text.toString().trim()
            .toDouble() else 0.toDouble()
        a21 = if (view.etA21.text.isNotEmpty()) view.etA21.text.toString().trim()
            .toDouble() else 0.toDouble()
        a22 = if (view.etA22.text.isNotEmpty()) view.etA22.text.toString().trim()
            .toDouble() else 0.toDouble()
        a23 = if (view.etA23.text.isNotEmpty()) view.etA23.text.toString().trim()
            .toDouble() else 0.toDouble()
        a31 = if (view.etA31.text.isNotEmpty()) view.etA31.text.toString().trim()
            .toDouble() else 0.toDouble()
        a32 = if (view.etA32.text.isNotEmpty()) view.etA32.text.toString().trim()
            .toDouble() else 0.toDouble()
        a33 = if (view.etA33.text.isNotEmpty()) view.etA33.text.toString().trim()
            .toDouble() else 0.toDouble()
    }
}