package com.example.olympik.register.data

import android.os.Looper
import com.example.olympik.common.model.AdmAuth
import com.example.olympik.common.model.Database
import com.example.olympik.common.model.UserAuth
import java.util.*
import java.util.logging.Handler

class FakeRegisterAdmDataSource : RegisterAdmDataSource {
    override fun create(
        name: String, cpf: String, phoneNumber: String, email: String, cnpj: String,
        businessName: String, fantasyName: String, cep: String, address: String, state: String,
        city: String, password: String, callback: RegisterCallback
    ) {
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            val admAuth = Database.admAuth.firstOrNull { email == it.email }

            if (admAuth != null){
                callback.onFailure("Usuário já cadastrado")
            } else {
                val newUser = AdmAuth(UUID.randomUUID().toString(),name,cpf, phoneNumber, email, cnpj, businessName, fantasyName,
                cep, address, state, city, password)
                val created = Database.admAuth.add(newUser)
                if (created){
                    Database.sessionAdmAuth = newUser
                    callback.onSuccess()
                } else {
                    callback.onFailure("Erro interno no servidor")
                }
            }

        }, 1000)

    }
}