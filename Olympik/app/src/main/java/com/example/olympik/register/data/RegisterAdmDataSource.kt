package com.example.olympik.register.data

interface RegisterAdmDataSource {
    fun create(name: String, cpf: String, phoneNumber: String, email: String, cnpj: String,
               businessName:String, fantasyName: String, cep: String, address: String, state: String, city: String, password: String, callback: RegisterCallback)
}