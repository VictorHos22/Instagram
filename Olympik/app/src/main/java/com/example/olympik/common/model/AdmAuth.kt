package com.example.olympik.common.model

data class AdmAuth(
    val uuid: String,
    val name: String,
    val cpf: String,
    val phoneNumber: String,
    val email: String,
    val cnpj: String,
    val businessName: String,
    val fantasyName: String,
    val cep: String,
    val address: String,
    val state: String,
    val city: String,
    val password: String
)
