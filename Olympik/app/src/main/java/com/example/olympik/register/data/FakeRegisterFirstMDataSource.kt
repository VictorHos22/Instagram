package com.example.olympik.register.data

import android.os.Handler
import android.os.Looper
import com.example.olympik.common.model.Database

class FakeRegisterFirstMDataSource: RegisterStudentFirstMeasurementsDataSource {
    override fun create(weight: String, height: String, chest: String, shoulder: String,
        leftArm: String, rightArm: String, abdomen: String, leftThighs: String,
        rightThighs: String, leftCalves: String, rightCalves: String, callback: RegisterCallback
    ) {

    }
}