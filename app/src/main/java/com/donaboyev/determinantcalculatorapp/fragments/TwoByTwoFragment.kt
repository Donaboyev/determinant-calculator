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
import kotlinx.android.synthetic.main.fragment_two_by_two.view.*
import kotlin.math.hypot

class TwoByTwoFragment : Fragment() {
    private var a11: Double? = null
    private var a12: Double? = null
    private var a21: Double? = null
    private var a22: Double? = null

    private val args by navArgs<TwoByTwoFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_two_by_two, container, false)

        view.btnCalculate.setOnClickListener {
            getInputs(view)
            val result = a11!! * a22!! - a12!! * a21!!
            view.tvResult.text = "$result"
        }

        view.btnReset.setOnClickListener {
            view.etA11.setText("")
            view.etA12.setText("")
            view.etA21.setText("")
            view.etA22.setText("")
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
        a21 = if (view.etA21.text.isNotEmpty()) view.etA21.text.toString().trim()
            .toDouble() else 0.toDouble()
        a22 = if (view.etA22.text.isNotEmpty()) view.etA22.text.toString().trim()
            .toDouble() else 0.toDouble()
    }
}