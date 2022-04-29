package com.vortex.soft.sellproducts.enter.login.signin

import android.content.Context
import android.os.Bundle
import android.view.View
import com.vortex.soft.sellproducts.base.presentation.base.BaseFragment
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.observeOnce
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.viewModelInit
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.signin.SigninDto
import com.vortex.soft.sellproducts.domain.dto.signin.SigninResponseDto
import com.vortex.soft.sellproducts.enter.R
import com.vortex.soft.sellproducts.enter.login.LoginActivity
import com.vortex.soft.sellproducts.presentation.validation.Validator
import com.vortex.soft.sellproducts.presentation.validation.rules.common.NotEmptyRule
import com.vortex.soft.sellproducts.presentation.validation.validations.TextInputLayoutValidation
import kotlinx.android.synthetic.main.button_login_layout.*
import kotlinx.android.synthetic.main.fragment_signin_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SigninFragment : BaseFragment() {

    lateinit var userNameValidation: TextInputLayoutValidation
    lateinit var passwordValidation: TextInputLayoutValidation

    private val signinViewModel: SigninViewModel by viewModel()

    val validator = Validator.with(object : Validator.OnValidateListener {
        override fun onValidateSuccess(values: List<String>) {
            startSignin()
        }
        override fun onValidateFailed(errors: List<String>) {
        }
    })

    override fun layoutId(): Int = R.layout.fragment_signin_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        initializeViewModel()
    }

    override fun initializeViews(view: View) {
        initValidations()
        loginButton.setOnClickListener {
            validator.validate(userNameValidation, passwordValidation)
        }

        forgotButton.setOnClickListener {
            //Navigation.findNavController(it).navigate(R.id.forgotFragment)
        }
    }

    override fun initializeViewModel() {
        viewModelInit(signinViewModel) {
            observeOnce(signinResponseLiveData, ::handleSigninResponse)
            observeOnce(failureData, ::handleError)
        }
    }

    private fun initValidations() {
        userNameValidation = TextInputLayoutValidation(userNameLoginInput, userNameLoginInputLayout)
                .add(NotEmptyRule(getErrorNoEmptyField(requireContext(), getString(R.string.login_field_user_name))))

        passwordValidation = TextInputLayoutValidation(passwordLoginInput, passwordLoginInputLayout)
                .add(NotEmptyRule(getErrorNoEmptyField(requireContext(), getString(R.string.login_field_password))))
    }

    private fun startSignin() {
        openPreloader()
        signinViewModel.login(getSigninDto())
    }

    private fun getSigninDto(): SigninDto {
        val userName = userNameLoginInput.text.toString()
        val password = passwordLoginInput.text.toString()
        return SigninDto(userName, password)
    }

    fun getErrorNoEmptyField(context: Context, fieldName: String): String {
        return String.format(context.getString(R.string.validate_empty_field), fieldName)
    }

    private fun handleSigninResponse(response: SigninResponseDto?) {
        closePreloader()
        response?.let {
            if(it.token.isNotEmpty()) {
                signinViewModel.setCurrentUserId("327")
                (activity as? LoginActivity)?.toMainBoard()
            }
        }
    }

    private fun handleError(fail: FailureType?) { closePreloader() }

    companion object {
        fun newInstance() = SigninFragment()
    }
}