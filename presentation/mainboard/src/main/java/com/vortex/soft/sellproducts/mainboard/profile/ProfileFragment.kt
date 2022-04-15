package com.vortex.soft.sellproducts.mainboard.profile

import android.os.Bundle
import android.view.View
import com.vortex.soft.sellproducts.base.presentation.base.BaseFragment
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.hide
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.observeOnce
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.show
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.viewModelInit
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.user.UserDto
import com.vortex.soft.sellproducts.mainboard.R
import kotlinx.android.synthetic.main.fragment_catalog.mainLayout
import kotlinx.android.synthetic.main.fragment_catalog.preloaderLayout
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment(), AndroidScopeComponent {

    override val scope by fragmentScope()

    private val profileViewModel: ProfileViewModel by viewModel()

    override fun layoutId(): Int = R.layout.fragment_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        initializeViewModel()
    }

    override fun initializeViews(view: View) {
        getUser()
    }

    private fun getUser() {
        openPreloader()
        profileViewModel.getUser(1)
    }

    override fun initializeViewModel() {
        viewModelInit(profileViewModel) {
            observeOnce(user, ::handleUser)
            observeOnce(failureData, ::handleError)
        }
    }

    private fun handleUser(userDto: UserDto?) {
        closePreloader()
        userDto?.let { initProfile(it) }
    }

    private fun initProfile(user: UserDto) {
        nameUserInfo.text = user.name
        surnameUserInfo.text = user.surname
        emailInfo.text = user.email
        locationInfo.text = user.location
    }

    private fun handleError(fail: FailureType?) {
        closePreloader()
    }

    override fun openPreloader() {
        preloaderLayout.show()
        mainLayout.hide()
    }

    override fun closePreloader() {
        preloaderLayout.hide()
        mainLayout.show()
    }
}