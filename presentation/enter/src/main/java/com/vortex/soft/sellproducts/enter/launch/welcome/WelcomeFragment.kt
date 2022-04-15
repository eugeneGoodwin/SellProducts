package com.vortex.soft.sellproducts.enter.launch.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vortex.soft.sellproducts.enter.R
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        welcomeLogInButton.setOnClickListener {
            (activity as WelcomeActivity?)?.toLogin()
        }

        welcomeEnrollButton.setOnClickListener {
            (activity as WelcomeActivity?)?.toRegistration()
        }
    }

    companion object {
        fun newInstance() = WelcomeFragment()
    }
}