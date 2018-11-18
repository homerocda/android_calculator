/**
 * Mobile Solutions Development - Fall 2018
 * PROG8170 - Software Quality Assurance Techniques
 * Assignment #3
 * Student: Homero Cardoso de Almeida
 * Student ID: 8155962
 */
package msd.prog8170.assignment3.newcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.text.DecimalFormat

/**
 * Available operations of the Calculator.
 */
enum class Operations {
    NOOP, ADD, SUB, MUL, DIV
}

/**
 * Android activity responsible for UI event handling
 */
class KeypadActivity : AppCompatActivity() {

    // The calculator
    private val calc = Calculator()
    // The  operation selected by the user
    private var currentOperation = Operations.NOOP
    // The number the user is typing on the screen
    private var currentOperand = ""
    // The result from the last operation
    private var lastResult = ""

    // The calculator display
    private val display : TextView
        get() = findViewById(R.id.tv_display)

    // Initializes the UI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keypad)
    }

    // Updates the display after key presses
    private fun updateDisplay() {
        display.text = currentOperand
    }

    // Adds a digit to the current operand
    private fun pushDigit(digit: Char) {
        val len = currentOperand.length
        if (len < 10) {
            // Avoid putting zeroes to the left
            currentOperand = if (currentOperand == "0") digit.toString() else currentOperand + digit
            updateDisplay()
        }
    }

    fun onDigit(view: View?) {
        // Check what digit was pressed
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
        // Check what operation was pressed
        when (view?.id) {
            R.id.op_add -> pushOperator(Operations.ADD)
            R.id.op_sub -> pushOperator(Operations.SUB)
            R.id.op_mul -> pushOperator(Operations.MUL)
            R.id.op_div -> pushOperator(Operations.DIV)
            // When the user presses the Equal button, execute the pushed operation
            // immediately
            R.id.equals -> doEquals()
        }
    }

    private fun pushOperator(operation: Operations) {
        // If the previous operation was not completed, then complete it
        if (currentOperation != Operations.NOOP) {
            doEquals()
        } else {
            // If there are no pending operations, push the current operand as the
            // last result and wait for the next operand
            lastResult = if (currentOperand.isNotEmpty()) currentOperand else lastResult
            currentOperand = ""
        }
        // set the selected operation as the next operation to be performed when the user
        // presses the equal button.
        currentOperation = operation
    }

    private fun getNumber(numStr: String) : Double {
        // Parses the number from a string. If the string is empty, then return 0.
        if (numStr.isEmpty()) {
            return 0.0
        }
        return numStr.toDouble()
    }

    // Executes the last selected operation
    private fun doEquals() {
        // If the user has not entered any new number...
        if (currentOperand.isEmpty()) {
            // ... and no operation was done previously...
            if (lastResult.isEmpty()) {
                // ... then we can't do anything.
                return
            }
            // Otherwise, use the last result as the second operand.
            currentOperand = lastResult
        }
        // Compute the result fom the current operation
        var result = 0.0
        when(currentOperation) {
            Operations.ADD -> result = calc.addition(getNumber(lastResult), getNumber(currentOperand))
            Operations.SUB -> result = calc.subtraction(getNumber(lastResult), getNumber(currentOperand))
            Operations.MUL -> result = calc.multiplication(getNumber(lastResult), getNumber(currentOperand))
            Operations.DIV -> result = calc.division(getNumber(lastResult), getNumber(currentOperand))
        }
        // Put the result in a string with the correct format
        val numberFormat = DecimalFormat("#.#########")
        lastResult = numberFormat.format(result)
        currentOperand = ""
        // Update the UI with the result
        display.text = lastResult
        // Reset the current operation
        currentOperation = Operations.NOOP
    }
}
