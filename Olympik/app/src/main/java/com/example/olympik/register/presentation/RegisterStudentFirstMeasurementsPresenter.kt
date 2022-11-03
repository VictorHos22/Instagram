package com.example.olympik.register.presentation

import com.example.olympik.R
import com.example.olympik.register.RegisterStudent
import com.example.olympik.register.RegisterStudentFirstMeasurements
import com.example.olympik.register.data.RegisterCallback
import com.example.olympik.register.data.RegisterStudentFirstMeasurementsRepository

class RegisterStudentFirstMeasurementsPresenter(
    private var view: RegisterStudentFirstMeasurements.View?,
    private var repository: RegisterStudentFirstMeasurementsRepository
): RegisterStudentFirstMeasurements.Presenter {

    override fun create(
        weight: String, height: String, chest: String, shoulder: String, leftArm: String,
        rightArm: String, abdomen: String, leftThighs: String, rightThighs: String,
        leftCalves: String, rightCalves: String
    ) {
        val isWeightValid = weight.isNotEmpty()
        val isHeightValid = height.isNotEmpty()
        val isChestValid = chest.isNotEmpty()
        val isShoulderValid = shoulder.isNotEmpty()
        val isLeftArmValid = leftArm.isNotEmpty()
        val isRightArmValid = rightArm.isNotEmpty()
        val isAbdomenValid = abdomen.isNotEmpty()
        val isLeftThighsValid = leftThighs.isNotEmpty()
        val isRightThighsValid = rightThighs.isNotEmpty()
        val isLeftCalvesValid = leftCalves.isNotEmpty()
        val isRightCalvesValid = rightCalves.isNotEmpty()

        if(!isWeightValid){
            view?.displayWeightFailure(R.string.invalid_measurement)
        } else {
            view?.displayWeightFailure(null)
        }

        if(!isHeightValid){
            view?.displayHeightFailure(R.string.invalid_measurement)
        } else {
            view?.displayHeightFailure(null)
        }

        if(!isChestValid){
            view?.displayChestFailure(R.string.invalid_measurement)
        } else {
            view?.displayChestFailure(null)
        }

        if(!isShoulderValid){
            view?.displayShoulderFailure(R.string.invalid_measurement)
        } else {
            view?.displayShoulderFailure(null)
        }

        if(!isLeftArmValid){
            view?.displayLeftArmFailure(R.string.invalid_measurement)
        } else {
            view?.displayLeftArmFailure(null)
        }

        if(!isRightArmValid){
            view?.displayRightArmFailure(R.string.invalid_measurement)
        } else {
            view?.displayRightArmFailure(null)
        }

        if(!isAbdomenValid){
            view?.displayAbdomenFailure(R.string.invalid_measurement)
        } else {
            view?.displayAbdomenFailure(null)
        }

        if(!isLeftThighsValid){
            view?.displayLeftThighsFailure(R.string.invalid_measurement)
        } else {
            view?.displayLeftThighsFailure(null)
        }

        if(!isRightThighsValid){
            view?.displayRightThighsFailure(R.string.invalid_measurement)
        } else {
            view?.displayRightThighsFailure(null)
        }
        if(!isLeftCalvesValid){
            view?.displayLeftCalvesFailure(R.string.invalid_measurement)
        } else {
            view?.displayLeftCalvesFailure(null)
        }
        if(!isRightCalvesValid){
            view?.displayRightCalvesFailure(R.string.invalid_measurement)
        } else {
            view?.displayRightCalvesFailure(null)
        }

        if (isWeightValid && isHeightValid && isChestValid && isShoulderValid && isLeftArmValid
            && isRightArmValid && isAbdomenValid && isLeftThighsValid && isRightThighsValid &&
                isLeftCalvesValid && isRightCalvesValid){
            view?.showProgress(true)

            repository.create(weight, height, chest, shoulder, leftArm, rightArm, abdomen, leftThighs
            , rightThighs, leftCalves, rightCalves, object : RegisterCallback{
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