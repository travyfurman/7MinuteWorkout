package com.example.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.a7minuteworkout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    companion object {
        private const val METRIC_UNITS_VIEW = "Metric Unit View"
        private const val IMPERIAL_UNITS_VIEW = "Imperial Unit View"
    }
    private var currentVisibleView: String = METRIC_UNITS_VIEW

    private var binding: ActivityBmiBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarBmiActivity)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "Calculate BMI"
        }

        binding?.toolbarBmiActivity?.setNavigationOnClickListener{
            onBackPressed()
        }

        makeVisibleMetricUnitsView()

        binding?.rgUnits?.setOnCheckedChangeListener{ _, checkedId: Int ->

            if(checkedId == R.id.rbMetricUnits){
                makeVisibleMetricUnitsView()
            }else{
                makeVisibleImperialUnitsView()
            }

        }

        binding?.btnCalculate?.setOnClickListener{
            if(validateMetricUnits()){
                val heightValue: Float = binding?.etMetricUnitHeight?.text.toString().toFloat() / 100
                val weightValue: Float = binding?.etMetricUnitWeight?.text.toString().toFloat()
                val bmi: Float = weightValue / (heightValue*heightValue)

                displayBMIResult(bmi)
            }else if(validateImperialUnits()){
                val heightFeet: Float = binding?.etImperialFeet?.text.toString().toFloat() * 12
                val heightInches: Float = binding?.etImperialInches?.text.toString().toFloat()
                val weightPounds: Float = binding?.etImperialUnitWeight?.text.toString().toFloat()
                val bmi: Float = weightPounds / ((heightFeet + heightInches) * (heightFeet + heightInches)) * 703

                displayBMIResult(bmi)

            }else{

                Toast.makeText(this@BMIActivity, "Please enter valid values!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun makeVisibleMetricUnitsView(){
        currentVisibleView = METRIC_UNITS_VIEW
        binding?.tilMetricUnitHeight?.visibility = View.VISIBLE
        binding?.tilMetricUnitWeight?.visibility = View.VISIBLE
        binding?.tilImperialUnitWeight?.visibility = View.GONE
        binding?.tilImperialUnitHeight?.visibility = View.GONE
        binding?.tilImperialUnitHeightInches?.visibility = View.GONE

        binding?.etMetricUnitHeight?.text!!.clear()
        binding?.etMetricUnitWeight?.text!!.clear()

        binding?.llDisplayBMIResult?.visibility = View.INVISIBLE
    }

    private fun makeVisibleImperialUnitsView(){
        currentVisibleView = IMPERIAL_UNITS_VIEW
        binding?.tilImperialUnitWeight?.visibility = View.VISIBLE
        binding?.tilImperialUnitHeight?.visibility = View.VISIBLE
        binding?.tilImperialUnitHeightInches?.visibility = View.VISIBLE
        binding?.tilMetricUnitWeight?.visibility = View.INVISIBLE
        binding?.tilMetricUnitHeight?.visibility = View.INVISIBLE

        binding?.etImperialFeet?.text!!.clear()
        binding?.etImperialInches?.text!!.clear()
        binding?.etImperialUnitWeight?.text!!.clear()

        binding?.llDisplayBMIResult?.visibility =View.INVISIBLE

    }

    private fun displayBMIResult(bmi: Float){

        val bmiLabel: String
        val bmiDescription: String

        if(bmi.compareTo(15f) <= 0){
            bmiLabel = "Very severely underweight"
            bmiDescription = "Oops! You need to take better care of yourself. Eat some more!"
        }else if(bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0){
            bmiLabel = "Severely underweight"
            bmiDescription = "Oops! You need to take better care of yourself. Eat some more!"
        }else if(bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0) {
            bmiLabel = "Underweight"
            bmiDescription = "Oops! You need to take better care of yourself. Eat some more!"
        }else if(bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0) {
            bmiLabel = "Normal"
            bmiDescription = "Congratulations! You are in good shape."
        }else if(bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0) {
            bmiLabel = "Overweight"
            bmiDescription = "Oops! You need to take better care of yourself. Work out some more!"
        }else if(bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0) {
            bmiLabel = "Moderately obese"
            bmiDescription = "Oops! You need to take better care of yourself. Work out some more!"
        }else if(bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0) {
            bmiLabel = "Severely obese"
            bmiDescription = "You are in dangerous condition! Act now!"
        }else{
            bmiLabel = "Very severely obese"
            bmiDescription = "You are in dangerous condition! Act now!"
        }

        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        binding?.llDisplayBMIResult?.visibility = View.VISIBLE
        binding?.tvBMIValue?.text = bmiValue
        binding?.tvBMIType?.text = bmiLabel
        binding?.tvBMIDescription?.text = bmiDescription

    }

    private fun validateMetricUnits():Boolean{
        var isValid = true

        if(binding?.etMetricUnitWeight?.text.toString().isEmpty()){
            isValid = false
        }else if(binding?.etMetricUnitHeight?.text.toString().isEmpty()){
            isValid = false
        }

        return isValid
    }
    private fun validateImperialUnits():Boolean{
        var isValid = true

        if (binding?.etImperialUnitWeight?.text.toString().isEmpty()){
            isValid = false
        }else if(binding?.etImperialFeet?.text.toString().isEmpty()){
            isValid = false
        }else if(binding?.etImperialInches?.text.toString().isEmpty()){
            isValid = false
        }

        return isValid
    }

}