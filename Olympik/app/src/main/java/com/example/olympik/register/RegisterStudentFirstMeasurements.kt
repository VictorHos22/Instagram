package com.example.olympik.register

import com.example.olympik.common.base.BasePresenter
import com.example.olympik.common.base.BaseView

interface RegisterStudentFirstMeasurements {
    interface Presenter: BasePresenter {
        fun create(weight: String, height: String, chest: String, shoulder: String, leftArm: String,
        rightArm: String, abdomen: String, leftThighs: String, rightThighs: String, leftCalves: String,
        rightCalves:String)
    }

    interface View: BaseView<Presenter>{
        fun showProgress(enabled: Boolean)
        fun onCreateSuccess()
        fun onCreateFailure(message: String)
        fun displayWeightFailure(weightError: Int?)
        fun displayHeightFailure(heightError: Int?)
        fun displayChestFailure(chestError: Int?)
        fun displayShoulderFailure(shoulderError: Int?)
        fun displayLeftArmFailure(leftArmError: Int?)
        fun displayRightArmFailure(rightArmError: Int?)
        fun displayAbdomenFailure(abdomenError: Int?)
        fun displayLeftThighsFailure(leftThighsError: Int?)
        fun displayRightThighsFailure(rightThighsError: Int?)
        fun displayLeftCalvesFailure(leftCalvesError: Int?)
        fun displayRightCalvesFailure(rightCalvesError: Int?)
    }
}