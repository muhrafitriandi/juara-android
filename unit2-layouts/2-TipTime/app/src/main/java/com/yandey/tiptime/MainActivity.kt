package com.yandey.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.yandey.tiptime.databinding.ActivityMainBinding
import com.yandey.tiptime.utils.AppUtils
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener { calculateTip() }
        displayResult()
    }

    private fun calculateTip() {
        val stringInTextField = binding.edCostOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            AppUtils.showToast(this, getString(R.string.cost_required))
            return
        } else {
            val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
                R.id.optionTwentyPercent -> 0.20
                R.id.optionEighteenPercent -> 0.18
                else -> 0.15
            }
            viewModel.calculateTip(tipPercentage, cost)
            if (binding.swRoundUpTip.isChecked) {
                viewModel.tip = ceil(viewModel.tip)
            }
            displayResult()
        }
    }

    private fun displayResult() {
        isZero()
        val formattedTip = NumberFormat.getCurrencyInstance().format(viewModel.tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }

    private fun isZero() {
        if (viewModel.tip.equals(0.0)) {
            binding.tipResult.visibility = View.INVISIBLE
        } else {
            binding.tipResult.visibility = View.VISIBLE
        }
    }
}