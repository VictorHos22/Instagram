package com.example.olympik.register.presentation

import android.util.Patterns
import com.example.olympik.R
import com.example.olympik.register.RegisterAdm
import com.example.olympik.register.data.RegisterAdmRepository
import com.example.olympik.register.data.RegisterCallback

class RegisterAdmPresenter(
    private var view: RegisterAdm.View?,
    private var repository: RegisterAdmRepository
): RegisterAdm.Presenter {
    override fun create(
        name: String, cpf: String, phoneNumber: String, email: String, cnpj: String,
        businessName: String, fantasyName: String, cep: String, address: String, state: String,
        city: String, password: String, rePassword: String
    ) {
        val isNameValid = name.length >= 10
        val isCpfValid = cpf.length == 11
        val isPhoneNumberValid = phoneNumber.length == 11
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isCnpjValid = cnpj.length == 14
        val isBusinessNameValid = businessName.length >= 10
        val isFantasyNameValid = fantasyName.length >= 5
        val isCepValid = cep.length == 8
        val isAddressValid = address.length >=10
        val isStateValid = state.length >= 2
        val isCityValid = city.length >= 4
        val isPasswordValid = password.length >=6
        val isConfirmValid = password == rePassword

        if (!isNameValid){
            view?.displayNameFailure(R.string.invalid_name)
        } else {
            view?.displayNameFailure(null)
        }

        if (!isCpfValid){
            view?.displayCpfFailure(R.string.invalid_cpf)
        } else {
            view?.displayCpfFailure(null)
        }

        if (!isPhoneNumberValid){
            view?.displayPhoneNumber(R.string.invalid_phone)
        } else {
            view?.displayPhoneNumber(null)
        }

        if (!isEmailValid){
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if (!isCnpjValid){
            view?.displayCnpjFailure(R.string.invalid_cnpj)
        } else {
            view?.displayCnpjFailure(null)
        }

        if (!isBusinessNameValid){
            view?.displaybusinessNameFailure(R.string.invalid_business_name)
        } else {
            view?.displaybusinessNameFailure(null)
        }

        if (!isFantasyNameValid){
            view?.displayFantasyNameFailure(R.string.invalid_fantasy_name)
        } else {
            view?.displayFantasyNameFailure(null)
        }

        if (!isCepValid){
            view?.displayCepFailure(R.string.invalid_cep)
        } else {
            view?.displayCepFailure(null)
        }

        if (!isAddressValid){
            view?.displayAddressFailure(R.string.invalid_address)
        } else {
            view?.displayAddressFailure(null)
        }

        if (!isStateValid){
            view?.displayStateFailure(R.string.invalid_state)
        } else {
            view?.displayStateFailure(null)
        }

        if (!isCityValid){
            view?.displayCityFailure(R.string.invalid_city)
        } else {
            view?.displayCityFailure(null)
        }

        if (!isPasswordValid){
            view?.displayPasswordFailure(R.string.invalid_password)
        } else {
            view?.displayPasswordFailure(null)
        }

        if (!isConfirmValid){
            view?.displayRePasswordFailure(R.string.invalid_confirm)
        } else {
            view?.displayRePasswordFailure(null)
        }
        if (isNameValid && isCpfValid && isPhoneNumberValid && isEmailValid && isCnpjValid && isBusinessNameValid
            && isFantasyNameValid && isCepValid && isAddressValid && isStateValid && isCityValid
            && isPasswordValid && isConfirmValid){

            view?.showProgress(true)

            repository.create(name, cpf, phoneNumber, email, cnpj, businessName, fantasyName, cep,
            address, state, city, password, object: RegisterCallback{
                    override fun onSuccess() {
                        view?.onCreateSuccess()
                    }

                    override fun onFailure(message: String) {
                        view?.onCreateFailure(message)
                    }

                    override fun onComplete() {
                        view?.showProgress(false)
                    }

                })
        }
    }

    override fun onDestroy() {
        view = null
    }
}