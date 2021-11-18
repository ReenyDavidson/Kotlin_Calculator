package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val buttonClear = binding.button19
        val buttonDiv = binding.button21
        val buttonSeven = binding.button22
        val buttonEight = binding.button23
        val buttonNine = binding.button24
        val buttonMultiply = binding.button25
        val buttonFour = binding.button26
        val buttonFive = binding.button27
        val buttonSix = binding.button28
        val buttonSub = binding.button29
        val buttonOne = binding.button30
        val buttonTwo = binding.button31
        val buttonThree = binding.button32
        val buttonAdd = binding.button33
        val buttonZero = binding.button40
        val buttonDot = binding.button41
        val buttonPow = binding.button39
        val buttonEq = binding.button42
        val buttonBracketOpen = binding.button
        val buttonBracketClose = binding.button20
        val input = binding.textView
        val output =  binding.textView2


        buttonClear.setOnClickListener {
            input.text = ""
            output.text = ""
        }
        buttonOne.setOnClickListener {
            input.text = addInputText(buttonOne.text as String)
        }
        buttonTwo.setOnClickListener {
            input.text = addInputText(buttonTwo.text as String)
        }
        buttonThree.setOnClickListener {
            input.text = addInputText(buttonThree.text as String)
        }
        buttonFour.setOnClickListener {
            input.text = addInputText(buttonFour.text as String)
        }
        buttonFive.setOnClickListener {
            input.text = addInputText(buttonFive.text as String)
        }
        buttonSix.setOnClickListener {
            input.text = addInputText(buttonSix.text as String)
        }
        buttonSeven.setOnClickListener {
            input.text = addInputText(buttonSeven.text as String)
        }
        buttonEight.setOnClickListener {
            input.text = addInputText(buttonEight.text as String)
        }
        buttonNine.setOnClickListener {
            input.text = addInputText(buttonNine.text as String)
        }
        buttonZero.setOnClickListener {
            input.text = addInputText(buttonZero.text as String)
        }
        buttonAdd.setOnClickListener {
            input.text = addInputText(buttonAdd.text as String)
        }
        buttonSub.setOnClickListener {
            input.text = addInputText(buttonSub.text as String)
        }
        buttonDiv.setOnClickListener {
            input.text = addInputText(buttonDiv.text as String)
        }
        buttonMultiply.setOnClickListener {
            input.text = addInputText(buttonMultiply.text as String)
        }
        buttonDot.setOnClickListener {
            input.text = addInputText(buttonDot.text as String)
        }
        buttonPow.setOnClickListener {
            input.text = addInputText(buttonPow.text as String)
        }
        buttonBracketOpen.setOnClickListener {
            input.text = addInputText(buttonBracketOpen.text as String)
        }
        buttonBracketClose.setOnClickListener {
            input.text = addInputText(buttonBracketClose.text as String)
        }
        buttonEq.setOnClickListener {
            showResult()
        }

    }

    private fun addInputText(buttonValue: String): String {
        return "${binding.textView.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = binding.textView.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                binding.textView2.text = "Error"
                binding.textView2.setTextColor(ContextCompat.getColor(this, R.color.design_default_color_error))
            }
            else {
                // Show Result
                binding.textView2.text = DecimalFormat("0.######").format(result).toString()
                binding.textView2.setTextColor(ContextCompat.getColor(this, R.color.magenta))
            }
        }
        catch (e: Exception) {
            // Show Error Message
            binding.textView2.text = "Error"
            binding.textView2.setTextColor(ContextCompat.getColor(this, R.color.design_default_color_error))
        }
    }
}


