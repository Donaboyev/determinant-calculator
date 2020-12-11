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
import kotlinx.android.synthetic.main.fragment_four_by_four.view.*
import kotlinx.android.synthetic.main.fragment_three_by_three.view.btnCalculate
import kotlinx.android.synthetic.main.fragment_three_by_three.view.btnReset
import kotlinx.android.synthetic.main.fragment_three_by_three.view.etA11
import kotlinx.android.synthetic.main.fragment_three_by_three.view.etA12
import kotlinx.android.synthetic.main.fragment_three_by_three.view.etA13
import kotlinx.android.synthetic.main.fragment_three_by_three.view.etA21
import kotlinx.android.synthetic.main.fragment_three_by_three.view.etA22
import kotlinx.android.synthetic.main.fragment_three_by_three.view.etA23
import kotlinx.android.synthetic.main.fragment_three_by_three.view.etA31
import kotlinx.android.synthetic.main.fragment_three_by_three.view.etA32
import kotlinx.android.synthetic.main.fragment_three_by_three.view.etA33
import kotlinx.android.synthetic.main.fragment_three_by_three.view.tvResult
import kotlin.math.hypot

class FourByFourFragment : Fragment() {
    private var a11: Double? = null
    private var a12: Double? = null
    private var a13: Double? = null
    private var a14: Double? = null
    private var a21: Double? = null
    private var a22: Double? = null
    private var a23: Double? = null
    private var a24: Double? = null
    private var a31: Double? = null
    private var a32: Double? = null
    private var a33: Double? = null
    private var a34: Double? = null
    private var a41: Double? = null
    private var a42: Double? = null
    private var a43: Double? = null
    private var a44: Double? = null

    private val args by navArgs<FourByFourFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_four_by_four, container, false)

        view.btnCalculate.setOnClickListener {
            getInputs(view)
            val det1 =
                a22!! * a33!! * a44!! + a23!! * a34!! * a42!! + a32!! * a43!! * a24!! - (a42!! * a33!! * a24!! + a32!! * a23!! * a44!! + a34!! * a43!! * a22!!)
            val det2 =
                a21!! * a33!! * a44!! + a23!! * a34!! * a41!! + a31!! * a43!! * a24!! - (a41!! * a33!! * a24!! + a31!! * a23!! * a44!! + a43!! * a34!! * a21!!)
            val det3 =
                a21!! * a32!! * a44!! + a22!! * a34!! * a41!! + a31!! * a42!! * a24!! - (a41!! * a32!! * a24!! + a42!! * a34!! * a21!! + a31!! * a22!! * a44!!)
            val det4 =
                a21!! * a32!! * a43!! + a22!! * a33!! * a41!! + a31!! * a42!! * a23!! - (a41!! * a32!! * a23!! + a42!! * a33!! * a21!! + a31!! * a22!! * a43!!)
            val result = a11!! * det1 - a12!! * det2 + a13!! * det3 - a14!! * det4
            view.tvResult.text = "$result"
        }

        view.btnReset.setOnClickListener {
            view.etA11.setText("")
            view.etA12.setText("")
            view.etA13.setText("")
            view.etA14.setText("")
            view.etA21.setText("")
            view.etA22.setText("")
            view.etA23.setText("")
            view.etA24.setText("")
            view.etA31.setText("")
            view.etA32.setText("")
            view.etA33.setText("")
            view.etA34.setText("")
            view.etA41.setText("")
            view.etA42.setText("")
            view.etA43.setText("")
            view.etA44.setText("")
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
        a14 = if (view.etA14.text.isNotEmpty()) view.etA14.text.toString().trim()
            .toDouble() else 0.toDouble()
        a21 = if (view.etA21.text.isNotEmpty()) view.etA21.text.toString().trim()
            .toDouble() else 0.toDouble()
        a22 = if (view.etA22.text.isNotEmpty()) view.etA22.text.toString().trim()
            .toDouble() else 0.toDouble()
        a23 = if (view.etA23.text.isNotEmpty()) view.etA23.text.toString().trim()
            .toDouble() else 0.toDouble()
        a24 = if (view.etA24.text.isNotEmpty()) view.etA24.text.toString().trim()
            .toDouble() else 0.toDouble()
        a31 = if (view.etA31.text.isNotEmpty()) view.etA31.text.toString().trim()
            .toDouble() else 0.toDouble()
        a32 = if (view.etA32.text.isNotEmpty()) view.etA32.text.toString().trim()
            .toDouble() else 0.toDouble()
        a33 = if (view.etA33.text.isNotEmpty()) view.etA33.text.toString().trim()
            .toDouble() else 0.toDouble()
        a34 = if (view.etA34.text.isNotEmpty()) view.etA34.text.toString().trim()
            .toDouble() else 0.toDouble()
        a41 = if (view.etA41.text.isNotEmpty()) view.etA41.text.toString().trim()
            .toDouble() else 0.toDouble()
        a42 = if (view.etA42.text.isNotEmpty()) view.etA42.text.toString().trim()
            .toDouble() else 0.toDouble()
        a43 = if (view.etA43.text.isNotEmpty()) view.etA43.text.toString().trim()
            .toDouble() else 0.toDouble()
        a44 = if (view.etA44.text.isNotEmpty()) view.etA44.text.toString().trim()
            .toDouble() else 0.toDouble()
    }
}