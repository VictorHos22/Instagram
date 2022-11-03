package com.example.olympik.register.data

class RegisterStudentFirstMeasurementsRepository (private val dataSource: RegisterStudentFirstMeasurementsDataSource){
    fun create(weight: String, height: String, chest: String, shoulder: String, leftArm: String,
    rightArm: String, abdomen: String, leftThighs: String, rightThighs: String, leftCalves: String,
               rightCalves: String, callback: RegisterCallback){
        dataSource.create(weight, height, chest, shoulder, leftArm, rightArm, abdomen, leftThighs,
            rightThighs, leftCalves, rightCalves, callback)
    }
}