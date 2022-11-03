package com.example.olympik.register

import com.example.olympik.common.base.BasePresenter
import com.example.olympik.common.base.BaseView

interface RegisterAdm {
    interface Presenter: BasePresenter{
        fun create(name: String, cpf: String, phoneNumber: String, email: String, cnpj: String,
                   businessName:String, fantasyName: String, cep: String, address: String, state: String, city: String, password: String, rePassword: String)
    }
    interface View : BaseView<Presenter> {
        fun showProgress(enabled : Boolean)
        fun displayNameFailure(nameError: Int?)
        fun displayCpfFailure(cpfError: Int?)
        fun displayPhoneNumber(phoneNumberError: Int?)
        fun displayEmailFailure(emailError: Int?)
        fun displayCnpjFailure(cnpjError: Int?)
        fun displaybusinessNameFailure(businessNameError: Int?)
        fun displayFantasyNameFailure(fantasyNameError: Int?)
        fun displayCepFailure(cepError: Int?)
        fun displayAddressFailure(addressError: Int?)
        fun displayStateFailure(stateError: Int?)
        fun displayCityFailure(cityError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun displayRePasswordFailure(rePasswordError: Int?)
        fun onCreateSuccess()
        fun onCreateFailure(message : String)
    }
}