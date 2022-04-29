package com.vortex.soft.sellproducts.enter.enroll.registration

import android.content.Context
import android.os.Bundle
import android.view.View
import com.vortex.soft.sellproducts.base.presentation.base.BaseFragment
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.observeOnce
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.viewModelInit
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.register.RegisterDto
import com.vortex.soft.sellproducts.enter.R
import com.vortex.soft.sellproducts.enter.enroll.EnrollActivity
import com.vortex.soft.sellproducts.enter.login.LoginActivity
import com.vortex.soft.sellproducts.presentation.validation.Validator
import com.vortex.soft.sellproducts.presentation.validation.rules.common.EqualTextInputEditTextRule
import com.vortex.soft.sellproducts.presentation.validation.rules.common.NotEmptyRule
import com.vortex.soft.sellproducts.presentation.validation.rules.regex.EmailRule
import com.vortex.soft.sellproducts.presentation.validation.validations.TextInputLayoutValidation
import kotlinx.android.synthetic.main.button_registration_layout.*
import kotlinx.android.synthetic.main.fragment_registration.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : BaseFragment() {

    lateinit var userNameValidation: TextInputLayoutValidation
    lateinit var emailValidation: TextInputLayoutValidation
    lateinit var passwordValidation: TextInputLayoutValidation
    lateinit var confirmPasswordValidation: TextInputLayoutValidation

    private val registerViewModel: RegistrationViewModel by viewModel()

    val validator = Validator.with(object : Validator.OnValidateListener {
        override fun onValidateSuccess(values: List<String>) {
            startRegister()
        }
        override fun onValidateFailed(errors: List<String>) {
        }
    })

    override fun layoutId(): Int = R.layout.fragment_registration

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        initializeViewModel()
    }

    override fun initializeViews(view: View) {
        initValidations()
        registerButton.setOnClickListener {
            validator.validate(userNameValidation, emailValidation, passwordValidation, confirmPasswordValidation)
        }
    }

    override fun initializeViewModel() {
        viewModelInit(registerViewModel) {
            observeOnce(registerResponseLiveData, ::handleRegisterResponse)
            observeOnce(failureData, ::handleError)
        }
    }

    private fun initValidations() {
        userNameValidation = TextInputLayoutValidation(nameRegisterInput, nameRegisterLayout)
                .add(NotEmptyRule(getErrorNoEmptyField(requireContext(), getString(R.string.enroll_register_name))))

        passwordValidation = TextInputLayoutValidation(passwordRegisterInput, passwordRegisterLayout)
                .add(NotEmptyRule(getErrorNoEmptyField(requireContext(), getString(R.string.enroll_register_password))))

        confirmPasswordValidation = TextInputLayoutValidation(passwordConfirmRegisterInput, passwordConfirmRegisterLayout)
                .add(NotEmptyRule(getErrorNoEmptyField(requireContext(), getString(R.string.enroll_register_confirm_password))))
                .add(EqualTextInputEditTextRule(passwordRegisterInput, getString(R.string.validate_repeat_password_no_match)))

        emailValidation = TextInputLayoutValidation(emailRegisterInput, emailRegisterLayout)
                .add(NotEmptyRule(getErrorNoEmptyField(requireContext(), getString(R.string.enroll_register_email))))
                .add(EmailRule(getErrorNoFormatField(requireContext(), getString(R.string.enroll_register_email))))
    }

    private fun startRegister() {
        openPreloader()
        registerViewModel.register(getRegisterDto())
    }

    private fun getRegisterDto(): RegisterDto {
        val userName = nameRegisterInput.text.toString()
        val email = emailRegisterInput.text.toString()
        val password: String = passwordRegisterInput.text.toString()
        val confirmPassword: String = passwordConfirmRegisterInput.text.toString()
        return RegisterDto(userName, email, password, confirmPassword)
    }

    fun getErrorNoEmptyField(context: Context, fieldName: String): String {
        return String.format(context.getString(R.string.validate_empty_field), fieldName)
    }

    fun getErrorNoFormatField(context: Context, fieldName: String): String {
        return String.format(context.getString(R.string.validate_no_format_field), fieldName)
    }

    private fun handleRegisterResponse(response: Boolean?) {
        closePreloader()
        response?.let { if(it) {
            registerViewModel.setCurrentUserId("333")
            (activity as? EnrollActivity)?.toMainBoard()
        } }
    }

    private fun handleError(fail: FailureType?) { closePreloader() }

    companion object {
        fun newInstance() = RegistrationFragment()
    }
}