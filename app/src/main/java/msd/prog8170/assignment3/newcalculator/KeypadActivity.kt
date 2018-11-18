package msd.prog8170.assignment3.newcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.text.DecimalFormat

enum class Operations {
    NOOP, ADD, SUB, MUL, DIV
}

class KeypadActivity : AppCompatActivity() {

    private val calc = Calculator()
    private var currentOperation = Operations.NOOP
    private var currentOperand = ""
    private var lastResult = ""

    private val display : TextView
        get() = findViewById(R.id.tv_display)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keypad)
    }

    private fun updateDisplay() {
        display.text = currentOperand
    }

    private fun pushDigit(digit: Char) {
        val len = currentOperand.length
        if (len < 10) {
            currentOperand = if (currentOperand == "0") digit.toString() else currentOperand + digit
            updateDisplay()
        }
    }

    fun onDigit(view: View?) {
        when (view?.id) {
            R.id.digit_0 -> pushDigit('0')
            R.id.digit_1 -> pushDigit('1')
            R.id.digit_2 -> pushDigit('2')
            R.id.digit_3 -> pushDigit('3')
            R.id.digit_4 -> pushDigit('4')
            R.id.digit_5 -> pushDigit('5')
            R.id.digit_6 -> pushDigit('6')
            R.id.digit_7 -> pushDigit('7')
            R.id.digit_8 -> pushDigit('8')
            R.id.digit_9 -> pushDigit('9')
            R.id.dot -> pushDigit('.')
        }
    }

    fun onOperator(view: View?) {
        when (view?.id) {
            R.id.op_add -> pushOperator(Operations.ADD)
            R.id.op_sub -> pushOperator(Operations.SUB)
            R.id.op_mul -> pushOperator(Operations.MUL)
            R.id.op_div -> pushOperator(Operations.DIV)
            R.id.equals -> doEquals()
        }
    }

    private fun pushOperator(operation: Operations) {
        if (currentOperation != Operations.NOOP) {
            doEquals()
        } else {
            lastResult = if (currentOperand.isNotEmpty()) currentOperand else lastResult
            currentOperand = ""
        }
        currentOperation = operation
    }

    private fun getNumber(numStr: String) : Double {
        if (numStr.isEmpty()) {
            return 0.0
        }
        return numStr.toDouble()
    }

    private fun doEquals() {
        if (currentOperand.isEmpty()) {
            if (lastResult.isEmpty()) {
                return
            }
            currentOperand = lastResult
        }
        var result = 0.0
        when(currentOperation) {
            Operations.ADD -> result = calc.addition(getNumber(lastResult), getNumber(currentOperand))
            Operations.SUB -> result = calc.subtraction(getNumber(lastResult), getNumber(currentOperand))
            Operations.MUL -> result = calc.multiplication(getNumber(lastResult), getNumber(currentOperand))
            Operations.DIV -> result = calc.division(getNumber(lastResult), getNumber(currentOperand))
        }
        val numberFormat = DecimalFormat("#.#########")
        lastResult = numberFormat.format(result)
        currentOperand = ""
        display.text = lastResult
        currentOperation = Operations.NOOP
    }
}
