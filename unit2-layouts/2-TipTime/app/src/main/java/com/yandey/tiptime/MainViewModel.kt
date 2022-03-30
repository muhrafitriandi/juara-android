package com.yandey.tiptime

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var tip = 0.0
    fun calculateTip(tipPercentage: Double, cost: Double) {
        tip = tipPercentage * cost
    }
}