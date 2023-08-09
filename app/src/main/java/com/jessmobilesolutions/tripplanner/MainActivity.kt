package com.jessmobilesolutions.tripplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jessmobilesolutions.tripplanner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnCalculate) {
            calculate()
        }
    }

    private fun isValidate(): Boolean {
        return (binding.editDistance.text.toString() != "" &&
                binding.editPrice.text.toString() != "" &&
                binding.editAutonomy.text.toString() != "" &&
                binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate() {
        if (isValidate()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            val totalValue = (distance * price) / autonomy
            binding.textResult.text = "%.2f".format(totalValue)
        } else
            Toast.makeText(this, "Fill in all fields.", Toast.LENGTH_SHORT).show()
    }
}