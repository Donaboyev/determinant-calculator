package com.donaboyev.determinantcalculatorapp.fragments

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.donaboyev.determinantcalculatorapp.R
import com.donaboyev.determinantcalculatorapp.data.Center
import com.donaboyev.determinantcalculatorapp.utils.findLocationOfCenterOnTheScreen
import com.donaboyev.determinantcalculatorapp.utils.startCircularReveal
import kotlinx.android.synthetic.main.dialog_info.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        setHasOptionsMenu(true)

        view.btnTwoByTwo.setOnClickListener {
            val center = it.findLocationOfCenterOnTheScreen()
            val action = MainFragmentDirections.actionMainFragmentToTwoByTwoFragment(center)
            Navigation.findNavController(view)
                .navigate(action)
        }
        view.btnThreeByThree.setOnClickListener {
            val center = it.findLocationOfCenterOnTheScreen()
            val action = MainFragmentDirections.actionMainFragmentToThreeByThreeFragment(center)
            Navigation.findNavController(view)
                .navigate(action)
        }
        view.btnFourByFour.setOnClickListener {
            val center = it.findLocationOfCenterOnTheScreen()
            val action = MainFragmentDirections.actionMainFragmentToFourByFourFragment(center)
            Navigation.findNavController(view)
                .navigate(action)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val width = Resources.getSystem().displayMetrics.widthPixels
        val height = Resources.getSystem().displayMetrics.heightPixels
        view.startCircularReveal(Center(width / 2, 0), height.toFloat())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.miInfo) openInfoDialog()
        return super.onOptionsItemSelected(item)
    }

    private fun openInfoDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_info)
        dialog.window?.setBackgroundDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.dialog_background
            )
        )
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.setCancelable(true)
        dialog.show()

        dialog.btnOk?.setOnClickListener {
            dialog.dismiss()
        }
    }
}