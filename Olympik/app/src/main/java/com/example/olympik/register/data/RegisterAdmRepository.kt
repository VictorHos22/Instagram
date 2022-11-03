package com.example.olympik.register.data

class RegisterAdmRepository(private val dataSource: RegisterAdmDataSource) {
    fun create(name: String, cpf: String, phoneNumber: String, email: String, cnpj: String,
               businessName:String, fantasyName: String, cep: String, address: String, state: String, city: String, password: String, callback: RegisterCallback){
        dataSource.create(name, cpf, phoneNumber, email, cnpj, businessName, fantasyName, cep, address, state, city, password, callback)
    }

}