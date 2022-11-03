package com.example.olympik.register.data

interface RegisterStudentFirstMeasurementsDataSource {
    fun create(weight: String, height: String, chest: String, shoulder: String, leftArm: String,
               rightArm: String, abdomen: String, leftThighs: String, rightThighs: String,
               leftCalves: String, rightCalves: String, callback: RegisterCallback)
}